object ETL {

    fun transform(pointsPerLetter: Map<Int, List<Char>>) = pointsPerLetter
            .entries
            .fold(emptyMap<Char, Int>()) { acc, (points, letters) ->
                acc + letters.map { it.toLowerCase() to points }
            }
}