// @desc    Get all goals
// @route   GET /api/goals
// @access  private
const getGoals = (req, res) => {
    console.log("WHATT WOKRING");

	if (!req.body.text) {
		res.status(400);
		console.log("WHATT WOKRING");
		throw new Error("Add a text field to the request body, dumbass");
	} else {
		res.status(200).json({ goals: "GET goals" });
	}

};

// @desc    CREATE a goal
// @route   POST /api/goals
// @access  private
const createGoal = (req, res) => {
	if (!req.body.text) {
		res.status(400);
		console.log("DUMBASS");
		throw new Error("Add a text field to the request body, dumbass");
	} else {
		res.status(200).json({ goals: "GET goals" });
	}
};

// @desc    UPDATE a goal
// @route   PUT /api/goals/id
// @access  private
const updateGoal = (req, res) => {
	res.status(200).json({ goals: `UPDATE goals ${req.params.id}` });
    console.log(req.params.id)
};

// @desc    Get all goals
// @route   DELETE /api/goals/id
// @access  private
const deleteGoal = (req, res) => {
	res.status(200).json({ goals: `DELETE goals ${req.params.id}` });
};

module.exports = {
	getGoals,
	createGoal,
	updateGoal,
	deleteGoal,
};
