package Graphique;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import General.ObjetGeometrique;
import General.Point2D;
import ObjetsBasiques.Segment;

public class PanelDessin extends JPanel implements MouseListener {
	
	// Arguments temporaires pour la création des formes
	private Point2D p1;
	private Point2D p2;
	private Point2D p3;
	private Point2D p4;
	
	// Array List qui contient les formes
	private ArrayList<ObjetGeometrique> objets;
	
	private String statut;

	public PanelDessin() {
		
		// Settings panel
		this.setBackground( new Color(230,230,230) );
		this.addMouseListener(this);
		objets = new ArrayList<ObjetGeometrique>();
	}
	
	// Met à jour le mode de l'utilisateur
	public void refreshStatut(String nouvStatut) { 
		
		this.statut = nouvStatut;
	}
	
	////////////////////////////////////		MouseListener		///////////////////////////////////////////


	public void mouseClicked(MouseEvent e) {
	
		
	}

	
	public void mousePressed(MouseEvent e) {
		
		System.out.println( "Pressed" );
		
		if ( this.statut == "Segment" ) {
			
			p1 = new Point2D( e.getX(), e.getY());
		}
		
		if ( this.statut == "Rectangle" ) {
			
			p1 = new Point2D( e.getX(), e.getY());
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
			
			p2 = new Point2D( e.getX(), e.getY() );
			
			// Ajout dans la liste
			
			objets.add( new Segment(p1, p2) );
			drawLine( this.getGraphics() );
			
			
			// Ajout graphique
			
		}
		
		if ( this.statut == "Rectangle" ) {
			
			p3 = new Point2D( e.getX(), e.getY());
			
			
			p2= new Point2D(p3.getPosX(),p1.getPosY());
			p4= new Point2D(p1.getPosX(),p3.getPosY());
			
			drawRectangle(this.getGraphics());
			
			
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
	
	public void drawLine(Graphics g) {
		g.drawLine(  (int) p1.getPosX(), (int) p1.getPosY(),(int) p2.getPosX() , (int)p2.getPosY( ));
	}
	
	public void drawRectangle(Graphics g) {
		
		g.drawRect( (int) p1.getPosX(), (int) p1.getPosY(), (int)  Math.abs( p2.getPosX()-p1.getPosX() ), (int)Math.abs( p4.getPosY()-p1.getPosY())) ;
	}
}
