import kotlin.math.sqrt

object Prime {

    private val primes = sequenceOf(2) + generateSequence(3) { it + 2 }.filter { it.isPrime() }

    fun nth(n: Int): Int {
        require(n > 0) { "There is no zeroth prime." }
        return primes.elementAt(n - 1)
    }
}

private fun Int.isPrime() = when {
    this.isEven() -> this == 2
    else -> (sqrt(this.toDouble()).toInt()).let { squareRoot ->
        (3..squareRoot step 2).all { this.rem(it) != 0 }
    }
}

private fun Int.isEven() = this.rem(2) == 0
