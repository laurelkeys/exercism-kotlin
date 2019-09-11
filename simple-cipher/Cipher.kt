import java.util.*

class Cipher(val key: String = generateRandomKey()) {

    init {
        require(key.isNotEmpty() && key.none { it.isUpperCase() || it.isDigit() })
    }

    companion object {
        const val alphabet = "abcdefghijklmnopqrstuvwxyz"
        private val rand by lazy { Random() }

        private fun generateRandomKey() = (1..100).fold("") { acc, _ ->
            acc + alphabet[rand.nextInt(alphabet.length)]
        }
    }

    fun encode(s: String) = codec(s, op = Int::plus)

    fun decode(s: String) = codec(s, op = Int::minus)

    private fun codec(s: String, op: (Int, Int) -> Int): String {
        return s.foldIndexed("") { i, acc, c ->
            acc + with(alphabet) {
                (op(indexOf(c), indexOf(key[i.rem(key.length)]))).let {
                    if (it >= 0) get(it.rem(length))
                    else get((it + length).rem(length))
                }
            }
        }
    }
}