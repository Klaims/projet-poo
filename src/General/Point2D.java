package General;

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
	
	public double distance(Point2D p) {
		
		return 	Math.sqrt(
				Math.pow(p.posX - this.posX, 2)
				+
				Math.pow(p.posY - this.posY, 2)
				);
	}

	public String toString() {
		
		return ("X : " + posX + " Y : " + posY);
		
	}
	
}
