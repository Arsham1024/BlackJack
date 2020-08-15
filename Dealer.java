public class Dealer {
   Deck deck = new Deck();

   private int count;
   private int howManyCards;
   int [] dealerCards = new int [10];

   public Dealer (int count, int howManyCards){
      this.count = count;
      this.howManyCards = howManyCards;
   }

   public void setCount (int card){
      this.count += card;
   }
   public int getCount () {
      return count;
   }
   public int takeCard () {
      int card = deck.getCards();
      ++howManyCards;
      count += card;
      dealerCards [howManyCards-1] = card;
      return card;
   }
   public void hand (){
      for (int i = 0 ; i<howManyCards; ++i)
         System.out.print (dealerCards[i]+ " ");
      System.out.println();
   }
}
