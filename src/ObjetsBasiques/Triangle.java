package ObjetsBasiques;
import General.ObjetBasique;
import General.Point2D;
import Interfaces.CalculsGeometriques;
import Interfaces.Informations;

public class Triangle extends ObjetBasique implements CalculsGeometriques, Informations{

	  public Triangle(Point2D p1, Point2D p2, Point2D p3) {
	     
		  // Ajout à l'arraylist
		  this.addPoint(p1);
		  this.addPoint(p2);
		  this.addPoint(p3);
		      
		  // Point de ref
		  double x = (p1.getPosX() + p2.getPosX() + p3.getPosX())/3;
		  double y = (p1.getPosY() + p2.getPosY() + p3.getPosY())/3;
		  this.setRef(new Point2D(x, y));
		 
	  }
  
	  public Triangle(String[] objet) {
		
		  Point2D p1 = new Point2D( new Double( objet[1].split(" ")[0]), new Double( objet[1].split(" ")[1]) );
		  Point2D p2 = new Point2D( new Double( objet[2].split(" ")[0]), new Double( objet[2].split(" ")[1]) );
		  Point2D p3 = new Point2D( new Double( objet[3].split(" ")[0]), new Double( objet[3].split(" ")[1]) );
		  
		  // Ajout à l'arraylist
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
		  
		  return ((double) 1/2) * 	(	this.getPoint(0).getPosX() * ( this.getPoint(1).getPosY() - this.getPoint(2).getPosY() )
					  				+	this.getPoint(1).getPosX() * ( this.getPoint(2).getPosY() - this.getPoint(0).getPosY() )
					  				+	this.getPoint(2).getPosX() * ( this.getPoint(0).getPosY() - this.getPoint(1).getPosY() ) );
	  }

	  public String toString() {
		  
		  return "Triangle";
	  }

	@Override
	public String infosObjet() {
		
		return    ( "\n"
				  + "Type : Triangle \n"
				  + "p1 (" + ( this.getPoint(0).getPosX() + " , " + (this.getPoint(0).getPosY() + ")\n"
				  + "p2 (" +  ( this.getPoint(1)).getPosX()) + " , " +  this.getPoint(1).getPosY() + ")\n" 
				  + "p3 (" +  ( this.getPoint(2)).getPosX() + " , " +  this.getPoint(2).getPosY() + ")") );
	}

}
