
public class Lab1{

public static int[] count = new int[21];
public static int[] safe = new int[21];
public static void main(String args[]){

  //local to main
  double[] odds;
  int[] deck = buildDeck();
  shuffle(deck);
  simulate(deck, 100000);
  odds = calculateOdds();
  printDoubleArray(odds);
  System.out.println(shouldIHit(19, odds));
  System.out.println(shouldIHit(19, odds));
  System.out.println(shouldIHit(19, odds));
  System.out.println(shouldIHit(19, odds));
  System.out.println(shouldIHit(19, odds));
  System.out.println(shouldIHit(19, odds));
  System.out.println(shouldIHit(19, odds));
  System.out.println(shouldIHit(19, odds));
  System.out.println(shouldIHit(19, odds));
  System.out.println(shouldIHit(19, odds));
  System.out.println(shouldIHit(19, odds));
  System.out.println(shouldIHit(19, odds));
  System.out.println(shouldIHit(19, odds));

  playDealer();


}

  /** Returns a new deck, in order. The suit does not matter, so the
    array will contain 1 (A), 2, 3, 4, ..., 10, 10 (J), 10 (Q), 10 (K). The array s
    hould have 53 spots, so the last spot will hold the index of the top card (which
    should be zero to start).
    * @return integer array that represents the deck.
  */
  public static int[] buildDeck(){
    int[] deckArr = new int[53];
    //temp will be used to store what card value the card should have.
    int temp = 1;

    //i represents the index of the deck array.
    //n represents the number of cards of a particular value. ie if temp is 4 n = 3 means there are 3 4 cards.
    for(int i = 0, n = 1; i < 52; i++, n++){
      //check to make sure the card isn't ten, if it is, do not increment temp.
      if(temp == 10)
        deckArr[i] = temp;

      //only increment card value (temp) if there are 4 cards already having that value (except 10)
      else if(n == 5){
        temp += 1;
        deckArr[i] = temp;
        //reset the card number
        n = 1;
      }
      //if there are less than 4 cards of that type, add more of those cards to that deck.
      else{
        deckArr[i] = temp;
      }
    }
    return deckArr;
  }


  /**
  * @param deck to be shuffled
  Randomize the array by going through it and swapping every
item with another value from a random index from 0 to 51.  */
  public static void shuffle(int[] deck){
    //iterate through the deck
    for(int i = 0; i < 52; i++){
      //assign a new index for each card (random number between 0 and 51)
      int newIndex = (int)(Math.random() * 51);
      //temp stores the card that is currently at newIndex.
      int temp = deck[newIndex];
      //assign the card to the new index.
      deck[newIndex] = deck[i];
      //assign the card that used to be at newIndex to where the other card was.
      deck[i] = temp;
    }
  }


