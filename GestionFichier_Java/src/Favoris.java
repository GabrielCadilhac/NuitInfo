import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class Favoris implements java.io.Serializable {


	public HashSet<Integer> setFav ;

	public Favoris() {
		this.setFav= new HashSet<>();
		
	}
	
	public void save(HashSet<Integer> s) {
		   try {
			   ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("savefav.dat"));
			   oos.writeObject(s);
		        
		      } catch (IOException i) {
		         i.printStackTrace();
		      }
	}
	public Favoris load() {
		Favoris e= new Favoris() ;
	    try {
	    	ObjectInputStream ois = new ObjectInputStream(new FileInputStream("savefav.dat"));
	    	e.setFav = (HashSet<Integer>) ois.readObject();
	    	return e;
	      } catch (IOException i) {
	         i.printStackTrace();
	        
	      } catch (ClassNotFoundException c) {
	        
	         c.printStackTrace();
	        
	      }
		return e;
	}
	
	
	
	
	
	
}
