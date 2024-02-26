const express = require('express');
let app = express();
app.get('/test', (req, res) => {
res.send('Hello Word');
});
app.listen(8080);