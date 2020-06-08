package model.caffe

import model.animals.Cat
import model.people.Employee
import model.people.Person
import java.time.LocalDate
import java.time.format.TextStyle

class Cafe {


    // cafe related stuff

  private val employees = mutableSetOf<Employee>(
          Employee("Lynne","Mutheu","456","lynnemutheu@gmail.com","908-990-452",hireDate = "16/05/2020",socialSecurityNumber = "34567893",salary = 34578.00),
          Employee("Leshan","Biko","457","leshanbiko@gmail.com","255-875-889",hireDate = "16/05/2020",socialSecurityNumber = "34567568",salary = 35578.00)

  )
  private val customers = mutableSetOf<Person>(
          Person(id = "458", firstName = "Maktubu",lastName = "Sheikh",email = "maktsheikh@gmail.com", phoneNumber = "074110288"),
          Person(id = "459", firstName = "Valarie",lastName = "Kamwana",email = "valleries@gmail.com", phoneNumber = "0786690710"),
          Person(id = "460", firstName = "Shaka",lastName = "Zulu",email = "shakazulu@gmail.com", phoneNumber = "0774687890")

  )



    /**
     * To simplify it, let's imitate a week-long cafe turnaround.
     *
     * Make sure to add your receipts to each set, with your data.
     * */
     val receiptsByDay: MutableMap<String, MutableSet<Receipt>> = mutableMapOf(
        "Monday" to mutableSetOf<Receipt>(
                Receipt(
                        "1",458,
                        mutableListOf(Product(desc = "Cappuchinno",price = 2.20))


                ),
                Receipt(
                        "2",459,
                        mutableListOf(Product(desc = "Cappuchinno",price = 2.20))

                ),
                Receipt(
                        "3",460,
                        mutableListOf(Product(desc = "Cappuchinno",price = 2.20))

                )


        ),
        "Tuesday" to mutableSetOf<Receipt>(
                Receipt(
                        "4",458,
                        mutableListOf(Product(desc = "Cappuchinno",price = 2.20))

                ),
                Receipt(
                        "5",459,
                mutableListOf(Product(desc = "Cappuchinno",price = 2.20))

        ),
                Receipt(
                        "6",460,
                        mutableListOf(Product(desc = "Cappuchinno",price = 2.20))

                )
        ),

        "Wednesday" to mutableSetOf<Receipt>(
                Receipt(
                        "7",458,
                        mutableListOf(Product(desc = "Cappuchinno",price = 2.20))

                ),
                Receipt(
                        "8",459,
                        mutableListOf(Product(desc = "Cappuchinno",price = 2.20))

                ),
                Receipt(
                        "9",460,
                        mutableListOf(Product(desc = "Cappuchinno",price = 2.20))

                )
        ),
        "Thursday" to mutableSetOf<Receipt>(
                Receipt(
                        "10",458,
                        mutableListOf(Product(desc = "Cappuchinno",price = 2.20))

                ),
                Receipt(
                        "11",459,
                        mutableListOf(Product(desc = "Cappuchinno",price = 2.20))

                ),
                Receipt(
                        "12",460,
                        mutableListOf(Product(desc = "Cappuchinno",price = 2.20))

                )
        ),
        "Friday" to mutableSetOf<Receipt>(
                Receipt(
                        "13",458,
                        mutableListOf(Product(desc = "Bagel",price = 9.50))

                ),
                Receipt(
                        "14",459,
                        mutableListOf(Product(desc = "Cappuchinno",price = 2.20))

                ),
                Receipt(
                        "15",460,
                        mutableListOf(Product(desc = "Espresso",price = 4.40))

                )
        ),
        "Saturday" to mutableSetOf<Receipt>(
                Receipt(
                        "16",458,
                        mutableListOf(Product(desc = "Cappuchinno",price = 2.20))

                ),
                Receipt(
                        "17",459,
                        mutableListOf(Product(desc = "Espresso",price = 4.40))

                ),
                Receipt(
                        "18",460,
                        mutableListOf(Product(desc = "Bagel",price = 9.50))

                )
        ),
        "Sunday" to mutableSetOf<Receipt>(
                Receipt(
                        "19",458,
                        mutableListOf(Product(desc = "Bagel",price = 9.50))

                ),
                Receipt(
                        "20",469,
                        mutableListOf(Product(desc = "Cappuchinno",price = 2.20))

                ),
                Receipt(
                        "21",460,
                        mutableListOf(Product(desc = "Espresso",price = 4.40))

                )

        )
    )

