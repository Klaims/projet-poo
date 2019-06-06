package Graphique;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	public MainFrame() {
		
		// Settings de la fenetre
		this.setTitle("Dessin");
		this.setSize( new Dimension(1200,800) );
		this.setResizable(false);
		this.setLocationRelativeTo(null); // Permet de centrer
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Content pane
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout( new BorderLayout() );
		this.setContentPane(pnlMain);
		
		// Contenu
		PanelSelection pnlSelect = new PanelSelection();
		pnlMain.add(pnlSelect, BorderLayout.NORTH);
		
		PanelInfos pnlInfos = new PanelInfos();
		pnlMain.add(pnlInfos, BorderLayout.EAST);
		
		PanelDessin pnlDessin = new PanelDessin();
		pnlMain.add(pnlDessin, BorderLayout.CENTER);
		
		// Toujours à la fin
		this.setVisible(true);
	}
}
