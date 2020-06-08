package model.shelter

import java.util.*

// TODO add remaining data
data class Shelter(
        val id: String =UUID.randomUUID().toString(),
        val shelterAddress: String,
        val name: String,
        val shelterPhone: Int
)


