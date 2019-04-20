class MinesweeperBoard(private val inputBoard: List<String>) {

    fun withNumbers(): List<String> {
        return inputBoard.mapIndexed { row, string ->
            string.mapIndexed { col, char ->
                if (char == ' ') adjacentMines(row, col) else char
            }.joinToString("")
        }
    }

    private fun adjacentMines(row: Int, col: Int) =
            listOf(-1 to -1, -1 to 0, -1 to 1,
                    0 to -1,           0 to 1,
                    1 to -1,  1 to 0,  1 to 1)
                    .mapNotNull { (di, dj) -> inputBoard.getOrNull(row + di)?.getOrNull(col + dj) }
                    .map { if (it == '*') 1 else 0 }
                    .sum()
                    .let { if (it > 0) '0' + it else ' ' }
}