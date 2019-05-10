package Graphique;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class PanelSelection extends JPanel {

	public PanelSelection() {
		
		// Settings panel
		this.setPreferredSize( new Dimension(1200,70) );
		this.setBackground( Color.DARK_GRAY );
		
		// Contenu
		
		// Boutons
		JPanel pnlBoutons = new JPanel();
		pnlBoutons.setLayout( new GridLayout() );
		
		// TODO
		
		this.add(pnlBoutons);
	}
}
