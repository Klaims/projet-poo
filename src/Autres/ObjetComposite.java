package Autres;
import java.util.ArrayList;

public class ObjetComposite extends ObjetGeometrique{
	
	private ArrayList<ObjetBasique> objets;
	
	public ObjetComposite(ArrayList<ObjetBasique> a) {
		
		this.objets=a;
		
	}
	
	public ObjetBasique getObjet(int i) {
				
		return(objets.get(i));
				
	}
	
	public void addObjet(ObjetBasique a) {
		
		objets.add(a);
		
	}
	
}
