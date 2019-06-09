package ObjetsComposites;

import java.util.ArrayList;

import General.ObjetBasique;
import General.ObjetComposite;
import General.Point2D;
import ObjetsBasiques.Rectangle;

public class MultiRectangle extends ObjetComposite{
	
	public MultiRectangle() {
		super();
	}

	public MultiRectangle(String[] objet) {
		
		for (int i=1; i<objet.length; i+=4) {
			
			Point2D p1 = new Point2D( new Double( objet[i].split(" ")[0]), new Double( objet[i].split(" ")[1]) );
			Point2D p2 = new Point2D( new Double( objet[i+1].split(" ")[0]), new Double( objet[i+1].split(" ")[1]) );
			Point2D p3 = new Point2D( new Double( objet[i+2].split(" ")[0]), new Double( objet[i+2].split(" ")[1]) );
			Point2D p4 = new Point2D( new Double( objet[i+3].split(" ")[0]), new Double( objet[i+3].split(" ")[1]) );
			
			this.addObjet( new Rectangle( p1, p2, p3, p4 ) );
		}
	}

	public String infosObjet() {
		
		return "Multi-rectangles \nTaille : " + this.getTaille();
	}
	
	public String toString() {
		
		return "Multi-rectangles";
	}
}
