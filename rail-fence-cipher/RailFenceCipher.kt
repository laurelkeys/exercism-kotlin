import kotlin.coroutines.experimental.buildIterator

class RailFenceCipher(private val rails: Int) {

    private val railSequence: Sequence<Int> = ((0 until rails - 1) + (rails - 1 downTo 1)).asSequence()

    fun getEncryptedData(string: String): String {
        val railsArray = Array(rails) { "" }
                .also {
                    val rail = railSequence.repeat()
                    string.forEach { c -> it[rail.next()] += "$c" }
                }

        return railsArray.reduce { encrypted, railString -> encrypted + railString }
    }

    fun getDecryptedData(string: String): String {
        val railsMatrix = Array(rails) { Array(string.length) { ' ' } }
                .also {
                    val encrypted = string.iterator()
                    (0 until rails).forEach { i ->
                        val rail = railSequence.repeat()
                        (0 until string.length).forEach { j ->
                            if (i == rail.next()) it[i][j] = encrypted.nextChar()
                        }
                    }
                }

        return buildString {
            val rail = railSequence.repeat()
            (0 until string.length).forEach {
                append(railsMatrix[rail.next()][it])
            }
        }
    }
}

private fun <T> Sequence<T>.repeat() = buildIterator { while (true) yieldAll(this@repeat) }
