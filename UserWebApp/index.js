// Dépendances
var express = require("express");

var app = express();

app.use(express.static(__dirname + '/app'));

console.log("Server listening on port 8888");

app.listen(8888);