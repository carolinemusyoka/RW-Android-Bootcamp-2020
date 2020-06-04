## Documentation of Task 1 :rocket:

### Dealing and Evaluating an Initial Hand of Blackjack 

##### Utilization of classes, collections and fuctions

The first line:
```
class Card(val pip: String, val suit: Char){ 

}
```
data class called Card with two members a String for the pip and a char for the suit.

I used unicode characters for the Suit instead of the regular C,S,D,H

Unicode | Meaning| Symbol/Output
------- | ------- | ---------------
'\u2663' | club | :clubs:
'\u2660' | spade |:spades:
'\u2666' | diamond | :diamonds:
'\u2665' | heart| :hearts:

##### Functions
- createDeck Function
- dealHand Function
- evaluateHand Function
- printResults


###### The output

```
Your hand was :
10 :hearts:
Q :clubs:
For a totalof :  20
You lost ;-(
```
