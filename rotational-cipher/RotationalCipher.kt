class RotationalCipher(key: Int) {

    private val rotation: Map<Char, Char>

    init {
        val lowerCaseRotation = ('a'..'z').let { it.zip(it.drop(key) + it.take(key)) }
        val upperCaseRotation = ('A'..'Z').let { it.zip(it.drop(key) + it.take(key)) }
        rotation = (lowerCaseRotation + upperCaseRotation).toMap()
    }

    fun encode(string: String): String {
        return string.fold("") { acc, c ->
            acc + if (c.isLetter()) rotation[c] else c
        }
    }
}