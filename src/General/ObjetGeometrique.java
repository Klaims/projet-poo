package General;
import java.awt.Color;
import java.util.ArrayList;

import Interfaces.Informations;

public abstract class ObjetGeometrique {

	private ArrayList<Point2D> points = new ArrayList<Point2D>(); 
	private Color couleur;
	
	public Point2D getPoint(int i) {
		
		return points.get(i);
	}
	
	public void addPoint(Point2D p) {
		
		this.points.add(p);
	}
	
	public void supprimer() {
		
		// TODO
	}
	
	public int getSize() {
		
		return this.points.size();
	}
	
	public abstract String infosObjet();

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
}
