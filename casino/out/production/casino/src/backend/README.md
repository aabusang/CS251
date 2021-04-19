##  Slot-Machine
1. I generated 3 random numbers and just use that to similarity in the game rules and then payout if player wins
##  Roulette
#### Abstraction
I made an abstract class for all the roulette bets call Bet.
I overloaded the wasSuccessful abstract method to fit the different bet types

####Common pattern
I write a make...Bet function for all the bets inside the roulette class, 
then go to the individual classes and implement the logic special to them.

in the make..Bet methods I return a new object of that bet type and add it 
to a list of bet as the user enter them, 
then I will run all one by one as the user enter their inputs and bet
#### Straight Bet:
I generated a random number between 1 and 36 inclusive and ask the user for the number they are betting on
then I will compare those two numbers and determine whether the player won or lose.

The rest of the other bets basically follows a similar logic
I didn't know any optimized way to validate my split bet input so I wrote a huge method just for that
hard coding the whole logic.
I will appreciate if you know and can tell me a better way to tackle that

## Black Jack
####Card Class
Card class create a card object using suit and rank enum
####Deck Class
Deck class makes a suit arraylist of all card suits, 
and a rank arraylist of all card ranks
Then create a deck of 52 of the card objects created in Card class
Then shuffles the deck and 
Then deal the cards.
"should remove cards that are dealt but haven't done that yet"
####Hand Class
Hand class creates an object of type hand that represent a hand of cards
I used vector instead of array list just to give myself some exposure to vector class


#NOT FINISH
1. I run out of time and have not been able to implement the changing of 
ace from 1 to 11 and the other way round.







