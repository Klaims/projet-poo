package ObjetsBasiques;
import General.ObjetBasique;
import General.Point2D;
import Interfaces.CalculsGeometriques;
import Interfaces.Informations;

public class Rectangle extends ObjetBasique implements Informations, CalculsGeometriques{
	

	public Rectangle(Point2D p1, Point2D p2, Point2D p3 , Point2D p4) {
		
		// Ajout � l'arraylist
		this.addPoint(p1);
		this.addPoint(p2);
		this.addPoint(p3);
		this.addPoint(p4);
		
		// Point de ref
		this.setRef(null);
	}
	
	public Rectangle(String[] objet) {
		
		Point2D p1 = new Point2D( new Double( objet[1].split(" ")[0]), new Double( objet[1].split(" ")[1]) );
		Point2D p2 = new Point2D( new Double( objet[2].split(" ")[0]), new Double( objet[2].split(" ")[1]) );
		Point2D p3 = new Point2D( new Double( objet[3].split(" ")[0]), new Double( objet[3].split(" ")[1]) );
		Point2D p4 = new Point2D( new Double( objet[4].split(" ")[0]), new Double( objet[4].split(" ")[1]) );
		
		// Ajout � l'arraylist
		this.addPoint(p1);
		this.addPoint(p2);
		this.addPoint(p3);
		this.addPoint(p4);
		
		// Point de ref
		this.setRef(null);
	}

	public String toString() {
		
		return "Rectangle";
	}
	
	@Override
	public double calculAire() {
		
		 double longueur1 = this.getPoint(0).distance( this.getPoint(1) );
		 double longueur2 = this.getPoint(1).distance( this.getPoint(2) );
	 
		 double aire = longueur1*longueur2;
	 
	 return(aire);	
	}

	@Override
	public double calculPerimetre() {

	    double perimetre = 0;
	    
	    perimetre += this.getPoint(0).distance( this.getPoint(1) ) * 2 ;
	    perimetre += this.getPoint(1).distance( this.getPoint(2) ) * 2 ;
	    
	    return perimetre;
	}

	@Override
	public String infosObjet() {
		
		return    ( "\n"
				  + "Type : Rectangle \n"
				  + "p1 (" + ( this.getPoint(0).getPosX() + " , " + (this.getPoint(0).getPosY() + ")\n"
				  + "p2 (" +  ( this.getPoint(1)).getPosX()) + " , " +  this.getPoint(1).getPosY() + ")\n" 
				  + "p3 (" +  ( this.getPoint(2)).getPosX() + " , " +  this.getPoint(2).getPosY() + ")\n"  
				  + "p4 (" +  ( this.getPoint(3)).getPosX()) + " , " +  this.getPoint(3).getPosY() + ")");
	}
}
