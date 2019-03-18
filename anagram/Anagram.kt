class Anagram(private val word: String) {

    private val lowerCaseSortedWord: List<Char> by lazy { word.toLowerCaseSortedArray() }

    private fun String.toLowerCaseSortedArray() = this.toLowerCase().toCharArray().sorted()

    fun match(list: List<String>) = list
            .filterNot { it.equals(word, ignoreCase = true) }
            .filter { it.toLowerCaseSortedArray() == lowerCaseSortedWord }
            .toSet()
}