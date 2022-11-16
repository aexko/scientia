
// @desc    Get all goals
// @route   GET /api/goals
// @access  private
const getGoals = (req, res) => {
    
}

// @desc    CREATE a goal
// @route   POAR /api/goals
// @access  private
const createGoal = (req, res) => {
    if (!req.body.text) {
        res.status(400)
        throw new Error('Add a text field to the request body, dumbass')
    } else {
        res.status(200).json({goals: 'GET goals'});
    }
}

// @desc    UPDATE a goal
// @route   PUT /api/goals/id
// @access  private
const updateGoal = (req, res) => {
    res.status(200).json({goals: `UPDATE goals ${req.params.id}`});
}

// @desc    Get all goals
// @route   DELETE /api/goals/id
// @access  private
const deleteGoal = (req, res) => {
    res.status(200).json({goals: `DELETE goals ${req.params.id}`});
}

module.exports = {
    getGoals,
    createGoal,
    updateGoal,
    deleteGoal
}