const express = require('express');

let app = express();

app.get('/services/sum/:n1/:n2', (req, res) => {
    let result = parseInt(req.params.n1) + parseInt(req.params.n2);
    res.send("" + result);
});

app.listen(80);