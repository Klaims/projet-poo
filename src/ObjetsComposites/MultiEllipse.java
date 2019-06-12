package ObjetsComposites;

import java.util.ArrayList;

import General.ObjetBasique;
import General.ObjetComposite;

public class MultiEllipse extends ObjetComposite{

	public MultiEllipse() {
		
		super();
	}

	public String infosObjet() {

		return "Multi-ellipses \nNombre d'ellipses : " + this.getTaille();
	}
	
	public String toString() {
		
		return "Multi-ellipses";
	}
}
