package ObjetsBasiques;
import General.ObjetBasique;
import General.Point2D;
import Interfaces.CalculsGeometriques;
import Interfaces.Informations;

public class Quadrangle extends ObjetBasique implements CalculsGeometriques, Informations{
	
	private double rayon;
	
	public Quadrangle(double r, Point2D p0, Point2D p1, Point2D p2, Point2D p3) {
		
		this.rayon = r;
		
		// Ajout à l'arraylist
		this.addPoint(p0);
		this.addPoint(p1);
		this.addPoint(p2);
		this.addPoint(p3);
		
		// Point de ref
		this.setRef(null);
	}

	@Override
	public double calculPerimetre() {

	    double perimetre = 0;
	    
	    perimetre += this.getPoint(0).distance( this.getPoint(1) ) ;
	    perimetre += this.getPoint(1).distance( this.getPoint(2) ) ;
	    perimetre += this.getPoint(2).distance( this.getPoint(3) ) ;
	    perimetre += this.getPoint(3).distance( this.getPoint(0) ) ;
	    
	    return perimetre;
	}

	@Override
	public double calculAire() { // TEMPORAIRE JSP COMMENT CA MARCHE
		
		// Longueurs des côtés
		double longueur1 = this.getPoint(0).distance( this.getPoint(1) );
		double longueur2 = this.getPoint(1).distance( this.getPoint(2) );
		double longueur3 = this.getPoint(2).distance( this.getPoint(3) );
		double longueur4 = this.getPoint(3).distance( this.getPoint(0) );
		
		// Longueurs des diagonales 
		double diagonale1 = this.getPoint(0).distance( this.getPoint(2) );
		double diagonale2 = this.getPoint(1).distance( this.getPoint(3) );
		
		return ((double) 1/4) * (	4 * diagonale1 * diagonale2
								-	Math.pow(( 	  longueur2*longueur2 
												+ longueur4*longueur4
												- longueur1*longueur1
												- longueur3*longueur3 ),2 ) );
	}
	
	@Override
	public String toString() {
		
		return "Quadrangle";
	}

	public double getRayon() {

		return rayon;
	}
	
	public String infosObjet() {

		return    ( "\n"
				  + "Type : Quadrangle \n"
				  + "Rayon = " + this.rayon + "\n"
				  + "p1 (" + ( this.getPoint(0).getPosX() + " , " + (this.getPoint(0).getPosY() + ")\n"
				  + "p2 (" +  ( this.getPoint(1)).getPosX()) + " , " +  this.getPoint(1).getPosY() + ")\n" 
				  + "p3 (" +  ( this.getPoint(2)).getPosX() + " , " +  this.getPoint(2).getPosY() + ")\n"  
				  + "p4 (" +  ( this.getPoint(3)).getPosX()) + " , " +  this.getPoint(3).getPosY() + ")");
	}
}
