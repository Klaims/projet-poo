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
		
		JLabel label = ((JLabel) this.getParent().getParent().getComponent(1));
		
		label.setText("Statut : " + ((BoutonOutil) e.getSource()).getText() );
	}
}
