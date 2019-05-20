class NumberSpeller {

    companion object {
        private val numberToSpelling = listOf(
                1000000000L to "billion",
                1000000L to "million",
                1000L to "thousand",
                100L to "hundred",
                90L to "ninety",
                80L to "eighty",
                70L to "seventy",
                60L to "sixty",
                50L to "fifty",
                40L to "forty",
                30L to "thirty",
                20L to "twenty",
                19L to "nineteen",
                18L to "eighteen",
                17L to "seventeen",
                16L to "sixteen",
                15L to "fifteen",
                14L to "fourteen",
                13L to "thirteen",
                12L to "twelve",
                11L to "eleven",
                10L to "ten",
                9L to "nine",
                8L to "eight",
                7L to "seven",
                6L to "six",
                5L to "five",
                4L to "four",
                3L to "three",
                2L to "two",
                1L to "one",
                0L to "zero"
        )
    }

    fun say(number: Long): String {
        require(number >= 0) { "Input must be non-negative" }
        require(number < 1000000000000) { "Input must be less than 1000000000000" }

        return numberToSpelling
                .first { (n, _) -> number >= n }
                .let { (n, spelling) ->
                    when {
                        number <= 20L -> spelling
                        number < 100L -> number.rem(10L).let { rem ->
                            spelling + if (rem == 0L) "" else "-" + say(rem)
                        }
                        else -> number.rem(n).let { rem ->
                            say(number / n) + " " + spelling + if (rem == 0L) "" else " " + say(rem)
                        }
                    }
                }

    }
}