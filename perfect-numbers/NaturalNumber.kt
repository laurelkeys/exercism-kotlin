import Classification.DEFICIENT
import Classification.PERFECT
import Classification.ABUNDANT

enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    require(naturalNumber > 0)
    return naturalNumber.factors().sum().let {
        when {
            it > naturalNumber -> ABUNDANT
            it < naturalNumber -> DEFICIENT
            else -> PERFECT
        }
    }
}

private fun Int.hasFactor(factor: Int) = this.rem(factor) == 0

private fun Int.factors() = (1..this.div(2)).filter { this.hasFactor(it) }
