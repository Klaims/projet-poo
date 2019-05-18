package Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import General.ObjetGeometrique;
import General.Point2D;
import ObjetsBasiques.Segment;

public class PanelInfos extends JPanel implements ActionListener {

	private JButton btnClear;
	private JTextArea txtInfos;
	private String content;
	
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
		txtInfos = new JTextArea();
		txtInfos.setEditable(false);
		JScrollPane scroll = new JScrollPane(txtInfos);
		this.add(scroll);
	}
	
	public void refreshInfos(ArrayList<ObjetGeometrique> T) {
		
		content="";
		
		Iterator<ObjetGeometrique> iter = T.iterator();
		
		while (iter.hasNext()) {
			
			content += iter.next().toString() + "\n";
		}
		
		txtInfos.setText(content);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == this.btnClear) {
			
			// On récupère le panel de dessin
			PanelDessin pnl = (PanelDessin) this.getParent().getComponent(2);
			
			pnl.getObjets().clear(); // Vide l'array list
			
			pnl.repaint();
			txtInfos.setText("");
		}
	}
}
