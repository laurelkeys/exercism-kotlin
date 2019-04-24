class BaseConverter(private val fromBase: Int, private val digits: IntArray) {
    private val value: Int

    init {
        require(fromBase >= 2) { "Bases must be at least 2." }
        require(digits.isNotEmpty()) { "You must supply at least one digit." }
        require(digits.all { it >= 0 }) { "Digits may not be negative." }
        require(digits.all { it < fromBase }) { "All digits must be strictly less than the base." }
        require(digits.size == 1 || digits.first() != 0) { "Digits may not contain leading zeros." }

        value = digits.fold(0) { acc, i ->
            acc * fromBase + i
        }
    }

    fun convertToBase(toBase: Int): IntArray {
        require(toBase >= 2) { "Bases must be at least 2." }
        return generateSequence({ value.rem(toBase) to value.div(toBase) }) { (_, quotient) ->
           quotient.rem(toBase) to quotient.div(toBase)
        }
               .take(Math.floor(Math.log(value.toDouble()) / Math.log(toBase.toDouble())).toInt() + 1)
               .map { it.first }
               .toList()
               .asReversed()
               .toIntArray()
    }

}