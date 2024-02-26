const mongoose = require("mongoose");
const Contact = require("./models/contact");

mongoose.set("strictQuery", false);
mongoose.connect("mongodb://localhost:27017/contacts"),
  () => {
    console.log("mongdb is connected");
  };


let contact1 = new Contact({
  name: "Michel",
  telephone: "966112233",
  age: 39,
});
contact1
  .save()
  .then((result) => {
    console.log("Contact added:", result);
  })
  .catch((error) => {
    console.log("ERROR adding contact:", error);
  });

let contact2 = new Contact({
  name: "Matuzalem",
  telephone: "965123456",
  age: 20,
});
contact2
  .save()
  .then((result) => {
    console.log("Contact added:", result);
  })
  .catch((error) => {
    console.log("ERROR adding contact:", error);
  });

let contactX = new Contact({
  name: "Juan",
  telephone: "611885599",
  age: 139,
});
contactX
  .save()
  .then((result) => {
    console.log("Contact added:", result);
  })
  .catch((error) => {
    console.log("ERROR adding contact:", error);
  });
