object Raindrops {

    private fun Int.hasFactor(factor: Int) = this.rem(factor) == 0

    fun convert(number: Int) = buildString {
        if (number.hasFactor(3)) append("Pling")
        if (number.hasFactor(5)) append("Plang")
        if (number.hasFactor(7)) append("Plong")
        if (isEmpty()) append(number)
    }
}