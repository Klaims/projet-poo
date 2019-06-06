package ObjetsComposites;

import java.util.ArrayList;

import General.ObjetBasique;
import General.ObjetComposite;
import Interfaces.Informations;

public class MultiSegment extends ObjetComposite implements Informations {

	public MultiSegment(ArrayList<ObjetBasique> a) {
		super(a);

	}


	public String infosObjet() {

		return null;
	}
	
	
}