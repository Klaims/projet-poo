package Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import General.ObjetBasique;
import General.ObjetComposite;
import General.ObjetGeometrique;
import General.Point2D;
import ObjetsBasiques.ArcCercle;
import ObjetsBasiques.Cercle;
import ObjetsBasiques.Ellipse;
import ObjetsBasiques.Losange;
import ObjetsBasiques.Quadrangle;
import ObjetsBasiques.Rectangle;
import ObjetsBasiques.Segment;
import ObjetsBasiques.Triangle;

public class PanelInfos extends JPanel implements MouseListener, ListSelectionListener {

	// Attribut gestion des objets
	private JButton btnClear;
	private JButton btnSave;
	private JButton btnLoad;
	private DefaultListModel<ObjetGeometrique> modelJList;
	private JTextArea txtObjet;
	private JList listeObjets;
	private Color oldColor;
	private int oldIndex;
	
	// Attributs panel options
	private JPanel pnlOptions; 
	private JButton btnDelete;
	private JButton btnMove;
	
	// Attributs des déplacements
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
		
		// Gestion du plan de travail
		JPanel pnlGestion = new JPanel();
		pnlGestion.setLayout( new BorderLayout() );
		
		btnClear = new JButton("Vider la zone de dessin");
		btnClear.setPreferredSize( new Dimension(300,100) );
		btnClear.setFont( new Font("Arial", Font.BOLD, 18) );
		btnClear.addMouseListener(this);
		pnlGestion.add(btnClear, BorderLayout.CENTER);
		
		JPanel pnlEnreg = new JPanel();
		pnlEnreg.setLayout( new GridLayout(1,2) );
		
		btnSave = new JButton("Sauvegarder");
		btnSave.addMouseListener(this);
		pnlEnreg.add(btnSave);
	
		btnLoad = new JButton("Charger");
		btnLoad.addMouseListener(this);
		pnlEnreg.add(btnLoad);
		
		pnlGestion.add(pnlEnreg, BorderLayout.SOUTH);
		
		this.add(pnlGestion, BorderLayout.SOUTH);
		
		// Label liste
		JLabel lblListe = new JLabel("Liste des formes géométriques");
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
		txtObjet.setText( "Rien à afficher !  \nSélectionnez une figure dans la liste ci-dessus" );
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
		
		btnMove = new JButton("Déplacer");
		btnMove.setBackground( Color.BLUE );
		btnMove.setForeground( Color.WHITE );
		btnMove.setFocusable(false);
		btnMove.addMouseListener(this);
		pnlOptions.add(btnMove);
		
		pnlListe.add(pnlOptions, BorderLayout.SOUTH);
		
		this.add(pnlListe, BorderLayout.CENTER);
	}
	
	public DefaultListModel<ObjetGeometrique> getModelJList() {
		return modelJList;
	}

	public void setModelJList(DefaultListModel<ObjetGeometrique> modelJList) {
		this.modelJList = modelJList;
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
			
			txtObjet.setText( "Rien à afficher ! Sélectionnez une figure dans la liste ci-dessus" );
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
			
			// On récupère le panel de dessin
			
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
		
		// Déplacer un item
		if (e.getSource() == this.btnMove) {
			
			if (this.listeObjets.isSelectionEmpty() == false) {
				
				obj = (ObjetGeometrique) listeObjets.getSelectedValue();
				
				pnlD.setDeplacement( true );
				pnlD.setObj(obj);
			}
		}
		
		// Sauvegarder un dessin
		
		if (e.getSource() == this.btnSave) {
			
			// Init du writer 
			
			try {
				
				PrintWriter writer = new PrintWriter("objet.txt","UTF-8");

				Iterator<ObjetGeometrique> iterG = pnlD.getObjets().iterator();
				
				while (iterG.hasNext()) {
					
					ObjetGeometrique obj = iterG.next();
					writer.println("#" + obj.toString());
					
					if (obj instanceof ObjetBasique) {
						
						for (int i=0; i<obj.getSize(); i++) {
							
							writer.println(obj.getPoint(i));
						}
						
						if ( obj instanceof Cercle ) writer.println( ((Cercle) obj).getRayon() );
						
						if ( obj instanceof Quadrangle ) writer.println( ((Quadrangle) obj).getRayon() );
						
						if ( obj instanceof Ellipse ) {
							
							writer.println( ((Ellipse) obj).getGa() );
							writer.println( ((Ellipse) obj).getPa() );
						}
						
						if ( obj instanceof ArcCercle  ) {
							
							writer.println( ((ArcCercle) obj).getAngleDeb() );
							writer.println( ((ArcCercle) obj).getAngleLongueur() );
						}
					}
					else if (obj instanceof ObjetComposite) {
						
						for (int i=0; i<((ObjetComposite) obj).getTaille(); i++) {
							
							writer.println("-");
							
							for (int j=0; j<((ObjetComposite) obj).getObjet(i).getSize(); j++ ) {
								
								writer.println( ((ObjetComposite) obj).getObjet(i).getPoint(j).toString() );
							}
						}
					}
				}
				
				writer.close();
				
			} catch (FileNotFoundException e1) {
				
				System.out.println("Fichier introuvable");
				
			} catch (UnsupportedEncodingException e1) {
				
				System.out.println("Encodage non supporté");
			}
		}
		
		// Charger un fichier
		
		if (e.getSource() == btnLoad) {
			
			try {
				
				// Decomposition du fichier
				String ch = new String(Files.readAllBytes( Paths.get("objet.txt") ));	
				String[] tabObj = ch.split("#");
				
				for (int i=1; i<tabObj.length; i++) {
					
					// Decomposition de l'objet
					String[] objet = tabObj[i].toString().split("\n");
					
					String nomObj = objet[0].substring(0, objet[0].length()-1); // On recupere le nom de l'objet
					
					if ( nomObj.equals("Segment") ) {
						
						pnlD.getObjets().add( new Segment(objet) ); 
					}
					
					if ( nomObj.equals("Rectangle") ) {
						
						pnlD.getObjets().add( new Rectangle(objet) ); 
					}
					
					if ( nomObj.equals("Triangle") ) {
						
						pnlD.getObjets().add( new Triangle(objet) ); 
					}
					
					if ( nomObj.equals("Losange") ) {
						
						pnlD.getObjets().add( new Losange(objet) ); 
					}
					
					if ( nomObj.equals("Cercle") ) {
						
						pnlD.getObjets().add( new Cercle(objet) ); 
					}
					
					if ( nomObj.equals("Quadrangle") ) {
						
						pnlD.getObjets().add( new Quadrangle(objet) ); 
					}
					
					if ( nomObj.equals("Arc") ) {
						
						pnlD.getObjets().add( new ArcCercle(objet) ); 
					}
					
					if ( nomObj.equals("Ellipse") ) {
						
						pnlD.getObjets().add( new Ellipse(objet) ); 
					}
				}
				
				pnlD.refreshDessin();
			} 
			catch (IOException e1) {
				
				e1.printStackTrace();
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
