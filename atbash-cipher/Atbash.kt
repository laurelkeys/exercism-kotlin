class Atbash {

    companion object {

        private val cipher = ('a'..'z').let { it.zip(it.reversed()) }.toMap()
        private val decipher = cipher.map { it.value to it.key }.toMap()

        fun encode(string: String) = string.toLowerCase()
                .fold("") { acc, c ->
                    acc + if (!c.isLetterOrDigit()) "" else if (c.isLetter()) cipher[c] else c
                }.chunked(5).joinToString(" ")

        fun decode(string: String) = string.replace(" ", "")
                .fold("") { acc, c ->
                    acc + if (c.isLetter()) decipher[c] else c
                }
    }
}