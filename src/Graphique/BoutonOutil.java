package Graphique;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class BoutonOutil extends JButton implements ActionListener{

	public BoutonOutil() {
		
		// Settings bouton
		this.setPreferredSize(new Dimension(100,60));
		this.addActionListener(this);
		this.setFont( new Font("Arial", Font.PLAIN, 16) );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
		JLabel label = ((JLabel) this.getParent().getParent().getComponent(1)); // Label statut
		String nouvStatut = ((BoutonOutil) e.getSource()).getText(); // Nouveau statut
		PanelDessin pnlD = ((PanelDessin) this	.getParent()
												.getParent()
												.getParent().getComponent(2));
		PanelInfos pnlInfos = ((PanelInfos) this	.getParent()
													.getParent()
													.getParent().getComponent(1));
			
		for(int i=0; i<this.getParent().getComponentCount(); i++) {
			
			( (BoutonOutil) this.getParent().getComponent(i) ).setEnabled(true);
		} // Remet tous les boutons enabled
			
		((BoutonOutil) e.getSource()).setEnabled(false); // Disable le bouton utilisé
			
		label.setText("Statut : " + nouvStatut ); // Changement du label statut 
			
		// Met à jour le panel dessin
			
		pnlD.refreshStatut(nouvStatut);
		
		// Remet à 0 les variables de dessin
		
		if ( pnlD.isConstruction() == true ) {
			
			pnlD.getObjets().remove( pnlD.getObjets().size()-1 );
			pnlInfos.getModelJList().remove( pnlInfos.getModelJList().size()-1 );
		}
		
		pnlD.refreshAttributs();
		
		// Refresh le panel
		pnlD.refreshDessin();
	}
}
