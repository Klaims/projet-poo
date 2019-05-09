
public class Losange extends ObjetBasique implements Informations{
	
	public Losange(Point2D p1, Point2D p2, Point2D p3 , Point2D p4) {
		
		this.addPoint(p1);
		this.addPoint(p2);
		this.addPoint(p3);
		this.addPoint(p4);
		
	}
	
	public String toString() {
		
		return("Le losange est composé des quatres points :"
				  + "  p1 (" + (this.getPoint(0).getPosX() + "," + (this.getPoint(0).getPosY() + ")"
				  + " p2 (" +  ( this.getPoint(1)).getPosX()) + " , " +  this.getPoint(1).getPosY() + ")" 
				  + " p3 (" +  ( this.getPoint(2)).getPosX() + " , " +  this.getPoint(2).getPosY() + ")"  
				  + " p4 (" +  ( this.getPoint(3)).getPosX()) + " , " +  this.getPoint(3).getPosY() + ")");
	}
}
