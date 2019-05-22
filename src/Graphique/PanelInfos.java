package Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class PanelInfos extends JPanel implements ActionListener, ListSelectionListener {

	private JButton btnClear;
	private String content;
	private DefaultListModel<ObjetGeometrique> modelJList;
	private JTextArea txtObjet;
	private JList listeObjets;
	private Color oldColor;
	private int oldIndex;
	
	public PanelInfos() {
		
		// Settings panel
		this.setPreferredSize( new Dimension(300,800) );
		this.setBackground( Color.GRAY );
		this.setLayout( new BorderLayout(10,10) );
		this.setBorder( new EmptyBorder(10,10,10,10) );
		
		// Parametres
		this.oldColor = null;
		this.oldIndex = -1;
		
		// Bouton clear
		btnClear = new JButton("Vider la zone de dessin");
		btnClear.setPreferredSize( new Dimension(300,100) );
		btnClear.setFont( new Font("Arial", Font.BOLD, 18) );
		btnClear.addActionListener(this);
		this.add(btnClear, BorderLayout.SOUTH);
		
		// Label liste
		JLabel lblListe = new JLabel("Liste des formes géométriques");
		lblListe.setForeground(Color.BLACK);
		lblListe.setFont( new Font("Arial", Font.ITALIC, 16) );
		this.add(lblListe, BorderLayout.NORTH);
		
		// Liste formes
		JPanel pnlListe = new JPanel();
		pnlListe.setLayout( new BorderLayout() );
		
		modelJList = new DefaultListModel();
		listeObjets = new JList( modelJList );
		listeObjets.addListSelectionListener(this);
		JScrollPane scrollListe = new JScrollPane(listeObjets);
		pnlListe.add(scrollListe, BorderLayout.CENTER);
		
		txtObjet = new JTextArea();
		txtObjet.setPreferredSize(new Dimension(300,150));
		txtObjet.setEditable(false);
		txtObjet.setText( "Rien à afficher !  \nSélectionnez une figure dans la liste ci-dessus" );
		txtObjet.setLineWrap(true);
		pnlListe.add(txtObjet, BorderLayout.SOUTH);
		
		this.add(pnlListe, BorderLayout.CENTER);
	}
	
	public void refreshInfos(ArrayList<ObjetGeometrique> T) {
		
		modelJList.clear();
		
		Iterator<ObjetGeometrique> iter = T.iterator();
		
		while (iter.hasNext()) {
			
			modelJList.addElement( iter.next() );
		}
	}

	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == this.btnClear) {
			
			// On récupère le panel de dessin
			PanelDessin pnl = (PanelDessin) this.getParent().getComponent(2);
			
			pnl.getObjets().clear(); // Vide l'array list
			
			pnl.repaint();
			modelJList.clear();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		PanelDessin pnl = (PanelDessin) this.getParent().getComponent(2);
		ArrayList<ObjetGeometrique> T = pnl.getObjets();
		int i = listeObjets.getSelectedIndex();
		
		if ( listeObjets.isSelectionEmpty() ) {
			
			txtObjet.setText( "Rien à afficher ! Sélectionnez une figure dans la liste ci-dessus" );
		}
		else {
			
			// Affichage des infos
			String txt = T.get( i ).infosObjet();
			txtObjet.setText(txt);
			
			// Coloration
			
			if ( oldColor != null && oldIndex != -1 ) {
				
				T.get( oldIndex ).setCouleur( oldColor ); 
				System.out.println("hehe");
			}
			
			oldColor = T.get( i ).getCouleur();
			oldIndex = i ;
			
			T.get( i ).setCouleur( Color.RED );
			pnl.refreshDessin();
		}
	}
}
