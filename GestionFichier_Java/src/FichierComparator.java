import java.util.Comparator;

public class FichierComparator implements Comparator<Fichier> {
	
	@Override
	public int compare(Fichier o1, Fichier o2) {
		if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1; // o1 < o2
        }
        if (o2 == null) {
            return 1; // o1 > o2
        }
        int s = o1.getNote() - o2.getNote();
        if (s != 0) {
            return -s;
        }
        return o1.getNom().compareTo(o2.getNom());
	}

}
