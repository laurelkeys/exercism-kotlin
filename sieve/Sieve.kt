object Sieve {

    fun primesUpTo(limit: Int) = when {
        limit < 2 -> emptyList()
        else -> BooleanArray(limit + 1, init = { it > 1 })
                .apply {
                    forEachIndexed { number, isPrime ->
                        if (isPrime)
                            (number..limit step number).forEach { i ->
                                if (i > number) set(i, false)
                            }
                    }
                }
                .mapIndexed { number, isPrime ->
                    if (isPrime) number else 0
                }.filterNot { it == 0 }
    }
}