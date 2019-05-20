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

import General.ObjetGeometrique;
import General.Point2D;
import ObjetsBasiques.Segment;

public class PanelInfos extends JPanel implements ActionListener {

	private JButton btnClear;
	private String content;
	private DefaultListModel<ObjetGeometrique> modelJList;
	
	public PanelInfos() {
		
		// Settings panel
		this.setPreferredSize( new Dimension(300,800) );
		this.setBackground( Color.GRAY );
		this.setLayout( new BorderLayout(10,10) );
		this.setBorder( new EmptyBorder(10,10,10,10) );
		
		// Contenu
		
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
		modelJList = new DefaultListModel();
		JList listeObjets = new JList( modelJList );
		JScrollPane scroll = new JScrollPane(listeObjets);
		this.add(scroll);
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
}
