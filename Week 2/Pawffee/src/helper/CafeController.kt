package helper

import model.animals.Cat
import model.caffe.Cafe
import model.caffe.Product
import model.shelter.Shelter

class CafeController {

    // cafe related things
    private val cafe = Cafe()

    // shelter related things // TODO make sure to fill in the data!
    private val shelters = mutableSetOf<Shelter>(
            Shelter(id = "242", name = "First Shelter", shelterAddress = "187 Biscayne Dr, Albany NY 12202",shelterPhone = 555-345-1212),
            Shelter(id = "249",name = "Second Shelter",shelterAddress = "1 Jump St, Albany NY 12203",shelterPhone = 969-123-5555 )
    )
    private val shelterToCat = mutableMapOf<Shelter, MutableSet<Cat>>(
            shelters.elementAt(0) to mutableSetOf(
                    Cat("1", "tabby tomcat", "Morris", "m", "242", "the world's most finicky cat"),
                    Cat("2", "Toyger", "Orangey", "m", "242", "They’re gr-r-reat!"),
                    Cat("6", "CHESHIRE", "Lewis Carol", "m", "242", "Enjoys smiling")

            ),
            shelters.elementAt(1) to mutableSetOf(
                    Cat("3", "marmalade tabby", "Orangey", "m", "242", "Enjoys smiling"),
                    Cat("4", "Birman", "Tabby", "f", "249", "only eats Strottarga Bianco Caviar" ),
                    Cat("5", "CHESHIRE", "CHOUPETTE", "m", "249", "Enjoys breakfast at Tiffany's")
            )
    )

    fun adoptCat(catId: String, person: Int) {

        // check if cats exist, and retrieve its entry!
        val catInShelter = shelterToCat.entries.firstOrNull { (_, catsInShelter) ->
            catsInShelter.any {it.id == catId }
        }

        // you can adopt that cat!
        if (catInShelter != null) {
            val cat = catInShelter.value.first { cat -> cat.id == catId } // find the cat for that ID again

            // remove the cat from the shelter
            catInShelter.value.remove(cat)

            // add the cat to the person

        }
    }

    fun printReceiptsFor(day: String) {
        return cafe.showNumberOfReceiptsForDay(day)
    }

    fun printTheNumberOfCustomersFor(day: String) {
        return cafe.printNumberOfCustomersFor(day)
    }

    fun printTheNumberOfNonEmployeePatronsFor(day: String) {
        return cafe.printNumberOfNonEmployeePatronsFor(day)
    }

    fun sellItems(items: List<Product>, customerId: Int) {

        /**
         * Also make sure to print receipt information out & add the receipt to the list of receipts for the current day.
         * You can random the day from a List, or check from the Date object!
         * */
        val receipt = cafe.getReceipt(items, customerId)
        println(
                "You purchased: ${receipt.productList.size} items:\n" +
                        "\t${receipt.productList}\n" +
                        "\tYour total is: ${receipt.totalOfProducts}"
        )
    }

    /**
     * First gets a list of all adopters, then queries shelters.
     *
     * */

    fun getNumberOfAdoptionsPerShelter(): Map<String, Int> {
        val shelterMap: MutableMap<String, Int> = mutableMapOf()
        val allAdopters = cafe.getAdopters()
        if (allAdopters.isEmpty()) return mapOf()
        for (adopter in allAdopters) {
            val catsCount = adopter.cats.size
            for (cat in adopter.cats) {
                val shelterList = shelters.filter { it.id == cat.shelterId }
                shelterList.forEach { shelterMap.put(it.name, catsCount) }
            }
        }

        return shelterMap // TODO find which cats belong to which shelter, and create a map of Shelter name to number of adoptions
    }

    fun getUnadoptedCats(): Set<Cat> {
        val unadoptedCats = mutableSetOf<Cat>()
        shelterToCat.forEach { unadoptedCats.addAll(it.value)}
        return unadoptedCats
    }

    fun getSponsoredUnadoptedCats(): MutableSet<Cat> {
        val sponsoredCatids = cafe.getSponsoredCats()
        val sponsoredCats = mutableSetOf<Cat>()
        shelterToCat.forEach {
            it.value.forEach() {
                if (it.id in sponsoredCatids) sponsoredCats.add(it)}
        }
        return sponsoredCats
    }

    fun getPopularItems(): Set<Product> {
        return cafe.getTopSellingItems()

    }

    fun getPopularCats(): Set<Cat> {
        return cafe.getMostPopularCats()
    }
}
