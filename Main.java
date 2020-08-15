import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner  sc    = new Scanner (System.in);
        Player player1 = new Player ("Arsham", 0 , 0);
        Dealer dealer  = new Dealer (0,0);
        Deck deck      = new Deck();

        //Dealer gets a card but doesn't show it!
        dealer.takeCard();
        System.out.println("Dealer took a card!\n");

        //player gets a card!
        player1.takeCard();
        System.out.print ("your first car is ");
        player1.hand();

        //Dealer to take another card but show this time
        int d_showCard = dealer.takeCard();
        System.out.println("\nDealer's has a " + d_showCard);
        System.out.println();
        if (dealer.getCount() == 21) {
            System.out.println("Dealer has a black Jack!");
            System.exit(0);
        }



        //now we get into loop! player gets his second card and we now ask if he wants to continue?

        while (bust(player1.getCount()) == false) {
            player1.takeCard();
            System.out.print("your hand : ");
            player1.hand();
            System.out.printf("your count is %d\nyou have %d cards.\n",
                              player1.getCount(),player1.getHowManyCards());

            if (bust(player1.getCount()) == true) {
                System.out.println("you busted!");
                System.exit(0);
            }
            else if (player1.getCount() == 21){
                System.out.println("you have blackjack");
                break;
            }

            //player1.getCount() == 21

            System.out.print("Do you want to hit or stay? (h/s) ");
            char responce = sc.nextLine().toLowerCase().charAt(0);
            if (responce == 'h')
                continue;
            else if (responce == 's')
                break;
        }

        //dealer shows his hand
        System.out.print("\ndealers hand: ");
        dealer.hand();
        System.out.println("dealers total: " + dealer.getCount());

        //now we have to see what dealer will do?
        while (bust(dealer.getCount()) == false && dealer.getCount() < 17) {
            if (dealer.getCount() == 21) {
                System.out.println("Dealer has a black Jack!");
                System.exit(0);
            }
            else if (dealer.getCount() > 17 && !bust (dealer.getCount()))
                System.out.println("dealer stays");
            else {
                System.out.print("Dealer takes a card: " + dealer.takeCard() + " ");
                dealer.hand();
                if (bust(dealer.getCount())){
                    System.out.println("dealer busted\nYou Win!");
                    System.exit(0);
                }
            }
        }
        System.out.println();
        whoWon(player1.getCount(),dealer.getCount());
    }
    

    public static boolean bust (int count) {
        if (count > 21)
            return true;
        else
            return false;
    }

    public static void whoWon (int playersCount, int dealersCount){
        if (playersCount > dealersCount)
            System.out.println("you won!");
        else if (playersCount == dealersCount)
            System.out.println("you pushed!");
        else
            System.out.println("you lost!");
    }
}
