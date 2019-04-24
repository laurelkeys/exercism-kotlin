import kotlin.math.floor
import kotlin.math.log

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
        return if (value == 0) intArrayOf(0) else convertToBase(
                toBase,
                quotient = value,
                index = 0,
                acc = IntArray(floor(log(value.toDouble(), toBase.toDouble())).toInt() + 1)
        )
    }

    private tailrec fun convertToBase(toBase: Int, quotient: Int, index: Int, acc: IntArray): IntArray =
            when (quotient) {
                0 -> acc.reversedArray()
                else -> convertToBase(
                        toBase,
                        quotient.div(toBase),
                        index + 1,
                        acc.apply { set(index, quotient.rem(toBase)) }
                )
            }

}