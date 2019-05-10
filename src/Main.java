import General.Point2D;
import ObjetsBasiques.Cercle;
import ObjetsBasiques.Losange;
import ObjetsBasiques.Quadrangle;
import ObjetsBasiques.Rectangle;
import ObjetsBasiques.Segment;
import ObjetsBasiques.Triangle;

public class Main {

	public static void main(String[] args) {
		
		Point2D p1 = new Point2D(0,0);
		Point2D p2 = new Point2D(2,0);
		Point2D p3 = new Point2D(2,2);
		Point2D p4 = new Point2D(0,2);
		
		Segment seg = new Segment(p1, p2);
		System.out.println(seg);
		
		Triangle trg = new Triangle(p1, p2, p3);
		System.out.println(trg);
		System.out.println(trg.calculPerimetre());
		System.out.println(trg.calculAire());
		
		Cercle crcl = new Cercle(p1, 3);
		System.out.println(crcl);
		System.out.println(crcl.calculPerimetre());
		System.out.println(crcl.calculAire());
		
		Quadrangle quad = new Quadrangle(5, p1, p2, p3, p4);
		System.out.println(quad);
		
		Rectangle rect = new Rectangle(p1, p2, p3, p4);
		System.out.println(rect);
		System.out.println(rect.calculPerimetre());
		System.out.println(rect.calculAire());
		
		Losange lsge = new Losange(p1, p2, p3, p4);
		System.out.println(lsge);
		System.out.println(lsge.calculPerimetre());
		System.out.println(lsge.calculAire());
	}
}
