package ObjetsBasiques;
import General.ObjetBasique;
import General.Point2D;
import Interfaces.CalculsGeometriques;
import Interfaces.Informations;

public class Quadrangle extends ObjetBasique implements CalculsGeometriques, Informations{
	
	private double rayon;
	
	public Quadrangle(double r, Point2D p0, Point2D p1, Point2D p2, Point2D p3) {
		
		this.rayon = r;
		this.addPoint(p0);
		this.addPoint(p1);
		this.addPoint(p2);
		this.addPoint(p3);
		
		this.setRef(null);
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
	
	@Override
	public String toString() {
		
		return    ( "\n"
				  + "Type : Quadrangle \n"
				  + "Rayon = " + this.rayon + "\n"
				  + "p1 (" + ( this.getPoint(0).getPosX() + " , " + (this.getPoint(0).getPosY() + ")\n"
				  + "p2 (" +  ( this.getPoint(1)).getPosX()) + " , " +  this.getPoint(1).getPosY() + ")\n" 
				  + "p3 (" +  ( this.getPoint(2)).getPosX() + " , " +  this.getPoint(2).getPosY() + ")\n"  
				  + "p4 (" +  ( this.getPoint(3)).getPosX()) + " , " +  this.getPoint(3).getPosY() + ")");
	}
}
