class Squares(private val n: Int) {

    fun squareOfSum() = (1..n).sum().squared()

    fun sumOfSquares() = (1..n).sumBy { it.squared() }

    fun difference() = squareOfSum() - sumOfSquares()
}

private fun Int.squared() = this * this