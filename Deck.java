import java.util.Random;

public class Deck {
   int [] deck = {11, 10, 10, 10, 9 , 8, 7 , 6, 5 , 4 , 3 , 2 , 1};
   String [] deckFaces = {"A" , "K", "Q", "J", "10", "9" , "8" , "7" , "6" , "5" ,"4", "3", "2" , "1"};
   Random rand    = new Random ();


   public int getCards (){
      return deck[rand.nextInt(deck.length)];
   }
}
