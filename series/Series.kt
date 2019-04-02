object Series {

    fun slices(length: Int, string: String): List<List<Int>> {
        require(string.length >= length && length > 0)
        return string
                .windowed(length)
                .map {
                    it.fold(emptyList<Int>()) { acc, c ->
                        acc + c.numericValue()
                    }
                }
    }

    private fun Char.numericValue() = this - '0' // this.toString().toInt()
}
