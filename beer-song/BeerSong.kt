object BeerSong {
    private fun bottles(n: Int) = when (n) {
        1 -> "1 bottle"
        else -> "$n bottles"
    }

    private fun verse(n: Int) = when (n) {
        0 -> "No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
        1 -> "1 bottle of beer on the wall, 1 bottle of beer.\n" +
                "Take it down and pass it around, no more bottles of beer on the wall.\n"
        else -> "${bottles(n)} of beer on the wall, ${bottles(n)} of beer.\n" +
                "Take one down and pass it around, ${bottles(n - 1)} of beer on the wall.\n"
    }

    fun verses(start: Int, end: Int) = (start downTo end).joinToString(separator = "\n") { verse(it) }
}