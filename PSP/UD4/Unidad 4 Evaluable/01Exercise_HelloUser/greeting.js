const os = require('os');

let user = os.userInfo().username;
console.log("Hello", user);