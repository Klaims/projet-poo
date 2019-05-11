package Graphique;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class PanelDessin extends JPanel implements MouseListener {
	
	private String statut;

	public PanelDessin() {
		
		// Settings panel
		this.setBackground( new Color(230,230,230) );
		this.addMouseListener(this);
	}
	
	// Met à jour le mode de l'utilisateur
	public void refreshStatut(String nouvStatut) { 
		
		this.statut = nouvStatut;
	}
	
	////////////////////////////////////		MouseListener		///////////////////////////////////////////

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		System.out.println( "Pressed" );
		
		if ( this.statut == "Segment" ) {
			
			// TODO
		}
		
		if ( this.statut == "Rectangle" ) {
			
			// TODO
		}
		
		if ( this.statut == "Cercle" ) {
			
			// TODO
		}
		
		if ( this.statut == "Triangle" ) {
			
			// TODO
		}
		
		if ( this.statut == "Losange" ) {
			
			// TODO
		}
		
		if ( this.statut == "Quadrangle" ) {
			
			// TODO;
		}
		
		if ( this.statut == "Aucun" ) {
			
			// TODO
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		System.out.println( "Released" );
		
		if ( this.statut == "Segment" ) {
			
			// TODO
		}
		
		if ( this.statut == "Rectangle" ) {
			
			// TODO
		}
		
		if ( this.statut == "Cercle" ) {
			
			// TODO
		}
		
		if ( this.statut == "Triangle" ) {
			
			// TODO
		}
		
		if ( this.statut == "Losange" ) {
			
			// TODO
		}
		
		if ( this.statut == "Quadrangle" ) {
			
			// TODO;
		}
		
		if ( this.statut == "Aucun" ) {
			
			// TODO
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
