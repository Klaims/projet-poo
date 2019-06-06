package ObjetsComposites;

import java.util.ArrayList;

import General.ObjetBasique;
import General.ObjetComposite;

public class MultiRectangle extends ObjetComposite{
	
	public MultiRectangle() {
		super();
	}

	public String infosObjet() {
		
		return "Multi-rectangles \nTaille : " + this.getTaille();
	}
	
	public String toString() {
		
		return "Multi-rectangles";
	}
}
