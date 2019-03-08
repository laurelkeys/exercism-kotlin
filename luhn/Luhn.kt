object Luhn {
    fun isValid(number: String) = number.filterNot { it.isWhitespace() }.let { n ->
        n.all { it.isDigit() } &&
                n.length > 1 &&
                n.reversed().foldIndexed(0) { index, acc, char ->
                    char.toString().toInt().let { int ->
                        acc + when {
                            index.isDivisibleBy(2) -> int
                            2 * int > 9 -> 2 * int - 9
                            else -> 2 * int
                        }
                    }

                }.isDivisibleBy(10)
    }
}

private fun Int.isDivisibleBy(number: Int) = this.rem(number) == 0