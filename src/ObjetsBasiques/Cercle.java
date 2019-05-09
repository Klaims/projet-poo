package ObjetsBasiques;
import Autres.ObjetBasique;
import Autres.Point2D;
import Interfaces.CalculsGeometriques;
import Interfaces.Informations;

public class Cercle extends ObjetBasique  implements CalculsGeometriques, Informations{
	
	private int rayon;
	
	public Cercle(Point2D p, int r) {
		
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
}
