import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(birthDateTime: LocalDateTime) {
    constructor(birthDate: LocalDate) : this(birthDate.atStartOfDay())

    // birth date plus a gigasecond (i.e. the moment when someone has lived for 10^9 seconds)
    val date: LocalDateTime = birthDateTime.plusSeconds(1_000_000_000)
}