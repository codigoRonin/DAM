const os = require('os');
const express = require('express');

let app = express();

app.get('/date', (req, res) => {
    res.send(new Date());
});

app.get('/user', (req, res) => {
    res.send("Current user is " + os.userInfo().username);
});

app.listen(8080);