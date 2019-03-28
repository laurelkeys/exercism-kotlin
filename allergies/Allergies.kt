class Allergies(private val allergyScore: Int) {

    private val allergies =
            Allergen.values().filter { allergyScore.scores(it.score) }

    fun getList() = allergies

    fun isAllergicTo(allergen: Allergen) =
            allergyScore.scores(allergen.score)

    private fun Int.scores(score: Int) = this and score == score
}
