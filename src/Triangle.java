public class Triangle extends ObjetBasique implements CalculsGeometriques, Informations{

  // constructeur 
  public Triangle(Point p1, Point p2, Point p3){
      // on ajoute les points à l'arraylist
      this.addPoint(p1);
      this.addPoint(p2);
      this.addPoint(p3);
      
      // on calcule le point de référence
      double x = (p1.getPosX() + p2.getPosX() + p3.getPosX())/3;
      double y = (p1.getPosY() + p2.getPosY() + p3.getPosY())/3;
      this.setRef(new Point(x, y));
    }
  
  
  // ------------------ classes implémentées par CalculsGéometriques ------------------
  public double calculPerimetre(){
    // on initialise le périmètre à 0
    double perimetre = 0;
    
    //calcul et ajout distance entre p1 et p2
    perimetre = perimetre + sqrt(pow((p1.getPosX()-p2.getPosX()), 2) + pow((p1.getPosY()-p2.getPosY()), 2));
    //calcul  et ajout distance entre p2 et p3
    perimetre = perimetre + sqrt(pow((p2.getPosX()-p3.getPosX()), 2) + pow((p2.getPosY()-p3.getPosY()), 2));
    //calcul et ajout distance entre p3 et p1
    perimetre = perimetre + sqrt(pow((p3.getPosX()-p1.getPosX()), 2) + pow((p3.getPosY()-p1.getPosY()), 2));
    
    //on retourne la valeur du périmetre
    return perimetre;
  }
 
  public double calculAire(){
    // à faire
  }
  
  
 // ------------------ classes implémentées par Informations ------------------
  public String toString(){
    return ("Il s'agit d'un segment composé des points : (" + this.getPoint(0).getPosX() + ", " + this.getPoint(0).getPosY() + ", (" + this.getPoint(1).getPosX() + ", " + this.getPoint(1).getPosY() + ") et (" + this.getPoint(2).getPosX() + ", " + this.getPoint(2).getPosY() + ").")
  }

}