    // maybe as employees check in, you can add them to the list of working employees!


    // make sure to add sponsorships and tie them to people!


    private val sponsorships = mutableSetOf<Sponsorship>(
            Sponsorship("4", "1"),
            Sponsorship("5", "1"),
            Sponsorship("6", "2"),
            Sponsorship("7", "2"),
            Sponsorship("8", "2"),
            Sponsorship("1", "3"),
            Sponsorship("2", "3"),
            Sponsorship("3", "3")


    )

    // TODO Add logic for checking in and checking out!
    fun checkInEmployee(employee: Employee) {
      employee.clockIn()

    }

    fun checkOutEmployee(employee: Employee) {
      employee.clockOut()

    }

    fun showNumberOfReceiptsForDay(day: String) {
        val receiptForDay = receiptsByDay[day] ?: return // wrong day inserted!

        println("On $day you made ${receiptsByDay.size} transactions!")
    }

    fun getReceipt(items: List<Product>, patronId: Int): Receipt {
        // TODO return a receipt! Also make sure to check if customer is also an employee
      for (item in items) {
        if (isEmployee(patronId) && !item.desc.contains("Cat")) {
          item.price = item.price * .85
        }
      }
      val today: String = LocalDate.now().dayOfWeek.getDisplayName(TextStyle.FULL, java.util.Locale.ENGLISH)
      val receipt = Receipt(customerId = patronId , productList = items.toMutableList())

      receiptsByDay[today]?.add(receipt)
        return receipt
    }

    fun addSponsorship(catId: String, personId: String) {

      sponsorships.add(Sponsorship(catId, personId))
    }

    fun getWorkingEmployees(): Set<Employee> = employees

    fun getAdoptedCats(): Set<Cat> {
      return setOf()
    }

    fun getSponsoredCats(): MutableSet<String> {
      val sponsoredCatIds = mutableSetOf<String>()
      sponsorships.forEach { sponsoredCatIds += listOf(it.catId) }
      return sponsoredCatIds
    }

    fun getMostPopularCats(): Set<Cat> {
      return setOf()
    }

    fun getTopSellingItems(): Set<Product> {
      return setOf()
    }

    fun getAdopters(): List<Person> {
        return (this.employees + customers).filter { it.cats.isNotEmpty() }
    }

  fun printNumberOfCustomersFor(day: String) {
    var employeeCount = 0
    var patronCount = 0
    val receiptsByDay:MutableMap<String, MutableSet<Receipt>> = mutableMapOf()
    val receiptForDay: MutableSet<Receipt> = receiptsByDay[day] ?: return // wrong day inserted!


    for (receipt in receiptForDay) {
      val id = receipt.customerId
      patronCount++
      if (isEmployee(id)) {
        employeeCount++
      }
    }
    println(
            "On $day you had ${patronCount} customers. \n" +
                    "\t${employeeCount} of which were employees"
    )
  }

  fun printNumberOfNonEmployeePatronsFor(day: String) {
    var patronCount = 0
    val receiptForDay = receiptsByDay[day] ?: return // wrong day inserted!


    for (receipt in receiptForDay) {
      val id = receipt.customerId
      if (!isEmployee(id)) {
        patronCount++
      }
    }
    println("On $day you had ${patronCount} non-employee customers.")
  }

}

fun printNumberOfCustomersFor(day: String) {
  var employeeCount = 0
  var patronCount = 0
  val receiptsByDay:MutableMap<String, MutableSet<Receipt>> = mutableMapOf()
  val receiptForDay: MutableSet<Receipt> = receiptsByDay[day] ?: return // wrong day inserted!


  for (receipt in receiptForDay) {
    val id = receipt.customerId
    patronCount++
    if (isEmployee(id)) {
      employeeCount++
    }
  }
  println(
          "On $day you had ${patronCount} customers. \n" +
                  "\t${employeeCount} of which were employees"
  )
}



fun isEmployee(id: Int): Boolean {

  return false
}
