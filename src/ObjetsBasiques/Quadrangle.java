package ObjetsBasiques;
import General.ObjetBasique;
import General.Point2D;
import Interfaces.CalculsGeometriques;
import Interfaces.Informations;

public class Quadrangle extends ObjetBasique implements Informations, CalculsGeometriques{
	
	private double rayon;
	
	public Quadrangle(Point2D p0, Point2D p1, Point2D p2, Point2D p3) {
		
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
}
