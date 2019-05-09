
public class Point2D {

	private double posX;
	private double posY;
	
	public Point2D(double x, double y) {
		
		this.posX=x;
		this.posY=y;
		
	}

	public double getPosX() {
		
		return posX;
		
	}

	public void setPosX(double posX) {
		
		this.posX = posX;
		
	}

	public double getPosY() {
		
		return posY;
		
	}

	public void setPosY(double posY) {
		
		this.posY = posY;
		
	}

	public String toString() {
		
		return ("Abscisse : " + posX + " Ordonnée : " + posY);
		
	}
	
}
