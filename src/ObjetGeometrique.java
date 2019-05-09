import java.util.ArrayList;

public abstract class ObjetGeometrique {

	private ArrayList<Point2D> points;
	
	public Point2D getPoint(int i) {
		
		return points.get(i);
	}
	
	public void addPoint(Point2D p) {
		
		points.add(p);
	}
	
	public void supprimer() {
		
		// TODO
	}
}
