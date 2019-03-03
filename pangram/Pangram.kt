object Pangram {
    fun isPangram(sentence: String) = ('a'..'z').all { it in sentence.toLowerCase() }
}