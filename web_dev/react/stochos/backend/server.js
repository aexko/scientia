const express = require("express");
const dotenv = require("dotenv");
const morgan = require("morgan");
dotenv.config('./.env');
const port = process.env.PORT || 3000; // if no port is specified, use 3000
const app = express();

// to colorize the console output
var colors = require('colors');

const { errorHandler } = require("./middlewares/errorMiddleware");

// to log requests
app.use(morgan("dev"));

app.use('/api/goals', require('./routes/goalRoutes'));

// using the error handler middleware instead of the default one
app.use(errorHandler);

// middleware to handle raw json
app.use(express.json()); // raw json
app.use(express.urlencoded({ extended: true })); // form data


app.listen(port, () => {
	console.log(`Server listening on port ${port}`.green);
});
