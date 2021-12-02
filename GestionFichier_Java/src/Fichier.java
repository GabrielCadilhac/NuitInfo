import java.awt.Image;
import java.util.Comparator;
import java.util.Date;

public class Fichier{
	public String nomF;
	public Date dateLOpened;
	public Image icone;
	public boolean isFav;
	public int note;
	public String type;
	
	public Fichier(String nom, Date date) {
		this.nomF = nom;
		this.dateLOpened = date;
	}

	public Date getDate() {
		return this.dateLOpened;
	}
	
	public String getNom() {
		return this.nomF;
	}
	
	@Override
	public String toString() {
		return this.nomF;
	}
}

class FichierComparator implements Comparator<Fichier>{

	@Override
	public int compare(Fichier o1, Fichier o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        int s = o1.getDate().compareTo(o2.getDate());
        if (s != 0) {
            return s;
        }
        return o1.getNom().compareTo(o2.getNom());
	}
	
}
