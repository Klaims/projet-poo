package ObjetsBasiques;
import General.ObjetBasique;
import General.Point2D;
import Interfaces.CalculsGeometriques;
import Interfaces.Informations;

public class Rectangle extends ObjetBasique implements Informations, CalculsGeometriques{
	

	public Rectangle(Point2D p1, Point2D p2, Point2D p3 , Point2D p4) {
		
		this.addPoint(p1);
		this.addPoint(p2);
		this.addPoint(p3);
		this.addPoint(p4);
		
		this.setRef(null);
	}
	
	public String toString() {
		
		return    ( "\n"
				  + "Type : Rectangle \n"
				  + "p1 (" + ( this.getPoint(0).getPosX() + " , " + (this.getPoint(0).getPosY() + ")\n"
				  + "p2 (" +  ( this.getPoint(1)).getPosX()) + " , " +  this.getPoint(1).getPosY() + ")\n" 
				  + "p3 (" +  ( this.getPoint(2)).getPosX() + " , " +  this.getPoint(2).getPosY() + ")\n"  
				  + "p4 (" +  ( this.getPoint(3)).getPosX()) + " , " +  this.getPoint(3).getPosY() + ")");
	}
	
	public double calculAire() {
		
		 double longueur1 = Math.sqrt(  Math.pow( this.getPoint(1).getPosX() -  this.getPoint(0).getPosX(), 2)  + Math.pow( this.getPoint(1).getPosY() -  this.getPoint(0).getPosY(), 2)   ) ;
		 double longueur2 = Math.sqrt(  Math.pow( this.getPoint(3).getPosX() -  this.getPoint(2).getPosX(), 2)  + Math.pow( this.getPoint(3).getPosY() -  this.getPoint(2).getPosY(), 2)   ) ;
	 
		 double aire = longueur1*longueur2;
	 
	 return(aire);
				
	}

	@Override
	public double calculPerimetre() {

		return 0;
	}
}
