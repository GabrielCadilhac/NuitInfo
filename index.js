const http = require("http");
const express = require("express");

const pug=require('pug');
var file = require('file-system');
var fs = require('fs');
var app = express();
var server = http.createServer(app);

app.set('view engine', 'pug');
app.set('views', 'views/');
;
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
//parcourDossier(Folder);
console.log("liste avant tir-> ",ListeFile);
ListeFile.sort(function (a, b) {
    return a.nbAcces - b.nbAcces;
  });
console.log("liste apres tir-> ",ListeFile);

var data=JSON.stringify(ListeFile)
fs.writeFileSync('Liste.json', data)


server.listen(80, function()
{
        
        console.log("Serveur démarré");
        //console.log('TEST ->',ListeFile);
        app.get("/", function(req, res) {
            console.log('Chargement !!');
            
            res.render('index',{ListeFile:ListeFile})
        });
        
        app.use('/views', express.static('views'));
});


