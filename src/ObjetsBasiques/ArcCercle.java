package ObjetsBasiques;

import General.Point2D;
import Interfaces.CalculsGeometriques;
import Interfaces.Informations;

public class ArcCercle extends Cercle implements Informations,CalculsGeometriques{

	private int angle_deb;
	private int angle_fin;
	
	public ArcCercle(Point2D centre, double rayon, int angle_deb, int angle_fin) {
		super(centre, rayon);
		
		this.angle_deb = angle_deb;
		this.angle_fin = angle_fin;
	}	
}
