const http = require("http");
const express = require("express");

const pug=require('pug');
var file = require('file-system');
var fs = require('fs');
var app = express();
var server = http.createServer(app);

app.set('view engine', 'pug');
app.set('views', 'views/');

var ListeFile=JSON.parse(fs.readFileSync('Liste.json'))
const Folder = './fichier/';


function parcourDossier(Folder){ 
fs.readdir(Folder, (err, files) => {
  files.forEach(file => {
      var nbAcces=0;
    //console.log(file);
    var stat = (fs.statSync(Folder+file));

    var size = stat.size
    var date = stat.atime
    var fav=false
    var note= 0
    var s=file.split('.')
    var type= null
    if(s[1]){
        type=s[1]
    }
    var name = s[0]
    var path=Folder+file
    
    if (stat.isDirectory()){
        parcourDossier(Folder+file+'/')
    }
    else{
        //ajout du fichier
        ListeFile.push({"nom":name,"size":size,"date":date,"fav":fav,"note":note,"type":type,"path":path,"nbAcces":nbAcces})
        //console.log(name,size,date,fav,note,type,path);
        //console.log(ListeFile);
        var data=JSON.stringify(ListeFile)
        fs.writeFileSync('Liste.json', data)

    }
    
  })})

}

if(ListeFile.length==0){
  parcourDossier(Folder);
};

console.log(ListeFile.length);


function TriDivise (ListeFille) {  

//console.log("liste avant tir-> ",ListeFile);
ListeFile.sort(function (a, b) {
  return a.nbAcces - b.nbAcces;
});
var data=JSON.stringify(ListeFile)
fs.writeFileSync('Liste.json', data)
//console.log("liste apres tir-> ",ListeFile);
var L1=ListeFile.slice(0,ListeFile.length/3);
var L2=ListeFile.slice(ListeFile.length/3,(ListeFile.length/3)*2);
var L3=ListeFile.slice((ListeFile.length/3)*2);

console.log("Liste L1 -> ",L1.length);
console.log("Liste L2 -> ",L2.length);
console.log("Liste L3 -> ",L3.length);

var Data={"L1":L1,"L2":L2,"L3":L3}
return Data
}
var data=JSON.stringify(ListeFile)
fs.writeFileSync('Liste.json', data)

//process.env.PORT, process.env.IP,
server.listen(80, function()
{
        
        console.log("Serveur démarré");
        //console.log('TEST ->',ListeFile);
        app.get("/", function(req, res) {
            console.log('Chargement !!');
            
            res.render('index',{Data:TriDivise (ListeFile)})
        });
        app.get("/click", function(req, res) {
            console.log('modif !!');
            var nom=req.query.nom;
            console.log(nom);
            console.log(ListeFile[nom]);
            //
            for(var i in ListeFile){
              
              if (ListeFile[i].nom==nom){
                ListeFile[i].nbAcces+=1
                console.log('done');
              }
            }
            res.render("index",{Data : TriDivise(ListeFile)})
        });
        
        app.use('/views', express.static('views'));
        app.use('/fichier', express.static('fichier'));
});


