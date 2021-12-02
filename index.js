const http = require("http");
const express = require("express");

const pug=require('pug');
var file = require('file-system');
var fs = require('fs');
var app = express();
var server = http.createServer(app);

app.set('view engine', 'pug');
app.set('views', 'views/');



var Dict=new Map();

Dict.set(1,[{nom:"Test",date:"",icone:"",fav:false,note:0,type:"",path:""}])
Dict.get(1).push({nom:"Test2",date:"",icone:"",fav:false,note:0,type:"",path:""})
//console.log(Dict);


server.listen(process.env.PORT, process.env.IP, function()
{
        console.log("Serveur démarré");
        app.get("/", function(req, res) {
   
            res.render('index')
        });
        
        app.use('/views', express.static('views'));
});

const Folder = './fichier/';

parcourDossier(Folder)
function parcourDossier(Folder){ 
fs.readdir(Folder, (err, files) => {
  files.forEach(file => {
    console.log(file);
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
        console.log(name,size,date,fav,note,type,path);
    }
  })})}