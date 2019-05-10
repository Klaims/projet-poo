package ObjetsBasiques;
import General.ObjetBasique;
import General.Point2D;
import Interfaces.Informations;

public class Segment extends ObjetBasique implements Informations{
  
  public Segment(Point2D p1, Point2D p2){
    // On ajoute les points à l'ArrayList
    this.addPoint(p1);
    this.addPoint(p2);
    // On calcule le point de référence = milieu du segment
    double x = (p1.getPosX() + p2.getPosX())/2;
    double y = (p1.getPosY() + p2.getPosY())/2;
    this.setRef(new Point2D(x, y));
  }
                
  public String toString(){
    return ("Il s'agit d'un segment qui relie le point (" + this.getPoint(0).getPosX() + ", " + this.getPoint(0).getPosY() + " et le point (" + getPoint(1).getPosX() + ", " + getPoint(1).getPosY() + ").");
  }

}
