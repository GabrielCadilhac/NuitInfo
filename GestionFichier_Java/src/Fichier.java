import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Files;

public class Fichier {
	public String nomF;
	public Date dateLOpened;
	public BufferedImage icone;
	public boolean isFav;
	public int note;
	public String type;
	public String path;
	public int hCode;
	


	public Fichier(File f) throws IOException {
		this.nomF=f.getName();
		this.dateLOpened=getLastAcces(f);
		this.type=getTypeFile(this.nomF);
		this.path=f.getAbsolutePath();
		ImageIcon v =(ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(f);
		this.icone=toBufferedImage(v.getImage());
		this.isFav=false;
		this.note=0;
		this.hCode=f.hashCode();
		

	}


	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }


	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);


	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();


	    return bimage;
	}

	public int getNote() {
		return this.note;
	}

	public String getNom() {
		return this.nomF;
	}

	@Override
	public String toString() {
		return this.nomF;
	}

	public Date getLastAcces(File f) throws IOException {
		 BasicFileAttributes attrs = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
		 return new Date(attrs.lastAccessTime().toMillis());

	}
	public String getTypeFile(String fileName) {
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
		    return fileName.substring(i+1);
		}
		return null;
	}
}
