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
	
	// Arguments temporaires pour la cr�ation des formes
	private Point2D p1;
	private Point2D p2;
	private Point2D p3;
	private Point2D p4;
	
	private int compteurPoint=0;
	private int[] x = new int[3];
	private int[] y = new int[3];
	
	// Array List qui contient les formes
	private ArrayList<ObjetGeometrique> objets;

	private String statut;

	public PanelDessin() {
		
		// Settings panel
		this.setBackground( new Color(230,230,230) );
		this.addMouseListener(this);
		objets = new ArrayList<ObjetGeometrique>();
	}
	
	// Met � jour le mode de l'utilisateur
	public void refreshStatut(String nouvStatut) { 
		
		this.statut = nouvStatut;
	}
	
	public ArrayList<ObjetGeometrique> getObjets() {
		return objets;
	}

	public void setObjets(ArrayList<ObjetGeometrique> objets) {
		this.objets = objets;
	}
	
	////////////////////////////////////		MouseListener		///////////////////////////////////////////


	public void mouseClicked(MouseEvent e) {
	
		if(this.statut=="Triangle") {
			
			
			switch (compteurPoint) {
			
			case 0: p1 = new Point2D( e.getX(), e.getY());
			
					x[compteurPoint]=(int)e.getX();
					y[compteurPoint]=(int)e.getY();
					
					compteurPoint++;
					break;
					
			case 1 : p2 = new Point2D( e.getX(), e.getY());
			
					x[compteurPoint]=(int)e.getX();
					y[compteurPoint]=(int)e.getY();
					
					compteurPoint++;
					break;
					
			case 2 : p3 = new Point2D( e.getX(), e.getY());
					
					x[compteurPoint]=(int)e.getX();
					y[compteurPoint]=(int)e.getY();
					
					drawPoly(this.getGraphics());
					compteurPoint=0;
					
					
					break;		
			
			}
			
			
		}
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
	
	public void drawPoly(Graphics g) {
		
		for(int i=0;i<3;i++) {
			
			System.out.println(x[i]);
			System.out.println(y[i]);
			
		}
		
		System.out.println(compteurPoint);
		compteurPoint++;
		g.drawPolygon(x, y, compteurPoint);
		
	}
}
