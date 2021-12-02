class Fichier {
    
	constructor ( nomF,dateLOpened,icone,isFav,note,type,path) {
		this.nomF=f.getName();
		this.dateLOpened=getLastAcces(f);
		this.type=getTypeFile(this.nomF);
		this.path=f.getAbsolutePath();
		this.icone=icone;
		this.isFav=false;
		this.note=0;
		
	}
};

f=new Fichier();