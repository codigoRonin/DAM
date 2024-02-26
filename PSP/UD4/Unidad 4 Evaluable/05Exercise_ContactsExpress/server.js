const mongoose = require('mongoose');
const express = require('express');

const Contact = require('./models/contact');

mongoose.connect('mongodb://localhost:27017/contacts');


let app = express();
app.use(express.json());

app.get('/contacts', (req, res) => {
    Contact.find().then(result => {
        res.send(result);
    })
});

app.get('/contacts/:id', (req, res) => {
    Contact.findById(req.params.id).then(result => {
        if (result) {
            let data = {error: false, result: result};
            res.send(data);
        } else {
            let data = {error: true, errorMessage: "Contact not found"};
            res.send(data);
        }
    }).catch(error => {
        let data = {error: true, errorMessage: "Error getting contact"};
        res.send(data);
    });
});

app.post('/contacts', (req, res) => {
    let newContact = new Contact({
        name: req.body.name, 
        telephone: req.body.telephone, 
        age: req.body.age
    });
    newContact.save().then(result => {
        let data = {error: false, result: result};
        res.send(data);
    }).catch(error => {
        let data = {error: true, errorMessage:"Error adding contact"};
        res.send(data);
    });
});

app.put('/contacts/:id', (req, res) => {
    Contact.findByIdAndUpdate(req.params.id, {
        $set: {
            name: req.body.name,
            telephone: req.body.telephone,
            age: req.body.age
        }
    }, {new: true}).then(result => {
        let data = {error: false, result: result};
        res.send(data);
    }).catch(error => {
        let data = {error: true, errorMessage:"Error updating contact"};
        res.send(data);
    });
});

app.delete('/contacts/:id', (req, res) => {
    Contact.findByIdAndRemove(req.params.id).then(result => {
        let data = {error: false, result: result};
        res.send(data);
    }).catch(error => {
        let data = {error: true, errorMessage:"Error removing contact"};
        res.send(data);
    });
});

app.listen(8080);