import java.math.RoundingMode

class SpaceAge(private val seconds: Long) {

    fun onEarth() = seconds.toYearsOn(Planet.EARTH)
    fun onMercury() = seconds.toYearsOn(Planet.MERCURY)
    fun onVenus() = seconds.toYearsOn(Planet.VENUS)
    fun onMars() = seconds.toYearsOn(Planet.MARS)
    fun onJupiter() = seconds.toYearsOn(Planet.JUPITER)
    fun onSaturn() = seconds.toYearsOn(Planet.SATURN)
    fun onUranus() = seconds.toYearsOn(Planet.URANUS)
    fun onNeptune() = seconds.toYearsOn(Planet.NEPTUNE)

    private fun Long.toYearsOn(planet: Planet) = (planet.orbitalPeriodFactor * 31_557_600).let {
        (this / it)
                .toBigDecimal()
                .setScale(2, RoundingMode.HALF_UP)
                .toDouble()
    }

    private enum class Planet(val orbitalPeriodFactor: Double) {
        EARTH(1.0), // 365.25 Earth days, or 31557600 seconds
        MERCURY(0.2408467),
        VENUS(0.61519726),
        MARS(1.8808158),
        JUPITER(11.862615),
        SATURN(29.447498),
        URANUS(84.016846),
        NEPTUNE(164.79132),
    }
}