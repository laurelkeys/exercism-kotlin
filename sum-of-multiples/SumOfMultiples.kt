object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        return factors
                .flatMap { factor ->
                    0 until limit step factor
                }
                .toSet()
                .sum()
    }
}