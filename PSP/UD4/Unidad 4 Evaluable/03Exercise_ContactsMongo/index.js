const mongoose = require("mongoose");
const Contact = require(__dirname + "/models/contact");

mongoose.set("strictQuery", false);
mongoose.connect("mongodb://localhost:27017/contacts");

if (process.argv[2] === 'i') {
  console.log("============== INSERTING CONTACTS ==============");
  let contacts = [];
  contacts.push(new Contact({ name: "Michel Cuartero", telephone: "966112233", age: 39 }));
  contacts.push(new Contact({ name: "Javier Fuertes", telephone: "611223344" }));
  contacts.push(new Contact({ name: "Cesáreo Ania", telephone: "965987654", age: 63 }));
  contacts.forEach(contact => {
    contact.save().then(result => {
      console.log("Contact added:");
      console.log(result);
    }).catch(error => {
      console.log("Error adding contact:", error);
    })
  });
}
if (process.argv[2] === 'l') {
  console.log("============== LISTING ALL CONTACTS ==============");
  Contact.find()
  .then(result => { console.log(result); })
  .catch(error => { console.log("Error listing contacts",error);});
  console.log("============== CONTACT Michel Cuartero ==============");
  Contact.find({ name: "Michel Cuartero" })
  .then(result => { console.log(result); })
  .catch(error => { console.log("Error listing contact",error);});
}

if (process.argv[2] === 'u') {
  console.log("============== UPDATING CONTACT Michel Cuartero ==============");
  Contact.findOneAndUpdate({ name: "Michel Cuartero" }, { $set: { age: 43 } },
    { new: true })
    .then(result => { console.log(result); })
    .catch(error => { console.log("Error updating contact", error); });
}

if (process.argv[2] === 'd') {
  console.log("============== DELETING CONTACT Cesáreo Ania ==============");
  Contact.findOneAndRemove({ name: "Cesáreo Ania" })
    .then(result => { console.log(result); })
    .catch(error => { console.log("Error deleting contact", error); });
}




