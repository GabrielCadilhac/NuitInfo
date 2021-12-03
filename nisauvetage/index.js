const http = require("http");
const express = require("express");
const MongoClient = require("mongodb").MongoClient;

const url_db = "mongodb://mongodb:27017";

var app = express();
var server = http.createServer(app);

app.get("/", function(req, res) {
    res.sendFile(__dirname + "/acceuil.html");
});


app.get("/sauveteurs", function(req, res) {
    MongoClient.connect(url_db, function(err, db)
    {
        console.log(req.xhr);
        var dbo = db.db("sauveteurs");
        dbo.collection("sauveteurs").find({}).toArray(function(err, result)
        {
            db.close();
        });
    });
});


app.get("/testbdd", function(req, res) {
    MongoClient.connect(url_db, function(err, db)
    {
        var dbo = db.db("sauveteurs");
        dbo.collection("test").find({}).toArray(function(err, result)
        {
            db.close();
        });
    });

    res.send("ui");
    res.end();
});

app.use("css", express.static("css"));
app.use("img", express.static("img"));
app.use("js", express.static("js"));

server.listen(process.env.PORT || 8080, function()
{
        console.log("Serveur démarré");
});