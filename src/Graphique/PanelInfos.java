package Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import General.ObjetGeometrique;
import General.Point2D;
import ObjetsBasiques.Segment;

public class PanelInfos extends JPanel implements MouseListener, ListSelectionListener {

	// Attribut gestion des objets
	private JButton btnClear;
	private DefaultListModel<ObjetGeometrique> modelJList;
	private JTextArea txtObjet;
	private JList listeObjets;
	private Color oldColor;
	private int oldIndex;
	
	// Attributs panel options
	private JPanel pnlOptions; 
	private JButton btnDelete;
	private JButton btnMove;
	
	// Attributs des d�placements
	private ObjetGeometrique obj;
	private boolean canMove;
	
	public PanelInfos() {
		
		// Settings panel
		this.setPreferredSize( new Dimension(300,800) );
		this.setBackground( Color.GRAY );
		this.setLayout( new BorderLayout(10,10) );
		this.setBorder( new EmptyBorder(10,10,10,10) );
		
		// Parametres
		this.oldColor = Color.BLACK;
		this.oldIndex = -1;
		this.canMove = false;
		
		// Bouton clear
		btnClear = new JButton("Vider la zone de dessin");
		btnClear.setPreferredSize( new Dimension(300,100) );
		btnClear.setFont( new Font("Arial", Font.BOLD, 18) );
		btnClear.addMouseListener(this);
		this.add(btnClear, BorderLayout.SOUTH);
		
		// Label liste
		JLabel lblListe = new JLabel("Liste des formes g�om�triques");
		lblListe.setForeground(Color.BLACK);
		lblListe.setFont( new Font("Arial", Font.ITALIC, 16) );
		this.add(lblListe, BorderLayout.NORTH);
		
		// Information et options des formes
		JPanel pnlListe = new JPanel();
		pnlListe.setLayout( new BorderLayout() );
		
		// Liste
		modelJList = new DefaultListModel();
		listeObjets = new JList( modelJList );
		listeObjets.addListSelectionListener(this);
		JScrollPane scrollListe = new JScrollPane(listeObjets);
		scrollListe.setPreferredSize(new Dimension(300,300));
		pnlListe.add(scrollListe, BorderLayout.NORTH);
		
		// Texte
		txtObjet = new JTextArea();
		txtObjet.setPreferredSize(new Dimension(300,150));
		txtObjet.setEditable(false);
		txtObjet.setText( "Rien � afficher !  \nS�lectionnez une figure dans la liste ci-dessus" );
		txtObjet.setLineWrap(true);
		pnlListe.add(txtObjet, BorderLayout.CENTER);
		
		// Options
		pnlOptions = new JPanel();
		
		btnDelete = new JButton("Supprimer");
		btnDelete.setBackground( Color.RED );
		btnDelete.setForeground( Color.WHITE );
		btnDelete.setFocusable(false);
		btnDelete.addMouseListener(this);
		pnlOptions.add(btnDelete);
		
		btnMove = new JButton("D�placer");
		btnMove.setBackground( Color.BLUE );
		btnMove.setForeground( Color.WHITE );
		btnMove.setFocusable(false);
		btnMove.addMouseListener(this);
		pnlOptions.add(btnMove);
		
		pnlListe.add(pnlOptions, BorderLayout.SOUTH);
		
		this.add(pnlListe, BorderLayout.CENTER);
	}
	
	public void refreshInfos(ArrayList<ObjetGeometrique> T) {
		
		modelJList.clear();
		
		Iterator<ObjetGeometrique> iter = T.iterator();
		
		while (iter.hasNext()) {
			
			modelJList.addElement( iter.next() );
		}
	}

	public void valueChanged(ListSelectionEvent e) {
		
		PanelDessin pnlD = (PanelDessin) this.getParent().getComponent(2);
		ArrayList<ObjetGeometrique> T = pnlD.getObjets();
		int i = listeObjets.getSelectedIndex();
		
		// Affichage texte
		
		if ( listeObjets.isSelectionEmpty() ) {
			
			txtObjet.setText( "Rien � afficher ! S�lectionnez une figure dans la liste ci-dessus" );
		}
		else {
			
			// Retour au statut "Aucun"
			this.resetSelection();
			
			// Affichage des infos
			String txt = T.get( i ).infosObjet();
			txtObjet.setText(txt);
			
			// Coloration
			if ( oldIndex != -1 ) {
					
				T.get( oldIndex ).setCouleur( oldColor ); 
			}
			
			oldColor = T.get( i ).getCouleur();
			oldIndex = i ;
			
			T.get( i ).setCouleur( Color.RED );
			pnlD.refreshDessin();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		PanelDessin pnlD = (PanelDessin) this.getParent().getComponent(2);
		
		// Vider la zone de dessin
		if (e.getSource() == this.btnClear) {
			
			// Retour au statut "Aucun"
			this.resetSelection();
			
			// On r�cup�re le panel de dessin
			
			pnlD.getObjets().clear(); // Vide l'array list
			
			pnlD.repaint();
			modelJList.clear();
			oldColor = Color.BLACK;
			oldIndex = -1;
		}
		
		// Supprimer un item
		if (e.getSource() == this.btnDelete) {
			
			// Retour au statut "Aucun"
			this.resetSelection();
			
			if (this.listeObjets.isSelectionEmpty() == false ) {
				
				ArrayList<ObjetGeometrique> T = pnlD.getObjets();
				
				if ( this.listeObjets.getSelectedIndex() == oldIndex ) {
					
					oldIndex--;
				}
				
				T.remove( this.listeObjets.getSelectedValue() );
				
				this.refreshInfos(T);
				pnlD.refreshDessin();
			}
		}
		
		// D�placer un item
		if (e.getSource() == this.btnMove) {
			
			if (this.listeObjets.isSelectionEmpty() == false) {
				
				obj = (ObjetGeometrique) listeObjets.getSelectedValue();
				
				pnlD.setDeplacement( true );
				pnlD.setObj(obj);
			}
		}
	}

	public void resetSelection() {
		
		JPanel pnlBoutons = ((JPanel) ((PanelSelection) this.getParent()	
				.getComponent(0))
				.getComponent(0));

		BoutonOutil btn = (BoutonOutil) pnlBoutons
						.getComponent( pnlBoutons.getComponentCount()-1 );
		
		btn.actionPerformed( new ActionEvent(btn, 0, null) );
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
