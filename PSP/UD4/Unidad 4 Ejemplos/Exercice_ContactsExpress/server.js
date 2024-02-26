const express = require("express");
const mongoose = require("mongoose");

const Contact = require("./models/contact");

mongoose.set("strictQuery", false);
mongoose.connect("mongodb://localhost:27017/contacts");

let app = express();

app.get("/contacts", (req, res) => {
  Contact.find()
    .then((result) => {
      res.status(200).send({ ok: true, result: result });
    })
    .catch((error) => {
      res.status(500).send({ ok: false, error: "Error obteniendo contactos" });
    });
});

app.get("/contacts/:id", (req, res) => {
  Contact.findById(req.params.id)
    .then((result) => {
      if (result) {
        let data = { error: false, result: result };
        res.send(data);
      } else {
        let data = { error: true, errorMessage: "Contact not found" };
        res.send(data);
      }
    })
    .catch((error) => {
      let data = { error: true, errorMessage: "Error getting contact" };
      res.send(data);
    });
});

app.listen(8080, () => console.log("Server escuchando"));
