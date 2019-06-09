package ObjetsComposites;

import java.util.ArrayList;

import General.ObjetBasique;
import General.ObjetComposite;
import General.Point2D;
import Interfaces.Informations;
import ObjetsBasiques.Segment;

public class MultiSegment extends ObjetComposite implements Informations {

	public MultiSegment() {
		
		super();
	}

	public MultiSegment(String[] objet) {
		
		for (int i=1; i<objet.length; i+=2) {
			
			Point2D p1 = new Point2D( new Double( objet[i].split(" ")[0]), new Double( objet[i].split(" ")[1]) );
			Point2D p2 = new Point2D( new Double( objet[i+1].split(" ")[0]), new Double( objet[i+1].split(" ")[1]) );
			
			this.addObjet( new Segment(p1,p2) );
		}
	}

	public String infosObjet() {

		return null;
	}
	
	public String toString() {
		
		return "Multi-segments";
	}
}