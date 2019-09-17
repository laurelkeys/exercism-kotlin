import java.lang.IllegalArgumentException

class ChangeCalculator(private val coins: List<Int>) {

    companion object {
        private const val UNREPRESENTABLE = -1
    }

    fun computeMostEfficientChange(amount: Int): List<Int> {
        require(amount >= 0) { "Negative totals are not allowed." }

        if (amount == 0) return emptyList()

        val smallestCoin = coins.min() ?: amount + 1
        require(amount >= smallestCoin) { "The total $amount cannot be represented in the given currency." }

        // Dynamic programming table
        val table = Array(size = amount - smallestCoin + 1) { index ->
            when (val value = index + smallestCoin) {
                in coins -> listOf(value) to 1
                else -> emptyList<Int>() to UNREPRESENTABLE
            }
        }

        val index = { value: Int -> value - smallestCoin }
        for (coin in coins.sortedDescending()) {
            for (value in coin..amount - coin) {
                val (usedCoins, usedCoinsCount) = table[index(value)]
                if (usedCoinsCount == UNREPRESENTABLE) continue
                if (table[index(value + coin)].first.isEmpty())
                    table[index(value + coin)] = usedCoins + coin to usedCoinsCount + 1
            }
        }

        return table[index(amount)].let { (usedCoins, usedCoinsCount) ->
            when (usedCoinsCount) {
                UNREPRESENTABLE -> throw IllegalArgumentException("The total $amount cannot be represented in the given currency.")
                else -> usedCoins.sorted()
            }
        }
    }
}