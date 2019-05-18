package ObjetsBasiques;

import General.ObjetBasique;
import General.Point2D;
import Interfaces.CalculsGeometriques;
import Interfaces.Informations;

public class Ellipse extends ObjetBasique implements Informations,CalculsGeometriques {
	
	private double dga;
	
	public Ellipse(Point2D point, double demi_grand_axe) {
		
		this.dga=demi_grand_axe;
		this.addPoint(point);
		this.setRef(point);
	}
	
	public double calculPerimetre() {
		
		return 0;
	}

	public double calculAire() {
		
		return 0;
	}
}
