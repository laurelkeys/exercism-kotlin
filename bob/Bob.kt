object Bob {
    private fun String.isNotEmptyAndAll(predicate: (Char) -> Boolean) = this.isNotEmpty() && this.all(predicate)

    fun hey(string: String) = when {
        string.isBlank() -> "Fine. Be that way!"
        string.filter { it.isLetter() }.isNotEmptyAndAll { it.isUpperCase() } -> "Whoa, chill out!"
        string.trim().endsWith("?") -> "Sure."
        else -> "Whatever."
    }
}