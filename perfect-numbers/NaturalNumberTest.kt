import Classification.*
import org.junit.Ignore
import org.junit.Test

import org.junit.Assert.assertEquals

class NaturalNumberTest {

    @Test
    fun smallPerfectNumberIsClassifiedCorrectly() {
        assertEquals(PERFECT, classify(6))
    }

    @Test
    fun mediumPerfectNumberIsClassifiedCorrectly() {
        assertEquals(PERFECT, classify(28))
    }

    @Test
    fun largePerfectNumberIsClassifiedCorrectly() {
        assertEquals(PERFECT, classify(33550336))
    }

    @Test
    fun smallAbundantNumberIsClassifiedCorrectly() {
        assertEquals(ABUNDANT, classify(12))
    }

    @Test
    fun mediumAbundantNumberIsClassifiedCorrectly() {
        assertEquals(ABUNDANT, classify(30))
    }

    @Test
    fun largeAbundantNumberIsClassifiedCorrectly() {
        assertEquals(ABUNDANT, classify(33550335))
    }

    @Test
    fun smallestPrimeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(DEFICIENT, classify(2))
    }

    @Test
    fun smallestNonPrimeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(DEFICIENT, classify(4))
    }

    @Test
    fun mediumNumberIsClassifiedCorrectly() {
        assertEquals(DEFICIENT, classify(32))
    }

    @Test
    fun largeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(DEFICIENT, classify(33550337))
    }

    @Test
    fun edgeCaseWithNoFactorsOtherThanItselfIsClassifiedCorrectly() {
        assertEquals(DEFICIENT, classify(1))
    }

    @Test(expected = RuntimeException::class)
    fun zeroIsNotANaturalNumber() {
        classify(0)
    }

    @Test(expected = RuntimeException::class)
    fun negativeNumberIsNotANaturalNumber() {
        classify(-1)
    }

}
