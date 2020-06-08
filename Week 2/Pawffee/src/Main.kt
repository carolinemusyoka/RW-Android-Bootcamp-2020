import helper.CafeController
import model.caffe.Product
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

fun main() {

    val newline = "\n"
    print(newline)

    val cafeController = CafeController() // print out the data here using CafeController functions
    /* prints out the number of transactions made on the day today
    *
     */
    val today = LocalDate.now().dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH)
    cafeController.printReceiptsFor(today)


    //print the total number of non-employee customers
    cafeController.printTheNumberOfNonEmployeePatronsFor(today)
    print(newline)


    println(cafeController.sellItems(listOf(Product("13", "Bagel", 9.50)), 458))

    print(newline)


    println(cafeController.sellItems(listOf(Product("4", "Cat Sponsorship", 100.00)), 458))

    print(newline)

    cafeController.adoptCat("1", 458)
    println(cafeController.getNumberOfAdoptionsPerShelter())


    println(cafeController.getUnadoptedCats())
    print(newline)



}