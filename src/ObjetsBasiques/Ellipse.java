package ObjetsBasiques;

import General.ObjetBasique;
import General.Point2D;
import Interfaces.CalculsGeometriques;
import Interfaces.Informations;

public class Ellipse extends ObjetBasique implements Informations,CalculsGeometriques {
	
	private double ga; // Grand axe
	private double pa; // Petit axe
	
	public Ellipse(Point2D p1, double ga, double pa) {
	
		this.addPoint(p1);
		this.setGa(ga);
		this.setPa(pa);
	}
	
	public Ellipse(String[] objet) {
		
		Point2D p = new Point2D( new Double( objet[1].split(" ")[0]), new Double( objet[1].split(" ")[1]) );
		Double ga = new Double ( objet[2] );
		Double pa = new Double ( objet[3] );
		
		this.addPoint(p);
		this.setGa(ga);
		this.setPa(pa);
	}

	public double calculPerimetre() {
		
		return 0;
	}

	public double calculAire() {
		
		return 0;
	}

	public double getGa() {
		return ga;
	}

	public void setGa(double ga) {
		this.ga = ga;
	}

	public double getPa() {
		return pa;
	}

	public void setPa(double pa) {
		this.pa = pa;
	}

	public String infosObjet() {
		
		return    ( "\n"
				  + "Type : Cercle \n"
				  + "Grand axe = " + this.ga + "\n"
				  + "Petit axe = " + this.pa + "\n"
				  + "Centre = (" + ( this.getPoint(0).getPosX() + " , " + (this.getPoint(0).getPosY() +")" ) )
				  );
	}
	
	public String toString() {
		
		return "Ellipse";
	}
}
