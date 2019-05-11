package Graphique;

import java.awt.Color;

import javax.swing.JPanel;

public class PanelDessin extends JPanel {

	public PanelDessin() {
		
		// Settings panel
		this.setBackground( new Color(230,230,230) );
	}
	
	// Met à jour le mode de l'utilisateur
	public void checkStatut(String nouvStatut) { 
		
		if ( nouvStatut == "Segment" ) {
			
			this.setModeSegment();
		}
		
		if ( nouvStatut == "Rectangle" ) {
			
			this.setModeRectangle();
		}
		
		if ( nouvStatut == "Cercle" ) {
			
			this.setModeCercle();
		}
		
		if ( nouvStatut == "Triangle" ) {
			
			this.setModeTriangle();
		}
		
		if ( nouvStatut == "Losange" ) {
			
			this.setModeLosange();
		}
		
		if ( nouvStatut == "Quadrangle" ) {
			
			this.setModeQuadrangle();
		}
		
		if ( nouvStatut == "Aucun" ) {
			
			this.setModeAucun();
		}
	}

	private void setModeAucun() {
		// TODO Auto-generated method stub
		
	}

	private void setModeQuadrangle() {
		// TODO Auto-generated method stub
		
	}

	private void setModeLosange() {
		// TODO Auto-generated method stub
		
	}

	private void setModeTriangle() {
		// TODO Auto-generated method stub
		
	}

	private void setModeCercle() {
		// TODO Auto-generated method stub
		
	}

	private void setModeRectangle() {
		// TODO Auto-generated method stub
		
	}

	private void setModeSegment() {
		// TODO Auto-generated method stub
		
	}
}