  /** Return the top card and increment the top card variable, unless
you have hit the end of the array. In that case, shuffle the deck
and set the top card variable to 0.
  * @param deck deck to draw the top card from.
  * @return an integer that represents the top card.
*/
public static int getCard(int[] deck){
  //the index of the top card is whatever is in the last index of the deck.
  int topCard = deck[52];

  //if at end of deck, shuffle deck and reset the top card index to 0.
  if(topCard == 52){
    //reset the top card index.
    deck[52] = 0;
    shuffle(deck);
    //topCard needs to be assigned to 0 as well, since we still need to draw the card from the top of the new deck.
    topCard = 0;
  }
  //otherwise, the next top card is one card after, so increment the top card index.
    deck[52] += 1;

    return deck[topCard];
}



/** Given a deck, will play one hand of BlackJack
and record the number of times you get the value and the number of times you are safe when you hit at that value
  * @param deck is the deck to play blackJack with.
*/
public static void playHand(int[] deck){
  //hand will be the total sum of the cards.
  int hand = 0;
  //draw from the deck
  int card = getCard(deck);

  hand += card;
  //get a second card.
  card = getCard(deck);
  hand+= card;

  //keep hitting until the sum exceeds 21.
  while(hand<21){
    card = getCard(deck);
    hand+= card;

    //check the hand again, this if statement is if the new hand hasn't busted yet.
    if(hand <= 21){
      //I subtract card because the program needs to mark that the hand hit the previous value, and was safe at that value even after adding a new card.
      //increment the count array to mark that the hand has hit this value.
      count[hand-card]++;
      //increment the safe array to mark that the hand still has not bust at this value.
      safe[hand-card]++;
    }

    //if the hand bust, do not increment safe, just increment count.
    else
      count[hand -card]++;
  }
}


/** Takes in a deck and uses it to simulate numTimes different hands by calling playHand
  * @param deck is the deck to play blackjack with
  * @param numTimes is the number of times the program should simulate.
  */
public static void simulate(int[] deck, int numTimes){
  //i is an incrementing variable.
  int i = 1;
  while(i<=numTimes){
    //call playHand to simulate 1 hand of blackjack.
    playHand(deck);
    i++;
  }
}


/** Takes in a deck and uses it to simulate numTimes different hands by calling playHand
  * @return an array with the percent safe rate of every value from 0 to 20.
 */
public static double[] calculateOdds(){
  double[] odds = new double[21];
  for(int a = 0; a< 21; a++){
    //I add the 0.0 so it won't perform integer division and round the double.
    odds[a] = Math.round(((safe[a]+0.0)/count[a]) * 100.0) / 100.0;
  }
  return odds;

}

/** Returns whether or not you should hit, based on your current odds. Note-
your program should handle this differently than a human player would! For
example, a human player, if the odds are 60% that they should hit, would actually
hit every time. Your program should take this more literally. If there is a 60% chance
that your program would hit, then it should return true 60% of the time!
  * @param currVal is the value at which the hand is at.
  * @param odds is the list of percentage safe values.
  * @return true if the player should hit, false if they player should stay.
*/
public static boolean shouldIHit(int currVal, double[] odds){
  //general strategy: generate a random number between 1 and 100, if the percent is greater than that, don't hit it, if it's less, hit.
  double num = (Math.random() * 100) + 1;
  if(odds[currVal] * 100 >= num){
    return true;
  }
  else{
    return false;
  }
}

/* This function simulates a game of blackjack between a dealer and a player, below are the rules!
The dealer gets one card which the player can see.
The player gets two cards.
The player has the option to hit. The player can hit has many times as desired, until 21 is exceeded or the player stays. You should use the shouldIHit method rather than asking the user.
If the player busts (exceeds 21), the dealer wins and that’s the end of the game.
If the player did not bust, the dealer gets cards until she reaches 17 or higher (the dealer always hits at 16 or fewer points and stays at 17 or more points).
If the dealer busts, the player wins.
If the player and the dealer have the same total, it’s a push. Otherwise, the winner is the one with the largest total.

*/

public static void playDealer(){
  //create  a new deck.
  int[] deck = buildDeck();
  shuffle(deck);
  //to get the odds list, we need to first use the simulate function.
  simulate(deck, 10000);
  double[] odds = calculateOdds();
  int dealerHand = 0;
  int playerHand = 0;
  //this boolean will be used in conditions for loops later on.
  boolean stopPlay = false;

  System.out.println("Playing against the dealer");
  //dealer gets a card.
  int dealerCard = getCard(deck);
  //add that to the dealer's hand.
  dealerHand += dealerCard;
  System.out.println("Dealer got: " + dealerCard);
  System.out.println("Current dealer hand: " + dealerHand);

  //the player gets two cards.
  int playerCard = getCard(deck);
  playerHand += playerCard;
  System.out.println("Player got: " + playerCard);
  playerCard = getCard(deck);
  playerHand += playerCard;
  System.out.println("Player got: " + playerCard);
  System.out.println("Current player hand: " + playerHand);

  //use the shouldIHit to determine whether the player should hit.
  boolean hit= shouldIHit(playerHand, odds);

  if(hit== false)
    System.out.println("Player chooses to stay");

  else{
    //player will keep getting cards until they exceed 21, reach 21, or shouldIHit turns false.
    while(hit== true){
      System.out.println("Player chooses to hit");
      playerCard = getCard(deck);
      playerHand += playerCard;
      System.out.println("Player card: " + playerCard);
      System.out.println("Current player hand: " + playerHand);

      if(playerHand == 21){
        System.out.println("Player wins!");
        stopPlay = true;
        break;
      }
      //if the player busts, the dealer wins and
      if(playerHand > 21){
        System.out.println("Player bust!");
        System.out.println("Dealer wins");
        //the if statement if(stopPlay == false) won't run.
        stopPlay = true;
        break;
      }
      hit= shouldIHit(playerHand, odds);
      if(hit == false){
        System.out.println("Player chooses to stay.");
      }
    }
  }

  //if the dealer hasn't won after that loop (ie player chooses to stay at some point)
  if(stopPlay == false){
    //dealer will keep hitting until its hand hits seventeen.
    while(dealerHand < 17){
      dealerCard = getCard(deck);
      dealerHand += dealerCard;
      System.out.println("Dealer got: " + dealerCard);
      System.out.println("Current dealer hand: " + dealerHand);
    }

    //if the dealer busts, the player wins.
    if(dealerHand > 21){
      System.out.println("Dealer bust!");
      System.out.println("Player Wins!");
    }
    //if neither bust, whichever one has the higher hand wins.
    else if(dealerHand > playerHand)
      System.out.println("Dealer wins!");
    else if(playerHand > dealerHand)
      System.out.println("Player wins!");

    //if they tie, it's called a push.
    else
      System.out.println("It's a push!!");

  }
 }
 public static void printIntArray(int[] ar)
 {
   System.out.print(" { ");
   for(int i = 0;i < ar.length; i++)
   {
     if (i != ar.length - 1)
       System.out.print(ar[i] + ", ");
     else
       System.out.print(ar[i]);
   }
   System.out.println(" } ");
 }
 public static void printDoubleArray(double[] ar)
  {
    System.out.print(" { ");
    for(int i = 0;i < ar.length; i++)
    {
      if (i != ar.length - 1)
        System.out.print(ar[i] + ", ");
      else
        System.out.print(ar[i]);
    }
    System.out.println(" } ");
  }


}
