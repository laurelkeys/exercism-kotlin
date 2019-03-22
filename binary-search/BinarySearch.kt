object BinarySearch {

    private const val INDEX_NOT_FOUND = -1

    fun search(sortedList: List<Int>, element: Int): Int {
        var (i, j) = 0 to sortedList.size - 1
        while (i <= j) {
            ((i + j) / 2).let { middleIndex ->
                sortedList[middleIndex].let { middleElement ->
                    when {
                        element < middleElement -> j = middleIndex - 1
                        element > middleElement -> i = middleIndex + 1
                        else -> return middleIndex
                    }
                }
            }
        }
        return INDEX_NOT_FOUND
    }
}
