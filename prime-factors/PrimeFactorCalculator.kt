object PrimeFactorCalculator {

    fun primeFactors(number: Int) = primeFactors(number.toLong()).map { it.toInt() }

    fun primeFactors(number: Long) = primeFactors(number, 2L, emptyList())

    private tailrec fun primeFactors(number: Long, divisor: Long, acc: List<Long>): List<Long> = when {
        number < divisor -> acc
        number.isMultipleOf(divisor) -> primeFactors(number / divisor, divisor, acc + divisor)
        else -> primeFactors(number, divisor + 1, acc)
    }

    private fun Long.isMultipleOf(number: Long) = this.rem(number) == 0L
}