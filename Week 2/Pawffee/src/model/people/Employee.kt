package model.people

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.time.temporal.ChronoUnit.HOURS

class Employee(
    firstName: String,
    lastName: String,
    id : String,
    email: String,
    phoneNumber: String,
    val salary: Double,
    val socialSecurityNumber: String,
    val hireDate: String
) : Person( firstName = firstName, lastName = lastName,id =id, email = email, phoneNumber = phoneNumber) {

    override fun toString(): String {
        return "${firstName}, ${lastName}  ${hireDate} ,${salary}" // TODO format the data in any way you want! :]
    }
      var hoursWorkedThisWeek : Double =0.0
      var timeClockedIn: LocalTime? = null

    /**
     * Prints a time of clocking in, in a nice format.
     *
     * Hint: to get time, you can create a `Date` object. Use SimpleDateFormatter to format the time!
     * */
    fun clockIn() {
     val clocksIn = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        val formatted = clocksIn.format(formatter)
        println("The time of clocking in is : $formatted")

    }

    // TODO same as above, but times for clocking out!
    fun clockOut() {
        if (timeClockedIn != null) {
            var timeWorked = ChronoUnit.MINUTES.between(LocalTime.now(), timeClockedIn)
            var hoursWorked = timeWorked / 60
            val minutesWorked = timeWorked - (hoursWorked * 60)
            val hourPortion = minutesWorked / 60
            hoursWorkedThisWeek += hoursWorked + hourPortion
        }
    }
}