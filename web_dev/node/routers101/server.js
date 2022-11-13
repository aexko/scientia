const express = require("express");
const dotenv = require('dotenv');
const morgan = require('morgan');


const app = express();
const PORT = process.env.PORT || 8080

dotenv.config({ path:'config.env'})


app.use(morgan("tiny"));

app.get("/", (req, res) => {
	res.send("Hello World!");
});

app.listen(PORT, () => {
	console.log(`Server is running on http://localhost:${PORT}`);
});
