package model.caffe

import java.util.*

data class Product(
        val id: String = UUID.randomUUID().toString(),
        val desc: String,
        var price: Double

)
   // sample data
  // bagel = Product(id = 4,price = 9.50,desc = "Bagel",quantity = 1)
  // cappuccino = Product(id = 2,price = 2.20, desc = "Cappuccino",quantity = 1)