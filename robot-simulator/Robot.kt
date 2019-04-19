import Orientation.*

class Robot(var gridPosition: GridPosition, var orientation: Orientation) {

    constructor() : this(GridPosition(x = 0, y = 0), NORTH)

    private val advanceDelta = mapOf(
            NORTH to GridPosition(x =  0, y =  1),
            EAST  to GridPosition(x =  1, y =  0),
            SOUTH to GridPosition(x =  0, y = -1),
            WEST  to GridPosition(x = -1, y =  0)
    ).withDefault { GridPosition(x = 0, y = 0) }

    fun advance() {
        gridPosition += advanceDelta.getValue(orientation)
    }

    fun turnRight() {
        orientation = when (orientation) {
            NORTH -> EAST
            EAST  -> SOUTH
            SOUTH -> WEST
            WEST  -> NORTH
        }
    }

    fun turnLeft() {
        orientation = when (orientation) {
            NORTH -> WEST
            WEST  -> SOUTH
            SOUTH -> EAST
            EAST  -> NORTH
        }
    }

    fun simulate(instructions: String) {
        instructions.forEach {
            when (it) {
                'R' -> turnRight()
                'L' -> turnLeft()
                'A' -> advance()
            }
        }
    }
}