package General;

public class Vecteur2D {
	
	private Point2D p1;
	private Point2D p2;
	private boolean sens;
	
	public Vecteur2D(Point2D po1 , Point2D po2, boolean s ) {
		
		this.p1=po1;
		this.p2=po2;
		this.sens=s;
		
	}

	public Point2D getP1() {
		
		return p1;
		
	}

	public void setP1(Point2D p1) {
		
		this.p1 = p1;
		
	}

	public Point2D getP2() {
		
		return p2;
		
	}

	public void setP2(Point2D p2) {
		
		this.p2 = p2;
	}

	public boolean getSens() {
		
		return sens;
		
	}

	public void setSens(boolean sens) {
		
		this.sens = sens;
		
	}

	public String toString() {
		
		return ("Le vecteur est composé des points : p1(" + p1.getPosX() +" " +  p1.getPosY() + " et p2 (" + p2.getPosX() + " " + p2.getPosY());
	}
	
	
}
