import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;

import javafx.scene.image.Image;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Files;

public class Fichier {
	public String nomF;
	public Date dateLOpened;
	public Icon icone;
	public boolean isFav;
	public int note;
	public String type;
	public String path;
	
	
	
	public Fichier(File f) throws IOException {
		this.nomF=f.getName();
		this.dateLOpened=getLastAcces(f);
		this.type=getTypeFile(this.nomF);
		this.path=f.getAbsolutePath();
		this.icone= FileSystemView.getFileSystemView().getSystemIcon( f );
		this.isFav=false;
		this.note=0;
		
	}
	
	public Date getDate() {
		return this.dateLOpened;
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
