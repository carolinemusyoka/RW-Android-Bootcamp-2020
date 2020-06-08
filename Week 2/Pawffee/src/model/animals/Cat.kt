package model.animals

import model.caffe.Sponsorship
import java.util.*

data class Cat(
        val id: String =UUID.randomUUID().toString(),
        val breed: String,
        val name: String,
        val gender: String,
        val shelterId: String,
        val notes: String,
        val sponsorships: MutableSet<Sponsorship> = mutableSetOf()
)
