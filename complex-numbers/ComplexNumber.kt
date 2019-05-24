import kotlin.math.sqrt
import kotlin.math.exp
import kotlin.math.cos
import kotlin.math.sin

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {
    val abs = sqrt(real * real + imag * imag)
}

fun ComplexNumber.conjugate() = copy(imag = -imag)

operator fun ComplexNumber.plus(other: ComplexNumber) = ComplexNumber(
        real + other.real,
        imag + other.imag
)

operator fun ComplexNumber.minus(other: ComplexNumber) = ComplexNumber(
        real - other.real,
        imag - other.imag
)

operator fun ComplexNumber.times(other: ComplexNumber) = ComplexNumber(
        real * other.real - imag * other.imag,
        real * other.imag + other.real * imag
)

operator fun ComplexNumber.div(other: ComplexNumber) = (other.abs * other.abs).let {
    ComplexNumber(
            (real * other.real + imag * other.imag) / it,
            (other.real * imag - real * other.imag) / it
    )
}

fun exponential(exponent: ComplexNumber) = with(exponent) {
    ComplexNumber(exp(real) * cos(imag), exp(real) * sin(imag))
}
