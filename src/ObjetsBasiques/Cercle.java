package ObjetsBasiques;
import General.ObjetBasique;
import General.Point2D;
import Interfaces.CalculsGeometriques;
import Interfaces.Informations;

public class Cercle extends ObjetBasique  implements CalculsGeometriques, Informations{
	
	private double rayon;
	
	public Cercle(Point2D p, double r) {
		
		this.addPoint(p);
		this.setRef(p);
		this.rayon=r;
	}

	public Cercle(String[] objet) {
		
		Point2D p = new Point2D( new Double( objet[1].split(" ")[0]), new Double( objet[1].split(" ")[1]) );
		Double r = new Double( objet[2] );
		
		this.addPoint(p);
		this.setRef(p);
		this.rayon=r;
	}

	public double calculPerimetre() {
		
		double perimetre = Math.PI*2*this.rayon;
		
		return (perimetre);
	}

	
	public double calculAire() {
		
		double aire = Math.PI*Math.pow(rayon, 2);
		
		return(aire);
	}
	
	public String toString() {
		
		return "Cercle";
	}

	public double getRayon() {
		
		return this.rayon;
	}
	
	public String infosObjet() {
		
		return    ( "\n"
				  + "Type : Cercle \n"
				  + "Rayon = " + this.rayon + "\n"
				  + "Centre = (" + ( this.getPoint(0).getPosX() + " , " + (this.getPoint(0).getPosY() +")" ) )
				  );
	}
	

	public Point2D getCentre(){
		return this.getPoint(0);
	}
}
