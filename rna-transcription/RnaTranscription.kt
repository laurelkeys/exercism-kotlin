fun transcribeToRna(dna: String) = buildString {
    dna.forEach {
        when (it) {
            'G' -> append('C')
            'C' -> append('G')
            'T' -> append('A')
            'A' -> append('U')
        }
    }
}
