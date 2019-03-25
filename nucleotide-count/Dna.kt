class Dna(sequence: String) {

    val nucleotideCounts: Map<Char, Int>

    init {
        require(sequence.all { it in "ACTG" })
        nucleotideCounts =
                mapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0) +
                sequence.groupingBy { it }.eachCount()
    }
}