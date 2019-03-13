class Matrix(private val rows: List<List<Int>>) {

    private val size = rows[0].size

    private val maxRowValues = rows.map { it.max() ?: 0 }

    private val minColumnValues = with(0 until this.size) {
        map { j -> map { i -> rows[i][j] }.min() ?: 0 }
    }

    val saddlePoints: Set<MatrixCoordinate> by lazy {
        rows.mapIndexed { i, row ->
            row.mapIndexedNotNull { j, it ->
                if (it >= maxRowValues[i] && it <= minColumnValues[j])
                    MatrixCoordinate(i, j)
                else
                    null
            }
        }.flatten().toSet()
    }
}

