import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LoadFichier {

	
		
	ArrayList<Fichier> listFichier = new ArrayList();
	
	
		public LoadFichier(String path) throws IOException {
			File f=new File(path);
			if(f.isDirectory()) {
				listFichier=loader(f);
				}
				
			
		}
		public ArrayList<Fichier> loader(File f) throws IOException{
			boolean isFinish=true;
			ArrayList<Fichier> listF = new ArrayList();
			while(isFinish) {
				for(File f1 : f.listFiles()) {
					 listF.add(new Fichier(f1));
				}
				isFinish=false;
				
			}
			return listF;
		}
		public static void main(String[] args) throws IOException {
			LoadFichier test = new LoadFichier("D:\\NUIT DE LINFO");
			for(Fichier f : test.listFichier)
			{
				System.out.println(f.nomF);
			}
			
		}

	}



