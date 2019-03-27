import kotlin.coroutines.experimental.buildSequence
import kotlin.math.ceil
import kotlin.math.sqrt

object PrimeFactorCalculator {

    private val primes = sequenceOf(2) +
            generateSequence(3) { it + 2 }.filter { it.isPrime() }

    fun primeFactors(number: Int): List<Int> {
        if (number <= 1) return emptyList()
        return buildSequence {
            primes
                    .takeWhile { it <= number.squareRootCeil() }
                    .filter { number.isMultipleOf(it) }
                    .forEach {
                        var remainder = number
                        while (remainder.isMultipleOf(it)) {
                            yield(it)
                            remainder /= it
                        }
                    }
        }.toList()
    }

    private fun Int.isPrime() = when {
        this.isMultipleOf(2) -> this == 2 // the only prime even number is 2
        else -> (3..this.squareRootCeil() step 2).none { this.isMultipleOf(it) }
    }

    private fun Int.isMultipleOf(number: Int) = this.rem(number) == 0

    private fun Int.squareRootCeil() = ceil(sqrt(this.toDouble())).toInt()
}
