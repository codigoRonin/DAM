const mongoose = require('mongoose');
const express = require('express');

const contact = require('./routes/contact');

mongoose.connect('mongodb://localhost:27017/contacts');


let app = express();
app.use(express.json());

app.use('/contacts', contact);

app.listen(8080);