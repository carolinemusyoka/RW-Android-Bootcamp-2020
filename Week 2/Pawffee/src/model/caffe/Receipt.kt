package model.caffe

import model.animals.Cat
import java.util.*


class Receipt(
        val id: String= UUID.randomUUID().toString(),
        val customerId: Int,
        val productList: MutableList<Product> = mutableListOf(),
        var catsAdopted: MutableSet<Cat> = mutableSetOf() //optional and unnecessary
)
{

    val totalOfProducts: Double
    get() {
        var cost: Double = 0.0
        for (product in productList){
            cost += product.price
        }
        return cost
    }
     fun addAnotherProduct(product: Product){
         productList.add(product)
     }
}

