import MeetupSchedule.*
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth

class Meetup(private val month: Int, private val year: Int) {

    fun day(dayOfWeek: DayOfWeek, meetupSchedule: MeetupSchedule): LocalDate =
            LocalDate.of(year, month, 1)
                    .let { firstDayOfMonth ->
                        (0L until YearMonth.of(year, month).lengthOfMonth())
                                .map { firstDayOfMonth.plusDays(it) }
                    }.filter {
                        it.dayOfWeek == dayOfWeek
                    }.let {
                        when (meetupSchedule) {
                            FIRST  -> it[0]
                            SECOND -> it[1]
                            THIRD  -> it[2]
                            FOURTH -> it[3]
                            LAST   -> it.last()
                            TEENTH -> it.first { day -> day.dayOfMonth in (13..19) }
                        }
                    }
}
