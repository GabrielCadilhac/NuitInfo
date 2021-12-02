import java.sql.Date;
import java.util.PriorityQueue;

public class TestQueue {
	
	public static void main(String[] args) {
		Date d1 = new Date(2020, 12, 5);
		Date d2 = new Date(2020, 12, 20);
		Date d3 = new Date(2020, 10, 6);
		Date d4 = new Date(2020, 5, 30);
		
		Fichier f1 = new Fichier("Test1",d1);
		Fichier f2 = new Fichier("Test2",d2);
		Fichier f3 = new Fichier("Test3",d3);
		Fichier f4 = new Fichier("Test4",d4);
		
		PriorityQueue<Fichier> test = new PriorityQueue<Fichier>(new FichierComparator());
		test.add(f1);
		test.add(f2);
		test.add(f3);
		test.add(f4);
		
		Fichier currentDate = null;

		while ((currentDate = test.poll()) != null) {
			System.out.println(currentDate);
		}
	}
}
