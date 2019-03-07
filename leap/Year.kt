class Year(private val year: Int) {
    val isLeap = when {
        year.isDivisibleBy(4) -> {
            if (!year.isDivisibleBy(100))
                true
            else year.isDivisibleBy(400)
        }
        else -> false
    }
}

private fun Int.isDivisibleBy(int: Int) = this.rem(int) == 0