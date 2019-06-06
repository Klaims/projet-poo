package General;
import java.util.ArrayList;

public abstract class ObjetComposite extends ObjetGeometrique{
	
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
	
	public ObjetComposite() {
			
		this.objets= new ArrayList<ObjetBasique>();
		}
	
	public int getTaille() {
		
		return(this.objets.size());
	}
	

}
