data class GridPosition(val x: Int, val y: Int)

operator fun GridPosition.plus(other: GridPosition) = GridPosition(
        x = this.x + other.x,
        y = this.y + other.y
)
