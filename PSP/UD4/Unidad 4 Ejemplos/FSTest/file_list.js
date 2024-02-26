const path = "C:/Users/miche";
const fs = require("fs");
fs.readdirSync(path).forEach((file) => {
  console.log(file);
});
