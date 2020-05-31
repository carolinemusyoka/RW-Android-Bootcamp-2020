/** challenge 1 RW Android Bootcamp
 * Beginner level
 * Use of classes, collections and functions
 */

class Card(val pip: String, val suit: Char){ //2 members a string of the pip and char' for the suit

}

fun createDeck(): MutableSet<Card> { //has collections of suits and pips
    val suits = listOf('\u2663', '\u2660', '\u2666', '\u2665') //
    val pips = listOf("k", "Q", "j", "10", "9", "8", "7", "6", "5", "4", "3", "2", "A")

    val deck = mutableSetOf<Card>()

    for (i in pips.indices) {
        for (j in suits.indices) {
            deck.add(Card(pips[i], suits[j]))
        }
    }
    return deck
}

fun dealHand(deck: MutableSet<Card>, numberOfCards: Int): MutableList<Card> {
    val hand = mutableListOf<Card>()
    for (i in 1..numberOfCards) {
        val card = deck.random()
        hand.add(card)
        deck.remove(card)
    }
    return hand
}

fun evaluateHand(hand: MutableList<Card>): Int {
    var total = 0

    for (card in hand) {
        val pipValue = when (val pip = card.pip) {
            "J",
            "Q",
            "K" -> 10
            "A" -> 11
            else -> pip.toInt()
        }
        total += pipValue
    }
    return total
}

fun printResult(hand: MutableList<Card>, total: Int) {
    var someMessage:String = "Your hand was: \n "
    var message = " "
    print(someMessage)
    val cards: ArrayList<String> = arrayListOf()
    for (card in hand)
        cards.add("${card.pip} ${card.suit}")
        message = when (total) {
            21 -> "For a total of: $total \n You are a winner ;-0"
            else -> "For a total of: $total \n You Lose :-( Try Again?"
        }


    cards.forEach {
        println(it)
    }
    println(message)
}

fun main() {
    val deal = dealHand(createDeck(), 2)
    val evaluate = evaluateHand(deal)
    printResult(deal, evaluate)
}



