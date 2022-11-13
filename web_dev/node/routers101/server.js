const express = require("express");
const dotenv = require('dotenv');
const morgan = require('morgan');
const bodyparser = require('body-parser');
const path = require('path');


const app = express();
const PORT = process.env.PORT || 8080

// config.env file
dotenv.config({ path:'config.env'})

// log req
app.use(morgan("tiny"));

// parse req to bodyparser
app.use(bodyparser.urlencoded({
	extended:true
}));

// set view engine
app.set("view engine", "ejs")
app.set("views", path.resolve(__dirname, "views/ejs"))

// load assets
app.use('/css', express.static(path.resolve(__dirname, "assets/css")))
app.use('/img', express.static(path.resolve(__dirname, "assets/img")))
app.use('/js', express.static(path.resolve(__dirname, "assets/js")))

app.get("/", (req, res) => {
	res.send("Hello World!");
});

app.listen(PORT, () => {
	console.log(`Server is running on http://localhost:${PORT}`);
});
