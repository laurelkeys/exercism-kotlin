class Anagram(private val word: String) {
    fun String.toLowerCaseSortedArray() = this.toLowerCase().toCharArray().sorted()

    fun match(list: List<String>) = list
            .filter { !it.equals(word, ignoreCase = true) }
            .filter { it.toLowerCaseSortedArray() == word.toLowerCaseSortedArray() }
            .toSet()
}