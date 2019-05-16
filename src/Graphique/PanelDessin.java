package Graphique;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import General.ObjetGeometrique;
import General.Point2D;
import ObjetsBasiques.Cercle;
import ObjetsBasiques.Losange;
import ObjetsBasiques.Quadrangle;
import ObjetsBasiques.Rectangle;
import ObjetsBasiques.Segment;
import ObjetsBasiques.Triangle;
import Graphique.PanelInfos;

public class PanelDessin extends JPanel implements MouseListener {
	
	// Arguments temporaires pour la création des formes
	private Point2D p1;
	private Point2D p2;
	private Point2D p3;
	private Point2D p4;
	private boolean quad;
	private double rayon;
	
	private int compteurPoint=0;
	private int[] x = new int[4];
	private int[] y = new int[4];
	
	// Array List qui contient les formes
	private ArrayList<ObjetGeometrique> objets;

	private String statut;

	public PanelDessin() {
		
		// Settings panel
		this.setBackground( new Color(230,230,230) );
		this.addMouseListener(this);
		objets = new ArrayList<ObjetGeometrique>();
		this.quad=false;
	}
	
	// Met à jour le mode de l'utilisateur
	public void refreshStatut(String nouvStatut) { 
		
		this.statut = nouvStatut;
	}
	
	// Met à jour le panel de dessin
	private void refreshDessins() {
		
		this.getGraphics().clearRect(0, 0, 1000, 1000);

		Iterator<ObjetGeometrique> iter = objets.iterator();
		
		while (iter.hasNext()) {
			
			ObjetGeometrique obj = iter.next();
			
			if ( obj instanceof Segment ) {
				
				p1 = obj.getPoint(0);
				p2 = obj.getPoint(1);
				
				this.drawLine(this.getGraphics());
			}
			
			if ( obj instanceof Rectangle ) {
				
				p1 = obj.getPoint(0);
				p2 = obj.getPoint(1);
				p3 = obj.getPoint(2);
				p4 = obj.getPoint(3);
				
				this.drawRectangle(this.getGraphics());
			}
			
			if ( obj instanceof Cercle ) {
				
				p1 = obj.getPoint(0);
				rayon = ((Cercle) obj).getRayon();
				
				p3 = new Point2D(p1.getPosX()-rayon,p1.getPosY()-rayon); // Utile à drawCercle
						
				this.drawCercle(this.getGraphics(), rayon);
			}
			
			if ( obj instanceof Triangle ) {
				
				p1 = obj.getPoint(0);
				p2 = obj.getPoint(1);
				p3 = obj.getPoint(2);
				
				// récupérer les points depuis x et y
				
				compteurPoint = 3;
				
				this.drawPoly(getGraphics());
			}
		}
	}
	
