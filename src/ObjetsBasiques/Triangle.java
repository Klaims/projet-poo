package ObjetsBasiques;
import General.ObjetBasique;
import General.Point2D;
import Interfaces.CalculsGeometriques;
import Interfaces.Informations;

public class Triangle extends ObjetBasique implements CalculsGeometriques, Informations{

  // constructeur 
  public Triangle(Point2D p1, Point2D p2, Point2D p3){
      // on ajoute les points à l'arraylist
      this.addPoint(p1);
      this.addPoint(p2);
      this.addPoint(p3);
      
      // on calcule le point de référence
      double x = (p1.getPosX() + p2.getPosX() + p3.getPosX())/3;
      double y = (p1.getPosY() + p2.getPosY() + p3.getPosY())/3;
      this.setRef(new Point2D(x, y));
    }
  
  
  // ------------------ classes implémentées par CalculsGéometriques ------------------
  public double calculPerimetre(){
    // on initialise le périmètre à 0
    double perimetre = 0;
    
    //calcul et ajout distance entre p1 et p2
    perimetre = perimetre + Math.sqrt(Math.pow((this.getPoint(0).getPosX()-this.getPoint(1).getPosX()), 2) + Math.pow((this.getPoint(0).getPosY()-this.getPoint(1).getPosY()), 2));
    //calcul  et ajout distance entre p2 et p3
    perimetre = perimetre + Math.sqrt(Math.pow((this.getPoint(1).getPosX()-this.getPoint(2).getPosX()), 2) + Math.pow((this.getPoint(1).getPosY()-this.getPoint(2).getPosY()), 2));
    //calcul et ajout distance entre p3 et p1
    perimetre = perimetre + Math.sqrt(Math.pow((this.getPoint(2).getPosX()-this.getPoint(0).getPosX()), 2) + Math.pow((this.getPoint(2).getPosY()-this.getPoint(0).getPosY()), 2));
    
    //on retourne la valeur du périmetre
    return perimetre;
  }
 
    public double calculAire(){  
    // On calcule la hauteur du triangle 
	double x = (this.getPoint(0).getPosX() + this.getPoint(1).getPosX())/2; // calcul des coordonnées du milieu entre p1 et p2
	double y = (this.getPoint(0).getPosY() + this.getPoint(1).getPosY())/2;
	double H = Math.sqrt(Math.pow((this.getPoint(2).getPosX()-x), 2) + Math.pow((this.getPoint(2).getPosY()-y), 2)); // on calcule la hauteur
	double B = Math.sqrt(Math.pow((this.getPoint(0).getPosX()-this.getPoint(1).getPosX()), 2) + Math.pow((this.getPoint(0).getPosY()-this.getPoint(1).getPosY()), 2)); // on calcule la base 
	// Calcul de l'aire : base*hauteur/2
	return (B*H)/2;
	
  }
  
  
 // ------------------ classes implémentées par Informations ------------------
  public String toString(){
    return ("Il s'agit d'un segment composé des points : (" + this.getPoint(0).getPosX() + ", " + this.getPoint(0).getPosY() + ", (" + this.getPoint(1).getPosX() + ", " + this.getPoint(1).getPosY() + ") et (" + this.getPoint(2).getPosX() + ", " + this.getPoint(2).getPosY() + ").");
  }

}
