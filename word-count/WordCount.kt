object WordCount {

    fun phrase(phrase: String): Map<String, Int> = phrase
            .split(" ", ":", ",", ".", "\n")
            .filterNot { it.isBlank() }
            .map {
                it.removeSurrounding("'").ignorePunctuation().toLowerCase()
            }
            .groupingBy { it }
            .eachCount()

    private fun String.ignorePunctuation() = this.filter { it.isLetterOrDigit() || it == '\'' }
}
