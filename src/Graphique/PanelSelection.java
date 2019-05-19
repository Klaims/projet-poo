package Graphique;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelSelection extends JPanel {

	public PanelSelection() {
		
		// Settings panel
		this.setPreferredSize( new Dimension(1200,140) );
		this.setBackground( Color.DARK_GRAY );
		this.setLayout( new BorderLayout() );
		this.setBorder( new EmptyBorder(8, 8, 8, 8) );
		
		// Contenu
		
		// Boutons
		JPanel pnlBoutons = new JPanel();
		pnlBoutons.setBackground(new Color(0,0,0,1));
		pnlBoutons.setLayout( new GridLayout(2,8,8,8) );
		
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
		
		BoutonOutil btnEllipse = new BoutonOutil();
		btnEllipse.setText("Ellipse");
		pnlBoutons.add(btnEllipse);
		
		BoutonOutil btnArc = new BoutonOutil();
		btnArc.setText("Arc");
		pnlBoutons.add(btnArc);

		BoutonOutil btnMultSeg = new BoutonOutil();
		btnMultSeg.setText("Multiseg");
		pnlBoutons.add(btnMultSeg);
		
		BoutonOutil btnMultRect = new BoutonOutil();
		btnMultRect.setText("Multirect");
		pnlBoutons.add(btnMultRect);
		
		BoutonOutil btnAucun = new BoutonOutil();
		btnAucun.setText("Aucun");
		btnAucun.setEnabled(false);
		pnlBoutons.add(btnAucun);
		
		this.add(pnlBoutons, BorderLayout.WEST);
		
		// Statut
		JLabel lblStatut = new JLabel("Statut : Aucun");
		lblStatut.setForeground(Color.WHITE);
		lblStatut.setFont(new Font("Arial", Font.BOLD, 32));
		lblStatut.setBorder( new EmptyBorder(2, 2, 2, 40) );
		this.add(lblStatut, BorderLayout.EAST);
	}
}
