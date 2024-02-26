const express = require('express');

let app = express();

app.get('/services/sum/:n1/:n2', (req, res) => {
    let result = parseInt(req.params.n1) + parseInt(req.params.n2);
    res.send("" + result);
});

app.get('/services/example', (req, res) => {
    let result = {
        error:false,
        person: {
            name:"Peter",
            age:30,
            address:[
                {city:"London",street:"Some street 24"},
                {city:"New York",street:"Other street 12"}
            ]
        }
    };
    res.send(result);
});

app.listen(80);