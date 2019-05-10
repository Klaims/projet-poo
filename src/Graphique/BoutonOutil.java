package Graphique;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class BoutonOutil extends JButton implements ActionListener{

	public BoutonOutil() {
		
		// Settings bouton
		this.setPreferredSize(new Dimension(100,60));
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JLabel label = ((JLabel) this.getParent().getParent().getComponent(1)); // Label statut
		String nouvStatut = ((BoutonOutil) e.getSource()).getText(); // Nouveau statut
		
		for(int i=0; i<7; i++) {
			
			 ( (BoutonOutil) this.getParent().getComponent(i) ).setEnabled(true);
		} // Remet tous les boutons enabled
		
		((BoutonOutil) e.getSource()).setEnabled(false); // Disable le bouton utilisé
		
		( (PanelSelection)this.getParent().getParent() ).setStatut(nouvStatut); // Changement de la variable statut
		label.setText("Statut : " + nouvStatut ); // Changement du label statut 
	}
}
