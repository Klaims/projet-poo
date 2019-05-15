package Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import General.ObjetGeometrique;

public class PanelInfos extends JPanel implements ActionListener {

	private JButton btnClear;
	
	public PanelInfos() {
		
		// Settings panel
		this.setPreferredSize( new Dimension(300,800) );
		this.setBackground( Color.GRAY );
		this.setLayout( new BorderLayout() );
		
		// Contenu
		
		btnClear = new JButton("Vider la zone de dessin");
		btnClear.setPreferredSize( new Dimension(300,100) );
		btnClear.setFont( new Font("Arial", Font.BOLD, 18) );
		btnClear.addActionListener(this);
		this.add(btnClear, BorderLayout.SOUTH);
	}
	
	public void refreshInfos(ArrayList<ObjetGeometrique> T) {
		
		// TODO
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == this.btnClear) {
			
			// On récupère le panel de dessin
			PanelDessin pnl = (PanelDessin) this.getParent().getComponent(2);
			
			pnl.getObjets().clear(); // Vide l'array list
			
			pnl.setForeground(new Color(230,230,230));
			pnl.repaint();
		}
	}
}
