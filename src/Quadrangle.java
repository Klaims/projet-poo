
public class Quadrangle extends ObjetBasique implements Informations, CalculsGeometriques{
	
	private double rayon;
	
	public Quadrangle(Point2D p0, Point2D p1, Point2D p2, Point2D p3) {	
		this.addPoint(p0);
		this.addPoint(p1);
		this.addPoint(p2);
		this.addPoint(p3);
		this.setRef(null);
	}
<<<<<<< HEAD
	
	public double calculAire() {
		// on découpe le quadrangle en deux triangles
		Triangle T1 = new Triangle(this.getPoint(0), this.getPoint(1), this.getPoint(2));
		Triangle T2 = new Triangle(this.getPoint(2), this.getPoint(3), this.getPoint(0));
		// On additionne les aires de ces deux triangles pour donner l'aire totale
		return (T1.calculAire() + T2.calculAire());
	}
	
	
	public double calculPerimetre() {
	    // on initialise le périmètre à 0
	    double perimetre = 0;
	    
	    //calcul et ajout distance entre p1 et p2
	    perimetre = perimetre + Math.sqrt(Math.pow((this.getPoint(0).getPosX()-this.getPoint(1).getPosX()), 2) + Math.pow((this.getPoint(0).getPosY()-this.getPoint(1).getPosY()), 2));
	    //calcul  et ajout distance entre p2 et p3
	    perimetre = perimetre + Math.sqrt(Math.pow((this.getPoint(1).getPosX()-this.getPoint(2).getPosX()), 2) + Math.pow((this.getPoint(1).getPosY()-this.getPoint(2).getPosY()), 2));
	  //calcul et ajout distance entre p3 et p4
	    perimetre = perimetre + Math.sqrt(Math.pow((this.getPoint(2).getPosX()-this.getPoint(3).getPosX()), 2) + Math.pow((this.getPoint(2).getPosY()-this.getPoint(3).getPosY()), 2));
	  //calcul et ajout distance entre p4 et p1
	    perimetre = perimetre + Math.sqrt(Math.pow((this.getPoint(3).getPosX()-this.getPoint(0).getPosX()), 2) + Math.pow((this.getPoint(3).getPosY()-this.getPoint(0).getPosY()), 2));
	    
	    //on retourne la valeur du périmetre
	    return perimetre;
=======

	@Override
	public double calculPerimetre() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculAire() {
		// TODO Auto-generated method stub
		return 0;
>>>>>>> refs/remotes/origin/master
	}
}
