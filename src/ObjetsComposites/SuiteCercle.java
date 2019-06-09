package ObjetsComposites;

import java.util.ArrayList;

import General.ObjetBasique;
import General.Point2D;
import ObjetsBasiques.Cercle;
import ObjetsBasiques.Segment;

public class SuiteCercle extends MultiSegment {

	public SuiteCercle() {
		super();

	}

	public SuiteCercle(String[] objet) {
		
		super(objet);
	}

	public String toString() {
		
		return "Suite de Cercles";
	}
	
}
