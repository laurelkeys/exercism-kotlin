object Isogram {
    fun isIsogram(input: String): Boolean {
        var strippedInput = input
        ('a'..'z').forEach { strippedInput = strippedInput.replaceFirst(it.toString(), "", ignoreCase = true) }
        return !('a'..'z').any { it in strippedInput }
    }
}