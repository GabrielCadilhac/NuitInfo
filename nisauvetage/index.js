const http = require("http");
const express = require("express");
const MongoClient = require("mongodb").MongoClient;
const { debuglog } = require("util");

const url_db = "mongodb://mongodb:27017";

var app = express();
var server = http.createServer(app);

app.get("/", function(req, res) {
    res.sendFile(__dirname + "/acceuil.html");
});


app.post("/sauveteurs", function(req, res) {
    MongoClient.connect(url_db, function(err, db)
    {
        var dbo = db.db("sauveteurs");
        dbo.collection("sauveteurs").find({}).toArray(function(err, result)
        {
            res.send(result);
            res.end();
            db.close();
        });
    });
});

app.post("/search", function(req, res)
{
    query = req.query;
    console.log("query:", query);
    MongoClient.connect(url_db, function(err, db)
    {
        var dbo = db.db("sauveteurs");
        dbo.collection("sauveteurs").find({"nom": query}).toArray(function(err, result)
        {
            dbo.collection("sauvetages").find({"date": query}).toArray(function(err, result1)
            {
                dbo.collection("bateaux").find({"nom": query}).toArray(function(err, result2)
                {
                    res.send(result.concat(result1).concat(result2));
                    res.end();
                    db.close();
                });
            });
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

app.use("/css", express.static("css"));
app.use("/img", express.static("img"));
app.use("/js", express.static("js"));

server.listen(process.env.PORT || 8080, function()
{
        console.log("Serveur démarré");
});