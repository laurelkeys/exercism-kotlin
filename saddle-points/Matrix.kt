class Matrix(private val rows: List<List<Int>>) {

    private val size = rows[0].size
    private val columns by lazy { (0 until size).map { i -> rows.map { it[i] } } }

    val saddlePoints: Set<MatrixCoordinate> by lazy {
        maxRowValues.intersect(minColumnValues)
    }

    private val maxRowValues by lazy {
        rows.mapIndexed { i, row ->
            row.withIndex()
                    .filter { (_, it) -> it == row.max() }
                    .map { MatrixCoordinate(i, it.index) }
        }.flatten().toSet()
    }

    private val minColumnValues by lazy {
        columns.mapIndexed { j, column ->
            column.withIndex()
                    .filter { (_, it) -> it == column.min() }
                    .map { MatrixCoordinate(it.index, j) }
        }.flatten().toSet()
    }
}

