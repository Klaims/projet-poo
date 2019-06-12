package ObjetsComposites;

import java.util.ArrayList;

import General.ObjetBasique;
import General.ObjetComposite;
import General.Point2D;
import ObjetsBasiques.Cercle;
import ObjetsBasiques.Rectangle;

public class MultiCercle extends ObjetComposite{

	public MultiCercle() {
		
		super();
	}

	public MultiCercle(String[] objet) {

		for (int i=1; i<objet.length; i+=2) {
			
			Point2D p = new Point2D( new Double( objet[i].split(" ")[0]), new Double( objet[i].split(" ")[1]) );
			Double r = new Double( objet[i+1] );
			
			this.addObjet( new Cercle(p,r) );
		}
	}

	public String infosObjet() {
		
		return "Multi-cercles \nNombre de cercles : " + this.getTaille();
	}
	
	public String toString() {
		
		return "Multi-cercles";
	}

}
