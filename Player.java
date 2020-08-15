public class Player {
   private int count;
   private String name;
   private int howManyCards;

   Deck deck = new Deck();
   int [] playerCards = new int [10];

   public Player (String name, int count, int howManyCards){
      this.name = name;
      this.count = count;
      this.howManyCards = howManyCards;
   }

   public String getName (){
      return name;
   }
   public int getCount () {
      return count;
   }
   public int takeCard () {
      int card = deck.getCards();
      ++howManyCards;
      count += card;
      playerCards [howManyCards-1] = card;
      return card;
   }
   public int getHowManyCards(){
      return howManyCards;
   }
   public void hand (){
      for (int i = 0 ; i<howManyCards; ++i)
         System.out.print (playerCards[i]+ " ");
      System.out.println();
   }

}
