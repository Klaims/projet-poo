package Graphique;

import java.awt.Graphics;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import General.*;
import ObjetsBasiques.*;
import ObjetsComposites.*;

import Graphique.PanelInfos;

public class PanelDessin extends JPanel implements MouseListener, MouseMotionListener {
	
	////////////////////////////////////////// Attributs du PanelDessin //////////////////////////////////////////
	
	// Points Temporaires pour aider � la cr�ation des figures
	private Point2D p1;
	private Point2D p2;
	private Point2D p3;
	private Point2D p4;
	
	private Point2D tempo;
	private boolean construction;
	private double rayon;
	private double ga;
	private double pa;
	private Point2D[] tempPoints = new Point2D[4];
	private Color couleur;
	
	// Compteur de points / Tableaux contenant les coordonn�es des points afin d'�viter les conflits lors de la cr�ation de figures 
	private int compteurPoint;
	private int[] x = new int[4];
	private int[] y = new int[4];
	
	private ArrayList<ObjetGeometrique> objets;  // ArrayList contenant tous les objets dessin�s
	private String statut;        // Chaine permettant de savoir la figure que l'utilisateur souhaite tracer
	private boolean deplacement;  // Booleen indiquant si nous sommes en mode d�placement
	private ObjetGeometrique obj; // Objet a deplacer
	private Point2D posSouris;    // Repaire pour le deplacement

	
    ////////////////////////////////////////// M�thodes de la classe PanelDessin //////////////////////////////////////////
	
	
	public Point2D getP2() {
		return p2;
	}

	public void setP2(Point2D p2) {
		this.p2 = p2;
	}

	public boolean isConstruction() {
		return construction;
	}

	public void setConstruction(boolean construction) {
		this.construction = construction;
	}

	public PanelDessin() {
		
		// Impl�mentation des Listener et initialisation de l'ArrayList
		
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		objets = new ArrayList<ObjetGeometrique>();
		
		// Initialisation des attributs
		
		this.construction = false;
		this.couleur = Color.BLACK;
		this.deplacement = false;
	}
	
	// Met a jour le mode dans lequel se trouve l'utilisateur
	
	public void refreshStatut(String nouvStatut) { 
		
		this.statut = nouvStatut;
	}
	
	// Met a jour le panel de dessin
	
