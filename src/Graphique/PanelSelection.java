package Graphique;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSelection extends JPanel {

	public PanelSelection() {
		
		// Settings panel
		this.setPreferredSize( new Dimension(1200,70) );
		this.setBackground( Color.DARK_GRAY );
		this.setLayout( new BorderLayout() );
		
		// Contenu
		
		// Boutons
		JPanel pnlBoutons = new JPanel();
		pnlBoutons.setBackground(new Color(0,0,0,1));
		
		BoutonOutil btnSeg = new BoutonOutil();
		btnSeg.setText("Segment");
		pnlBoutons.add(btnSeg);
		
		BoutonOutil btnRect = new BoutonOutil();
		btnRect.setText("Rectangle");
		pnlBoutons.add(btnRect);
		
		BoutonOutil btnCrcl = new BoutonOutil();
		btnCrcl.setText("Cercle");
		pnlBoutons.add(btnCrcl);
		
		BoutonOutil btnTrg = new BoutonOutil();
		btnTrg.setText("Triangle");
		pnlBoutons.add(btnTrg);
		
		BoutonOutil btnLsge = new BoutonOutil();
		btnLsge.setText("Losange");
		pnlBoutons.add(btnLsge);
		
		BoutonOutil btnQuad = new BoutonOutil();
		btnQuad.setText("Quadrangle");
		pnlBoutons.add(btnQuad);
		
		this.add(pnlBoutons, BorderLayout.WEST);
		
		// Statut
		JLabel lblStatut = new JLabel("Statut : Aucun");
		lblStatut.setForeground(Color.WHITE);
		lblStatut.setFont(new Font("Arial", Font.BOLD, 32));
		
		this.add(lblStatut, BorderLayout.EAST);
	}
}
