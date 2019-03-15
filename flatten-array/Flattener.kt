object Flattener {

    fun flatten(list: List<*>): List<*> {
        return list.fold(emptyList<Any?>()) { acc, t ->
            when (t) {
                is List<*> -> acc.plus(flatten(t))
                else -> acc.plus(t)
            }
        }.filterNotNull()
    }
}