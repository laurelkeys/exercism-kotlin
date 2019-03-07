object CollatzCalculator {
    fun computeStepCount(n: Int) = if (n > 0) computeStepCount(n, 0) else throw IllegalArgumentException("Only natural numbers are allowed")

    private tailrec fun computeStepCount(n: Int, acc: Int): Int = when {
        n == 1 -> acc
        n.isEven() -> computeStepCount(n / 2, acc + 1)
        else -> computeStepCount(3 * n + 1, acc + 1)
    }
}

private fun Int.isEven() = this.rem(2) == 0