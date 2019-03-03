object Acronym {
    fun generate(phrase: String) = phrase
            .split(" ", "-")
            .filter { it.isNotBlank() }
            .map { it.first().toUpperCase() }
            .joinToString("")
}