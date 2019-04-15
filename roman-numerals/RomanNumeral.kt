object RomanNumeral {

    private val numerals = listOf(
            1000 to "M", 900 to "CM",
             500 to "D", 400 to "CD",
             100 to "C",  90 to "XC",
              50 to "L",  40 to "XL",
              10 to "X",   9 to "IX",
               5 to "V",   4 to "IV",
               1 to "I"
    )

    fun value(number: Int) = numerals
            .fold(number to "") { (remainder, acc), (value, numeral) ->
                remainder.rem(value) to acc + numeral.repeat(remainder.div(value))
            }.second
}