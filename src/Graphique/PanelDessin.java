package Graphique;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import General.ObjetGeometrique;
import General.Point2D;
import ObjetsBasiques.Rectangle;
import ObjetsBasiques.Segment;
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
					drawPoly(this.getGraphics());
					break;		
			}
		}
			
			if(this.statut=="Quadrangle") {
				
				
				if (this.quad==true) {
					
					
					if ( rayon == Math.sqrt(  (Math.pow(e.getX()-p1.getPosX(), 2)) + (Math.pow(e.getY()- p1.getPosY(), 2)))){
						
						System.out.println("ok");
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
						drawPoly(this.getGraphics());
						break;	
						}
						
					}
					
				}
			}
		
		
		// Rafraichissement zone infos
		
		((PanelInfos) this.getParent().getComponent(1)).refreshInfos(this.objets);
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
			
			if (quad==false) {p1 = new Point2D(e.getX(),e.getY());
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
			drawLine( this.getGraphics() );
			
			
			// Ajout graphique
			
		}
		
		if ( this.statut == "Rectangle" ) {
			
			p3 = new Point2D( e.getX(), e.getY());
			
			
			p2= new Point2D(p3.getPosX(),p1.getPosY());
			p4= new Point2D(p1.getPosX(),p3.getPosY());
			
			objets.add( new Rectangle(p1, p2, p3, p4) );
			drawRectangle(this.getGraphics());
		}
		
		if ( this.statut == "Cercle" ) {
			
			p2 = new Point2D(e.getX(),e.getY());
			
			double r = Math.sqrt(  (Math.pow(p2.getPosX()-p1.getPosX(), 2)) + (Math.pow(p2.getPosY()- p1.getPosY(), 2)));
			p3 = new Point2D(p1.getPosX()-r,p1.getPosY()-r);
			
			drawCercle(this.getGraphics(),r);
			
		}

		
		if ( this.statut == "Losange" ) {
			
			p3 = new Point2D(e.getX(),e.getY());
			
			x[2]= (int) p3.getPosX();
			y[2]= (int) p3.getPosY();
			compteurPoint++;
			
			System.out.println("P3 :" + x[2] + "," + y[2]);
			System.out.println(compteurPoint);
			
			
	
			p2 = new Point2D(p1.getPosX()+20,(p3.getPosY()+p1.getPosY()) /2);
			
			x[1]= (int) p2.getPosX();
			y[1]= (int) p2.getPosY();
			compteurPoint++;
			
			System.out.println("P2 :" + x[1] + "," + y[1]);
			System.out.println(compteurPoint);
			
			p4 = new Point2D(p1.getPosX()-20,(p3.getPosY()+p1.getPosY()) /2);
			
			x[3]= (int) p4.getPosX();
			y[3]= (int) p4.getPosY();
			compteurPoint++;
			
			System.out.println("P4 :" + x[3] + "," + y[3]);
			System.out.println(compteurPoint);
			
			drawPoly(this.getGraphics());
		}
		
		if ( this.statut == "Quadrangle" ) {
			
			
			if (quad==false) {
			p2 = new Point2D( e.getX(), e.getY() );
			
			this.rayon = Math.sqrt(  (Math.pow(p2.getPosX()-p1.getPosX(), 2)) + (Math.pow(p2.getPosY()- p1.getPosY(), 2)));
			p3 = new Point2D(p1.getPosX()-rayon,p1.getPosY()-rayon);
			
			
			drawCercle(this.getGraphics(),rayon);
			quad=true;
			System.out.println(quad);
			System.out.println(statut);
			}
			
		}
		
		if ( this.statut == "Aucun" ) {
			
			// TODO
		}
				
		if ( this.statut == "Ellipse" ) {
					
				p2 = new Point2D(e.getX(),e.getY());
				
				double dga = Math.sqrt(  (Math.pow(p2.getPosX()-p1.getPosX(), 2)) + (Math.pow(p2.getPosY()- p1.getPosY(), 2)));
				
				double r = dga/2;
				
				p3 = new Point2D(p1.getPosX()-dga,p1.getPosY()-r);
				
				drawEllipse(this.getGraphics(),dga,r);
			}
		
		// Rafraichissement zone infos
		
		((PanelInfos) this.getParent().getComponent(1)).refreshInfos(this.objets);
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
		
		/*for(int i=0;i<3;i++) {
			
			System.out.println(x[i]);
			System.out.println(y[i]);
			
		}*/
		
		
		
		
		//compteurPoint++;
		System.out.println(compteurPoint);
		
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
