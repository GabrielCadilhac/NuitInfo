import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LoadFichier {



	PriorityQueue<Fichier> listFichier = new PriorityQueue<>(new FichierComparator());


		public LoadFichier(String path) throws IOException {
			File f=new File(path);
			if(f.isDirectory()) {
				listFichier=loader(f);
				}


		}
		public PriorityQueue<Fichier> loader(File f) throws IOException{
		
			PriorityQueue<Fichier> listF = new PriorityQueue<>(new FichierComparator());
			
				
				for(File f1 : f.listFiles()) {
					if(f1.isDirectory())
					 listF.addAll(loader(f1));
					else {
						Fichier fic = new Fichier(f1);
						listF.add(fic);
						loadIco(f1);

					}
				}
			

			



			return listF;
		}
	public void loadIco(File f) throws IOException{
			Fichier fic= new Fichier(f);
			File f2 = new File("D:\\NUIT DE LINFO\\Img\\"+fic.type+".png");
			if(!f2.exists())
				ImageIO.write(fic.icone, "PNG", f2);



		}
		public static void main(String[] args) throws IOException {
			LoadFichier test = new LoadFichier("D:\\NUIT DE LINFO");
			for(Fichier f : test.listFichier)
			{
				System.out.println(f.nomF+" "+f.dateLOpened);
			}

		}

	}