	public void refreshDessin() {
		
		this.getGraphics().clearRect(0, 0, 1000, 1000);
		
		Iterator<ObjetGeometrique> iter = objets.iterator();
		
		while (iter.hasNext()) {

			ObjetGeometrique obj = iter.next();
			
			couleur = obj.getCouleur();
			
			// La fonction dessine les  diff�rents objets en fonction de leur classe
			
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
				
				x[0] = (int) p1.getPosX();		y[0] = (int) p1.getPosY();
				x[1] = (int) p2.getPosX();		y[1] = (int) p2.getPosY();
				x[2] = (int) p3.getPosX();		y[2] = (int) p3.getPosY();
				x[3] = (int) p4.getPosX();		y[3] = (int) p4.getPosY();
				
				this.drawPoly(getGraphics(), 4);
			}
			
			if ( obj instanceof Cercle ) {
				
				if( obj instanceof ArcCercle) {
					
					p1 = ((Cercle) obj).getCentre();
					p3 = new Point2D( p1.getPosX()-((Cercle) obj).getRayon(), p1.getPosY()-((Cercle) obj).getRayon() );
					pa = ((ArcCercle) obj).getAngleDeb();
					ga = ((ArcCercle) obj).getAngleLongueur();
					rayon = ((Cercle) obj).getRayon();
					
					this.drawArcCercle(this.getGraphics());
				}
				
				else {
					
				p1 = obj.getPoint(0);
				rayon = ((Cercle) obj).getRayon();
				p3 = new Point2D(p1.getPosX()-rayon,p1.getPosY()-rayon);  // Utile � drawCercle
						
				this.drawCercle(this.getGraphics(), rayon);
				}
			}
			
			if ( obj instanceof Triangle ) {
				
				p1 = obj.getPoint(0);
				p2 = obj.getPoint(1);
				p3 = obj.getPoint(2);
				
				x[0] = (int) p1.getPosX();		y[0] = (int) p1.getPosY();
				x[1] = (int) p2.getPosX();		y[1] = (int) p2.getPosY();
				x[2] = (int) p3.getPosX();		y[2] = (int) p3.getPosY();
				
				this.drawPoly(getGraphics(), 3);
			}
			
			if ( obj instanceof Losange ) {
				
				p1 = obj.getPoint(0);
				p2 = obj.getPoint(1);
				p3 = obj.getPoint(2);
				p4 = obj.getPoint(3);
				
				x[0] = (int) p1.getPosX();		y[0] = (int) p1.getPosY();
				x[1] = (int) p2.getPosX();		y[1] = (int) p2.getPosY();
				x[2] = (int) p3.getPosX();		y[2] = (int) p3.getPosY();
				x[3] = (int) p4.getPosX();		y[3] = (int) p4.getPosY();
				
				this.drawPoly(getGraphics(), 4);
			}
			
			if ( obj instanceof Quadrangle ) {
				
				p1 = obj.getPoint(0);
				p2 = obj.getPoint(1);
				p3 = obj.getPoint(2);
				p4 = obj.getPoint(3);
				rayon = ((Quadrangle) obj).getRayon();
				
				x[0] = (int) p1.getPosX();		y[0] = (int) p1.getPosY();
				x[1] = (int) p2.getPosX();		y[1] = (int) p2.getPosY();
				x[2] = (int) p3.getPosX();		y[2] = (int) p3.getPosY();
				x[3] = (int) p4.getPosX();		y[3] = (int) p4.getPosY();
				
				this.drawPoly(getGraphics(), 4);
			}
			
			if ( obj instanceof Ellipse ) {
				
				p1 = obj.getPoint(0);
				ga = ((Ellipse) obj).getGa();
				pa = ((Ellipse) obj).getPa();
				
				drawEllipse(getGraphics());
			}
			
			if ( obj instanceof MultiRectangle ) {
				
				for (int i=0; i< ((MultiRectangle) obj).getTaille() ; i++ ) {
					
					p1 = ((MultiRectangle) obj).getObjet(i).getPoint(0);
					p2 = ((MultiRectangle) obj).getObjet(i).getPoint(1);
					p3 = ((MultiRectangle) obj).getObjet(i).getPoint(2);
					p4 = ((MultiRectangle) obj).getObjet(i).getPoint(3);
					
					x[0] = (int) p1.getPosX();		y[0] = (int) p1.getPosY();
					x[1] = (int) p2.getPosX();		y[1] = (int) p2.getPosY();
					x[2] = (int) p3.getPosX();		y[2] = (int) p3.getPosY();
					x[3] = (int) p4.getPosX();		y[3] = (int) p4.getPosY();
					
					this.drawPoly(getGraphics(), 4);
				}
			}

			if ( obj instanceof MultiSegment ) {
				
				if ( obj instanceof SuiteCercle ) {	

					for ( int i=0; i< (((ObjetComposite) obj).getTaille());i++ ) {
						
						p1=((Segment) (( (MultiSegment)obj).getObjet(i))).getPoint(0);
						p2=((Segment) (( (MultiSegment)obj).getObjet(i))).getPoint(1);
						p3 = new Point2D( p1.getPosX()-p1.distance(p2)/4, p1.getPosY()-p1.distance(p2)/4);
						
						this.rayon = p1.distance(p2)/4;
						
						drawLine(this.getGraphics());
						drawCercle(this.getGraphics(),this.rayon);
					}
				}
				
				else if ( obj instanceof SuiteEllipse ) {
						
					for ( int i=0; i< (((ObjetComposite) obj).getTaille());i++ ) {
											
						p1=((Segment) (( (MultiSegment)obj).getObjet(i))).getPoint(0);
						p2=((Segment) (( (MultiSegment)obj).getObjet(i))).getPoint(1);		
						p3 = new Point2D( p1.getPosX(), p1.getPosY()-p1.distance(p2)/3);
						
						this.ga = p1.distance(p2);
						this.pa=p1.distance(p2)/3;
						
						drawLine(this.getGraphics());
						p1=p3;
						drawEllipse(this.getGraphics());						
					}
				}
				
				else {
						
					for ( int i=0; i< (((ObjetComposite) obj).getTaille());i++ ) {
							
						p1=((Segment) (( (MultiSegment)obj).getObjet(i))).getPoint(0);
						p2=((Segment) (( (MultiSegment)obj).getObjet(i))).getPoint(1);
						drawLine(this.getGraphics());
					 }
			    }
			}
			
			if ( obj instanceof MultiCercle ) {
				
				for ( int i=0; i< (((ObjetComposite) obj).getTaille());i++ ) {
									
					p4=((Cercle) (( (MultiCercle)obj).getObjet(i))).getCentre();
					this.rayon = ((Cercle)((MultiCercle)obj).getObjet(i)).getRayon();
					p3 = new Point2D(0,0);
					p3.setPosX(p4.getPosX()-this.rayon);
					p3.setPosY(p4.getPosY()-this.rayon);
					
					drawCercle(this.getGraphics(),this.rayon);
				}
			}
			
            if ( obj instanceof MultiEllipse ) {
				
				for ( int i=0; i< (((ObjetComposite) obj).getTaille());i++ ) {
									
					p1 = ((Ellipse) (( (MultiEllipse)obj).getObjet(i))).getPoint(0);
					ga = ((Ellipse) (( (MultiEllipse)obj).getObjet(i))).getGa();
					pa = ((Ellipse) (( (MultiEllipse)obj).getObjet(i))).getPa();
					
					drawEllipse(getGraphics());				
				}
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
	
	public boolean getDeplacement() {
		
		return this.deplacement;
	}
	
	public void setDeplacement(boolean deplacement) {
		
		this.deplacement = deplacement;
	}
	
	public void setObj (ObjetGeometrique obj) {
		
		this.obj = obj;
	}
	
	
	
	////////////////////////////////////		MouseListener		///////////////////////////////////////////


	public void mouseClicked(MouseEvent e) {
	
		
		// Un clic de souris engendre diff�rentes actions en fonction de la figure que l'on souhaite tracer
		
		
		if ( this.statut == "Triangle" ) {
			
			switch ( compteurPoint ) {
			
			case 0: tempPoints[0] = new Point2D( e.getX(), e.getY());
					compteurPoint++;
					
					break;
					
			case 1 : tempPoints[1] = new Point2D( e.getX(), e.getY());
					compteurPoint++;
					
					break;
					
			case 2 : tempPoints[2] = new Point2D( e.getX(), e.getY());
					objets.add( new Triangle(tempPoints[0], tempPoints[1], tempPoints[2]) );
					compteurPoint= 0;
					
					break;
			}
		}
		
		
		if ( this.statut == "Quadrangle" ) {
				
			if ( this.construction==true ) {
					
				p2 = new Point2D( e.getX(), e.getY());
					
				if ( (p1.distance(p2) > rayon-5) && (p1.distance(p2) < rayon+5 ) ) {
						
					switch (compteurPoint) {
						
					case 0: tempPoints[0] = new Point2D( e.getX(), e.getY());
						    compteurPoint++;
						    
							break;
								
					case 1 : tempPoints[1] = new Point2D( e.getX(), e.getY());
							 compteurPoint++;
								
							 break;
								
					case 2 : tempPoints[2] = new Point2D( e.getX(), e.getY());
							 compteurPoint++;
							 
							 break;
								
					case 3 : tempPoints[3] = new Point2D( e.getX(), e.getY());
						     objets.remove(objets.size()-1);
						     objets.add( new Quadrangle(rayon, tempPoints[0], tempPoints[1], tempPoints[2], tempPoints[3]) );
							 compteurPoint= 0;
							 construction= false;
							 
							 break;
					}
				}
			}
		}
		
		
		if ( this.statut== "Arc" ) {
				
			if ( this.construction==true ) {
					
				p2 = new Point2D( e.getX(), e.getY());
					
				if ( (p1.distance(p2) > rayon-5) && (p1.distance(p2) < rayon+5) ) {
						
					switch (compteurPoint) {
						
					case 0: tempPoints[0] = new Point2D( e.getX(), e.getY());
							compteurPoint++;
							
							break;
								
					case 1: tempPoints[1] = new Point2D( e.getX(), e.getY());
							tempPoints[3] = new Point2D(p1.getPosX()-rayon,p1.getPosY()-rayon);
							compteurPoint++;
								
							this.objets.remove(objets.size()-1);
							this.objets.add(new ArcCercle(p1, rayon, calculAngle(tempPoints[0],p1),(calculAngle(tempPoints[1],p1)-calculAngle(tempPoints[0],p1))));
								
							construction=false;
							compteurPoint=0;
							break;
					}
					
				}
			}
		}
		

		if ( this.statut == "Multi-segments" ) {
				
			if ( compteurPoint==0 ) {
				tempPoints[0] = new Point2D(e.getX(),e.getY());
				compteurPoint++;
			}
				
			else if ( compteurPoint == 1 ) {
					
				tempPoints[1]= new Point2D(e.getX(),e.getY());
				this.objets.add(new MultiSegment());
				((MultiSegment) this.objets.get(this.objets.size()-1)).addObjet(new Segment(tempPoints[0],tempPoints[1]));
				compteurPoint++;
				tempPoints[0]=tempPoints[1];	
			}
				
				
		    else {
		    	
				tempPoints[1]=new Point2D(e.getX(),e.getY());
				((MultiSegment) this.objets.get(this.objets.size()-1)).addObjet(new Segment(tempPoints[0],tempPoints[1]));
				compteurPoint++;
				tempPoints[0]=tempPoints[1];
			}
		}
			
		
		if ( this.statut == "Suite de Cercles" ) {
							
			if ( compteurPoint == 0 ) {
				
				tempPoints[0] = new Point2D(e.getX(),e.getY());
				compteurPoint++;
			}
							
			else if ( compteurPoint == 1 ) {
									
				tempPoints[1]= new Point2D(e.getX(),e.getY());
				this.objets.add(new SuiteCercle());
				((SuiteCercle) this.objets.get(this.objets.size()-1)).addObjet(new Segment(tempPoints[0],tempPoints[1]));
				compteurPoint++;
				tempPoints[0]=tempPoints[1];								
			}
							
			else {
				
				 tempPoints[1]=new Point2D(e.getX(),e.getY());
				 ((SuiteCercle) this.objets.get(this.objets.size()-1)).addObjet(new Segment(tempPoints[0],tempPoints[1]));
				 compteurPoint++;
				 tempPoints[0]=tempPoints[1];
			}
		}
			
		// On actualise la zone de dessin et les informations � chaque clic
		
		((PanelInfos) this.getParent().getComponent(1)).refreshInfos(this.objets);
		this.refreshDessin();
		
	}

	
	public void mousePressed(MouseEvent e) {
		
		// Lorsque l'on garde le clic souris enfonc�, diff�rentes actions vont se produire en fonction de la figure que l'on souhaite tracer
		
		if ( this.statut == "Segment" ) {
			
			p1 = new Point2D(e.getX(), e.getY());
		}
		
		if ( this.statut == "Rectangle" ) {
			
			p1 = new Point2D(e.getX(), e.getY());
		}
		
		if ( this.statut == "Cercle" ) {
			
			p1 = new Point2D(e.getX(),e.getY());
		}

		if ( this.statut == "Losange" ) {
			
			p1 = new Point2D(e.getX(), e.getY());
		}
		
		if ( this.statut == "Quadrangle" ) {
			
			if ( construction == false ) {
				
				p1 = new Point2D(e.getX(),e.getY());
			}	
		}
		
		if ( this.statut == "Ellipse" ) {
					
			p1 = new Point2D(e.getX(), e.getY());
		}
		
		if (this.statut == "Arc") {
			
			if ( construction == false ) {
				
				p1 = new Point2D(e.getX(),e.getY());
			}	
		}
		
		if ( statut == "Multi-rectangles" ) {
			
			if ( compteurPoint == 0 ) {
				
				objets.add( new MultiRectangle() );
				compteurPoint++;
			}
			
			p1 = new Point2D( e.getX(), e.getY());
		}
		
		if ( this.statut == "Multi-cercles") {
			
			if ( compteurPoint == 0) {
				
				objets.add(new MultiCercle());	
			}
			
			tempPoints[0] = new Point2D(e.getX(),e.getY());
			compteurPoint++;
		}
		
		
		if ( this.statut == "Multi-ellipses") {
			
			if ( compteurPoint == 0) {
				
				objets.add(new MultiEllipse());	
			}
			
			tempPoints[0] = new Point2D(e.getX(),e.getY());
			compteurPoint++;
		}
		
		// On actualise la zone de dessin et les informations � chaque fois que la souris reste appuy�e
		
		((PanelInfos) this.getParent().getComponent(1)).refreshInfos(this.objets);
		posSouris = new Point2D (e.getX(), e.getY());
	}

	
	public void mouseReleased(MouseEvent e) {
		
		// Lorsque l'on relache le clic souris qui �tait enfonc�, diff�rentes actions vont se produire en fonction de la figure que l'on souhaite tracer
		
		if ( this.statut == "Segment" ) {
			
			p2 = new Point2D( e.getX(), e.getY() );
			
			// Ajout de l'objet dans la liste d'objets du Panel
			
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
			
			p2 = new Point2D(e.getX(),e.getY());
			
			tempPoints[0]= new Point2D( (p1.getPosX() + p2.getPosX())/2, p1.getPosY() );
			tempPoints[1]= new Point2D(  p2.getPosX(), (p1.getPosY() + p2.getPosY())/2 );
			tempPoints[2]= new Point2D( (p1.getPosX() + p2.getPosX())/2, p2.getPosY() );
			tempPoints[3]= new Point2D(  p1.getPosX(), (p1.getPosY() + p2.getPosY())/2 );
			
			objets.add( new Losange(tempPoints[0], tempPoints[1], tempPoints[2], tempPoints[3]) );
		}
		
		
		if ( this.statut == "Quadrangle" ) {
			
			if ( construction == false ) {
				
				p2 = new Point2D( e.getX(), e.getY() );
				this.rayon = p1.distance(p2);
				
				objets.add( new Cercle(p1, rayon) );
				objets.get(objets.size()-1).setCouleur(Color.GREEN);
				construction = true;
			}
		}
		
				
		if ( this.statut == "Ellipse" ) {
					
			p2 = new Point2D(e.getX(),e.getY());
			p3 = new Point2D( p2.getPosX(), p1.getPosY() );
			p4 = new Point2D( p1.getPosX(), p2.getPosY() );
			
			ga = p1.distance(p3);
			pa = p1.distance(p4);
			
			if ( p1.getPosY() > p2.getPosY() ) {
				
				tempo=p1;
				p1=p2;
				p2=tempo;
				
				tempo=p3;
				p3=p4;
				p4=tempo;
			}
			
			if ( p1.getPosX() > p3.getPosX() ) {
				
				tempo=p1;
				p1=p3;
				p3=tempo;
				
				tempo=p4;
				p4=p2;
				p2=tempo;
			}
			
			objets.add( new Ellipse(p1, ga, pa) );
		}
		
		
		if (this.statut == "Arc" ) {

			if ( construction == false ) {
				
				p2 = new Point2D(e.getX(), e.getY() );
				this.rayon = p1.distance(p2);
				
				this.objets.add( new Cercle(p1, rayon) );
				objets.get(objets.size()-1).setCouleur(Color.GREEN);
				construction = true;
			}
		}
		
		
		if ( statut == "Multi-rectangles" ) {
			
			if ( compteurPoint != 0 ) {
			
				p3 = new Point2D( e.getX(), e.getY());
				p2 = new Point2D(p3.getPosX(),p1.getPosY());
				p4 = new Point2D(p1.getPosX(),p3.getPosY());
				
				( (MultiRectangle) this.objets.get(this.objets.size()-1) ).addObjet(new Rectangle(p1, p2, p3, p4));
			}
		}
		
		if ( this.statut == "Multi-cercles" ) {
			
			if ( compteurPoint != 0 ) {
				
				tempPoints[1] = new Point2D (e.getX(),e.getY());
				( (MultiCercle) this.objets.get(this.objets.size()-1) ).addObjet( new Cercle(tempPoints[0],tempPoints[0].distance(tempPoints[1])));
				compteurPoint++;
			}
		}
		
        if ( this.statut == "Multi-ellipses" ) {
			
			if ( compteurPoint != 0 ) {
				
				p2 = new Point2D(e.getX(),e.getY());
				p3 = new Point2D( p2.getPosX(), tempPoints[0].getPosY() );
				p4 = new Point2D( tempPoints[0].getPosX(), p2.getPosY() );
				
				ga = tempPoints[0].distance(p3);
				pa = tempPoints[0].distance(p4);
				
				if ( tempPoints[0].getPosY() > p2.getPosY() ) {
					
					tempo=tempPoints[0];
					tempPoints[0]=p2;
					p2=tempo;
					
					tempo=p3;
					p3=p4;
					p4=tempo;
				}
				
				if ( tempPoints[0].getPosX() > p3.getPosX() ) {
					
					tempo=tempPoints[0];
					tempPoints[0]=p3;
					p3=tempo;
					
					tempo=p4;
					p4=p2;
					p2=tempo;
				}
								
				( (MultiEllipse) this.objets.get(this.objets.size()-1) ).addObjet(new Ellipse(tempPoints[0], ga, pa));
				compteurPoint++;
			}
		}
        
		// On actualise la zone de dessin et les informations � chaque fois que l'on rel�che le clic souris
		
		((PanelInfos) this.getParent().getComponent(1)).refreshInfos(this.objets);
		this.refreshDessin();
	}

	
    /////////////////////////////////////////// Fonctions permettant de tracer les figures ///////////////////////////////////////////  
	
	
	public void mouseExited(MouseEvent e) {
		
		this.deplacement = false;
	}
	
	public void drawLine(Graphics g) {
		
		g.setColor(couleur);
		g.drawLine(  (int) p1.getPosX(), (int) p1.getPosY(),(int) p2.getPosX() , (int)p2.getPosY( ));
	}
	
	public void drawRectangle(Graphics g) {
		
		g.setColor(couleur);
		g.drawRect( (int) p1.getPosX(), (int) p1.getPosY(), (int)  Math.abs( p2.getPosX()-p1.getPosX() ), (int)Math.abs( p4.getPosY()-p1.getPosY())) ;
	}
	
	public void drawPoly(Graphics g, int nbPoints) {
		
		g.setColor(couleur);
		g.drawPolygon(x, y, nbPoints);
	}
	
	public void drawCercle(Graphics g, double rayon) {
		
		g.setColor(couleur);
		g.drawOval((int)p3.getPosX(), (int)p3.getPosY(), 2* (int)rayon, 2* (int)rayon);
	}
	
	public void drawEllipse(Graphics g) {
		
		g.setColor(couleur); 
		g.drawOval((int) p1.getPosX(), (int) p1.getPosY(), (int) ga, (int) pa );	
	}
	
	public void drawArcCercle(Graphics g) {
		
		g.setColor(couleur); 
		g.drawArc( (int) (p3.getPosX()),(int)  (p3.getPosY()) , (int)  (2*rayon), (int)  (2*rayon),  (int) pa, (int)ga);
	}
	
	public double calculAngle(Point2D point , Point2D centre) {
		
		double cos = (point.getPosX() - centre.getPosX())/rayon;
		double sin = (point.getPosY()-centre.getPosY())/rayon;
		
		double angle = Math.toDegrees(Math.acos(cos));
		
		if ( sin > 0) angle = -angle;
		
			return (angle);
	}

	public void mouseDragged(MouseEvent e) {
		
		// Lorsque l'on effectue un d�placement
		
		if ( deplacement ) {
		
			if ( obj instanceof ObjetBasique ) {
				
				for ( int i=0 ; i<obj.getSize() ; i++ ) {
					
					int resX = (int) (e.getX() - posSouris.getPosX());
					int resY = (int) (e.getY() - posSouris.getPosY());
					
					Point2D nouvPoint = new Point2D( ( obj.getPoint(i).getPosX() + resX  ) , ( obj.getPoint(i).getPosY() + resY  ) );
					
					obj.setPoint(i, nouvPoint);
				}
			}
			
			 else if ( obj instanceof ObjetComposite ) {

				 for ( int i=0 ; i< ((ObjetComposite) obj).getTaille() ; i++ ) {
					
					 for ( int j=0 ; j<((ObjetComposite) obj).getObjet(i).getSize(); j++ ) {
						
						int resX = (int) (e.getX() - posSouris.getPosX());
						int resY = (int) (e.getY() - posSouris.getPosY());
						
						Point2D nouvPoint = new Point2D ( ((ObjetComposite) obj).getObjet(i).getPoint(j).getPosX() + resX, 
														( (ObjetComposite) obj).getObjet(i).getPoint(j).getPosY() + resY );
						
						((ObjetComposite) obj).getObjet(i).setPoint(j, nouvPoint);
					 }
				 }
			 }
			
			refreshDessin();
			posSouris = new Point2D (e.getX(), e.getY());
		}
	}

	// Fonction permettant de r�initialiser les attributs � leur valeur par d�faut
	
	public void refreshAttributs() {
		
		p1 = p2 = p3 = p4 = null;
		compteurPoint = 0;
		deplacement = false;
		construction = false;
		couleur = Color.BLACK;
	}

	
	/////////////////////////////////// M�thodes inutilis�es implent�es par l'ActionListener ///////////////////////////////////
	
	
	public void mouseMoved(MouseEvent arg0) {	
	}

	public void mouseEntered(MouseEvent e) {	
	}
	
}
