class DiamondPrinter {
    private fun buildMiddle(char: Char) = if (char == 'A') "$char" else char + " ".repeat(2 * (char - 'A') - 1) + char

    fun printToList(char: Char): List<String> {
        val top = ('A'..char).map {
            " ".repeat(char - it) + buildMiddle(it) + " ".repeat(char - it)
        }
        return top + top.reversed().drop(1)
    }
}
