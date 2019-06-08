package ObjetsBasiques;
import General.ObjetBasique;
import General.Point2D;
import Interfaces.Informations;

public class Segment extends ObjetBasique implements Informations{
  
	public Segment(Point2D p1, Point2D p2){
  
	  	// Ajout à l'arraylist
	  	this.addPoint(p1);
    	this.addPoint(p2);
    
    	// Point de ref
    	double x = (p1.getPosX() + p2.getPosX())/2;
    	double y = (p1.getPosY() + p2.getPosY())/2;
    	this.setRef(new Point2D(x, y));
  	}
                
  	public Segment(String[] objet) {
		
  		Point2D p1 = new Point2D( new Double( objet[1].split(" ")[0]), new Double( objet[1].split(" ")[1]) );
  		Point2D p2 = new Point2D( new Double( objet[2].split(" ")[0]), new Double( objet[2].split(" ")[1]) );
  		
  		this.addPoint(p1);
    	this.addPoint(p2);
  		
  		double x = (p1.getPosX() + p2.getPosX())/2;
    	double y = (p1.getPosY() + p2.getPosY())/2;
    	this.setRef(new Point2D(x, y));
	}

	public String toString() {
	  
  		return "Segment";
  	}

	@Override
	public String infosObjet() {
		
		return    ( "\n"
				  + "Type : Segment \n"
				  + "p1 (" + ( this.getPoint(0).getPosX() + " , " + (this.getPoint(0).getPosY() + ")\n"
				  + "p2 (" +  ( this.getPoint(1)).getPosX()) + " , " +  this.getPoint(1).getPosY() +")") );
	}
}
