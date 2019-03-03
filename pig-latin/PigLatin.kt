object PigLatin {
    private val vowels = listOf('a', 'e', 'i', 'o', 'u')
    private val consonants = ('a'..'z').filter { it !in vowels }

    private fun String.span(predicate: (Char) -> Boolean) = this.takeWhile(predicate) to this.dropWhile(predicate)

    private fun translateWord(word: String): String {
        return when {
            word.first() in vowels -> word
            word.take(2) in listOf("xr", "yt") -> word
            else -> {
                val (head, tail) = word.span { it in consonants }
                if (head.last() == 'q' && tail.first() == 'u') {
                    tail.drop(1) + head + tail.first()
                } else if (word.takeWhile { it != 'y' }.all { it in consonants }) {
                    word.span { it != 'y' }.toList().reversed().joinToString("")
                } else {
                    tail + head
                }
            }
        } + "ay"
    }

    fun translate(input: String) = input
            .split(" ")
            .joinToString(" ") { translateWord(it) }
}