package ObjetsBasiques;

import General.Point2D;
import Interfaces.CalculsGeometriques;
import Interfaces.Informations;

public class ArcCercle extends Cercle implements Informations,CalculsGeometriques{

	private double angle_deb;
	private double angle_longueur;
	
	public ArcCercle(Point2D centre, double rayon, double angle_deb, double angle_l) {
		super(centre, rayon);
		
		this.angle_deb = angle_deb;
		this.angle_longueur = angle_l;
	}	

	public ArcCercle(String[] objet) {
		
		super(objet);
		
		Double angle_deb = new Double( objet[3] );
		Double angle_l = new Double( objet[4] );
		
		this.angle_deb = angle_deb;
		this.angle_longueur = angle_l;
	}

	public double getAngleDeb(){
		return angle_deb;
	}
	
	public double getAngleLongueur(){
		return angle_longueur;
	}
	
	public String toString() {
		
		return "Arc";
	}
}
