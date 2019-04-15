class IsbnVerifier {

    fun isValid(id: String) = id
            .filter { it in "0123456789xX" }
            .apply { if (length != 10) return false }
            .map { if (it in "0123456789") it - '0' else 10 }
            .apply { if (10 in dropLast(1)) return false }
            .foldIndexed(0) { index, acc, x -> acc + x * (10 - index) }
            .rem(11) == 0
}
