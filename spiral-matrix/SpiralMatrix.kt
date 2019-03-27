object SpiralMatrix {

    // sequence: [(i, i) -> (i, j) -> (j, j) -> (j, i) -> (i+1, i)] -> [(i+1, i+1) -> ...  , j = n - i
    fun ofSize(size: Int): Array<IntArray> {
        val matrix = Array(size) { IntArray(size) }
        val elements = (1..size * size).iterator()
        var (i, j) = 0 to size - 1
        while (i <= j) {
            (i..j).forEach { col -> matrix[i][col] = elements.nextInt() }
            (i + 1..j).forEach { row -> matrix[row][j] = elements.nextInt() }
            (j - 1 downTo i).forEach { col -> matrix[j][col] = elements.nextInt() }
            (j - 1 downTo i + 1).forEach { row -> matrix[row][i] = elements.nextInt() }
            i += 1
            j -= 1
        }
        return matrix
    }
}