	public String getStatut () {
		
		return this.statut;
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
					
					compteurPoint++;
					
					objets.add( new Triangle(p1, p2, p3) );
					break;		
			}
		}
			
			if(this.statut=="Quadrangle") {
				
				if (this.quad==true) {
					
					if ( rayon == p1.distance(p2) ){
						
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
								
								compteurPoint++;
								break;	
								
						case 3 : p4 = new Point2D( e.getX(), e.getY());
						
								x[compteurPoint]=(int)e.getX();
								y[compteurPoint]=(int)e.getY();
								
								compteurPoint++;
								
								objets.add( new Quadrangle(rayon, p1, p2, p3, p4) );
								break;	
						}
					}				
				}
			}
		
		
		// Rafraichissement zone infos et dessins
		
		((PanelInfos) this.getParent().getComponent(1)).refreshInfos(this.objets);
		this.refreshDessins();
	}

	
	public void mousePressed(MouseEvent e) {
		
		if ( this.statut == "Segment" ) {
			
			p1 = new Point2D( e.getX(), e.getY());
		}
		
		if ( this.statut == "Rectangle" ) {
			
			p1 = new Point2D( e.getX(), e.getY());
		}
		
		if ( this.statut == "Cercle" ) {
			
			p1 = new Point2D(e.getX(),e.getY());
			
		}

		if ( this.statut == "Losange" ) {
			
			p1 = new Point2D( e.getX(), e.getY());
			x[0]= (int) p1.getPosX();
			y[0]= (int) p1.getPosY();
			compteurPoint++;
			
			System.out.println("P1 :" + x[0] + "," + y[0]);
			System.out.println(compteurPoint);
		}
		
		if ( this.statut == "Quadrangle" ) {
			
			if (quad==false) {
				
				p1 = new Point2D(e.getX(),e.getY());
			}	
		}
		
		if ( this.statut == "Aucun" ) {
			
			// TODO
		}
		
		if ( this.statut == "Ellipse" ) {
					
			p1 = new Point2D( e.getX(), e.getY());
			
		}
		
		// Rafraichissement zone infos
		
		((PanelInfos) this.getParent().getComponent(1)).refreshInfos(this.objets);
	}

	
	public void mouseReleased(MouseEvent e) {
		
		if ( this.statut == "Segment" ) {
			
			p2 = new Point2D( e.getX(), e.getY() );
			
			// Ajout dans la liste
			objets.add( new Segment(p1, p2) );
		}
		
		if ( this.statut == "Rectangle" ) {
			
			p3 = new Point2D( e.getX(), e.getY());
			p2 = new Point2D(p3.getPosX(),p1.getPosY());
			p4 = new Point2D(p1.getPosX(),p3.getPosY());
			
			objets.add( new Rectangle(p1, p2, p3, p4) );
		}
		
		if ( this.statut == "Cercle" ) {
			
			p2 = new Point2D(e.getX(),e.getY());
			rayon = p1.distance(p2);
			
			objets.add( new Cercle(p1, rayon) );
		}

		
		if ( this.statut == "Losange" ) {
			
			p3 = new Point2D(e.getX(),e.getY());
			
			x[2]= (int) p3.getPosX();
			y[2]= (int) p3.getPosY();
			compteurPoint++;
	
			p2 = new Point2D(p1.getPosX()+20,(p3.getPosY()+p1.getPosY()) /2);
			
			x[1]= (int) p2.getPosX();
			y[1]= (int) p2.getPosY();
			compteurPoint++;
			
			p4 = new Point2D(p1.getPosX()-20,(p3.getPosY()+p1.getPosY()) /2);
			
			x[3]= (int) p4.getPosX();
			y[3]= (int) p4.getPosY();
			compteurPoint++;
			
			objets.add( new Losange(p1, p2, p3, p4) );
		}
		
		if ( this.statut == "Quadrangle" ) {
			
			if (quad==false) {
				
				p2 = new Point2D( e.getX(), e.getY() );
				
				this.rayon = p1.distance(p2);
				p3 = new Point2D(p1.getPosX()-rayon,p1.getPosY()-rayon);
				
				objets.add( new Cercle(p1, rayon) );
				quad=true;
			}
		}
		
		if ( this.statut == "Aucun" ) {
			
			// ? Déplacer peut être
		}
				
		if ( this.statut == "Ellipse" ) {
					
			p2 = new Point2D(e.getX(),e.getY());
				
			double dga = p1.distance(p2);
			double r = dga/2;
				
			p3 = new Point2D(p1.getPosX()-dga,p1.getPosY()-r);
				
			//drawEllipse(this.getGraphics(),dga,r);
		}
		
		// Rafraichissement zone dessin et infos
		
		((PanelInfos) this.getParent().getComponent(1)).refreshInfos(this.objets);
		this.refreshDessins();
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
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
		
		g.drawPolygon(x, y, compteurPoint);
		compteurPoint=0;
	}
	
	public void drawCercle(Graphics g, double rayon) {
		
		g.drawOval((int)p3.getPosX(), (int)p3.getPosY(), 2* (int)rayon, 2* (int)rayon);
	}
	
	public void drawEllipse(Graphics g, double demi_grand_axe, double rayon) {
		
		g.drawOval((int)p3.getPosX(), (int)p3.getPosY(), 2* (int)demi_grand_axe, 2* (int)rayon);	
	}
}
