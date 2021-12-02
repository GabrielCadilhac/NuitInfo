const http = require("http");
const express = require("express");

var app = express();
var server = http.createServer(app);

app.get("/", function(req, res) {
    res.sendFile(__dirname + "/index.html");
});

app.use("public", express.static("public"));

server.listen(3000, function()
{
        console.log("Serveur démarré");
});