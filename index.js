const http = require("http");
const express = require("express");

const pug=require('pug');

var app = express();
var server = http.createServer(app);

app.set('view engine', 'pug');
app.set('views', 'views/');




server.listen(process.env.PORT || 80, function()
{
        console.log("Serveur démarré");
        app.get("/", function(req, res) {
   
            res.render('index')
        });
        app.use("public", express.static("public"));
        app.use('/views', express.static('views'));
});


