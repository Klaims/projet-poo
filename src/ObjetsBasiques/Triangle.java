package ObjetsBasiques;
import General.ObjetBasique;
import General.Point2D;
import Interfaces.CalculsGeometriques;
import Interfaces.Informations;

public class Triangle extends ObjetBasique implements CalculsGeometriques, Informations{

	  public Triangle(Point2D p1, Point2D p2, Point2D p3) {
	     
		  // Ajout � l'arraylist
		  this.addPoint(p1);
		  this.addPoint(p2);
		  this.addPoint(p3);
		      
		  // Point de ref
		  double x = (p1.getPosX() + p2.getPosX() + p3.getPosX())/3;
		  double y = (p1.getPosY() + p2.getPosY() + p3.getPosY())/3;
		  this.setRef(new Point2D(x, y));
		 
	  }
  
	  public double calculPerimetre() {
		  
		    double perimetre = 0;
		    
		    perimetre += this.getPoint(0).distance( this.getPoint(1) );
		    perimetre += this.getPoint(1).distance( this.getPoint(2) );
		    perimetre += this.getPoint(2).distance( this.getPoint(0) );
		    
		    return perimetre;
	  }
 
	  public double calculAire(){ 
		  
		// On calcule la hauteur du triangle 
		double x = (this.getPoint(0).getPosX() + this.getPoint(1).getPosX())/2; // calcul des coordonnées du milieu entre p1 et p2
		double y = (this.getPoint(0).getPosY() + this.getPoint(1).getPosY())/2;
		double H = Math.sqrt(Math.pow((this.getPoint(2).getPosX()-x), 2) + Math.pow((this.getPoint(2).getPosY()-y), 2)); // on calcule la hauteur
		double B = Math.sqrt(Math.pow((this.getPoint(0).getPosX()-this.getPoint(1).getPosX()), 2) + Math.pow((this.getPoint(0).getPosY()-this.getPoint(1).getPosY()), 2)); // on calcule la base 
		// Calcul de l'aire : base*hauteur/2
		return (B*H)/2;
	
	  }

	  public String toString() {
	  
		  return    ( "\n"
				  + "Type : Triangle \n"
				  + "p1 (" + ( this.getPoint(0).getPosX() + " , " + (this.getPoint(0).getPosY() + ")\n"
				  + "p2 (" +  ( this.getPoint(1)).getPosX()) + " , " +  this.getPoint(1).getPosY() + ")\n" 
				  + "p3 (" +  ( this.getPoint(2)).getPosX() + " , " +  this.getPoint(2).getPosY() + ")") );
  		}

}