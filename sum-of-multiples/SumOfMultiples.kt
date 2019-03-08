object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        return factors
                .flatMap { factor ->
                    generateSequence(factor)
                    { factor + it }
                            .takeWhile { it < limit }
                            .asIterable()
                }
                .toSet()
                .sum()
    }
}