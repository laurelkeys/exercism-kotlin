class School {

    private val db = mutableMapOf<Int, List<String>>()

    fun db() = db

    fun sort() = db.mapValues { it.value.sorted() }.toSortedMap()

    fun grade(grade: Int) = db[grade] ?: emptyList()

    fun add(name: String, grade: Int) {
        db[grade] = (db[grade] ?: emptyList()) + name
    }
}