import kotlin.math.ceil

class Series(private val digits: String) {

    init {
        require(digits.all { it.isDigit() })
    }

    fun getLargestProduct(length: Int): Int {
        require(length in 0..digits.length)
        return List(digits.length - length + 1) { index ->
            digits
                    .map { it.toString().toInt() }
                    .subList(index, index + length)
                    .fold(1) { acc, i -> acc * i }
        }.max() ?: 1
    }
}