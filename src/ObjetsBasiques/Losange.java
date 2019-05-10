package ObjetsBasiques;
import General.ObjetBasique;
import General.Point2D;
import Interfaces.CalculsGeometriques;
import Interfaces.Informations;

public class Losange extends ObjetBasique implements Informations, CalculsGeometriques{
	
	public Losange(Point2D p1, Point2D p2, Point2D p3 , Point2D p4) {
		
		this.addPoint(p1);
		this.addPoint(p2);
		this.addPoint(p3);
		this.addPoint(p4);
		
	}
	
	public String toString() {
		
		return    ( "\n"
				  + "Type : Losange \n"
				  + "p1 (" + ( this.getPoint(0).getPosX() + " , " + (this.getPoint(0).getPosY() + ")\n"
				  + "p2 (" +  ( this.getPoint(1)).getPosX()) + " , " +  this.getPoint(1).getPosY() + ")\n" 
				  + "p3 (" +  ( this.getPoint(2)).getPosX() + " , " +  this.getPoint(2).getPosY() + ")\n"  
				  + "p4 (" +  ( this.getPoint(3)).getPosX()) + " , " +  this.getPoint(3).getPosY() + ")");
	}

	@Override
	public double calculPerimetre() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculAire() {
		// TODO Auto-generated method stub
		return 0;
	}
}
