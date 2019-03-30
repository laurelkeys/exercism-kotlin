object PascalsTriangle {

    fun computeTriangle(rows: Int): List<List<Int>> {
        require(rows >= 0) { "Rows can't be negative!" }

        return when (rows) {
            0 -> emptyList()
            else -> generateSequence(listOf(1)) {
                it.windowed(2)
                        .map { pair -> pair.sum() }
                        .wrapWithOnes()
            }.take(rows).toList()
        }
    }

    private fun List<Int>.wrapWithOnes() = listOf(1) + this + listOf(1)
}
