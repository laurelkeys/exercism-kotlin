import java.util.*

object BracketPush {

    fun isValid(input: String): Boolean {
        val openBrackets = Stack<Char>()
        val openingBracket = mutableMapOf(']' to '[', '}' to '{', ')' to '(')

        input.forEach {
            when (it) {
                in "[{(" -> openBrackets.push(it)
                in "]})" -> when {
                    !openBrackets.peekFirstEquals(openingBracket[it]) -> return false
                    else -> openBrackets.pop()
                }
            }
        }

        return openBrackets.isEmpty()
    }

    private fun <E> Stack<E>.peekFirstEquals(e: E?) = with(this) {
        when {
            isEmpty() -> false
            else -> peek() == e
        }
    }
}
