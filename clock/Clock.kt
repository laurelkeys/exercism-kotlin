import kotlin.math.abs

class Clock(var hours: Int, var minutes: Int) {

    init {
        normalize()
    }

    fun add(minutes: Int) {
        this.minutes += minutes
        normalize()
    }

    fun subtract(minutes: Int) {
        this.minutes -= minutes
        normalize()
    }

    override fun toString() = "%02d:%02d".format(hours, minutes)

    override fun equals(other: Any?) = when (other) {
        is Clock -> other.hours == hours && other.minutes == minutes
        else -> false
    }

    private fun normalize() {
        if (abs(minutes) >= 60) {
            hours += minutes.div(60)
            minutes = minutes.rem(60)
        }

        if (minutes < 0) {
            hours -= 1
            minutes += 60
        }

        if (abs(hours) >= 24) {
            hours = hours.rem(24)
        }

        if (hours < 0) {
            hours += 24
        }
    }
}