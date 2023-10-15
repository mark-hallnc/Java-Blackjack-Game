//Import scanner to be able to get inputs from user.
import java.util.Scanner;

//Class BlackJackTester
public class BlackJackTester{
    //Main method.
    public static void main(String[] args) {

        //Initialize all the variables.
        final int CARDS_IN_DECK = 52;
        final int FIRST_CARD_IN_HAND = 0;
        final int SECOND_CARD_IN_HAND = 1;
        final String CHOICE_HIT = "H";
        final String CHOICE_STAY = "S";
        final int NUMBER_OF_SHUFFLES = 5;
        boolean playerHit;
        boolean validChoice;
        String choice = null;

        //Create a new scanner object to be able to read inputs from the console.
        Scanner input = new Scanner(System.in);
        //Welcome message.
        System.out.println("\nWelcome to Black-Jack\n");
        //Create a new BlackJack object and call it game1. Pass CARDS_IN_DECK to it
        //which represents a whole deck of cards.
        BlackJack game1 = new BlackJack(CARDS_IN_DECK);

        //For this game, create a player and dealer.
        BlackJack.BlackJackPlayer player = game1.getPlayer();
        BlackJack.BlackJackPlayer dealer = game1.getDealer();
        //Shuffle the deck.
          for (int i = 0; i <= NUMBER_OF_SHUFFLES; i++) {
              game1.shuffleDeck();
          }
          //Deal cards to the player and dealer.
          game1.dealCard(player);
          game1.dealCard(dealer);
        //Display the dealer's name and first card.
        System.out.println("\nThe " + dealer.getName() + "'s first card is: ");
        System.out.println(dealer.getCard(FIRST_CARD_IN_HAND));

        //System.out.println(game1.getDealer());

        System.out.println("\nThe " + dealer.getName() + "'s second card is face-down.");

        //Deal cards to the player and dealer.
        game1.dealCard(player);
        game1.dealCard(dealer);

        //display the player's hand and score.
        showCurrentHand(player);
        showCurrentScore(player);

        //test to see if player has bust and if they are, no more hits.
        if (player.isBust()) {
            playerHit = false;
        }
            else {
            playerHit = true;
            }
        //While the player is not bust, prompt to hit or stay.
        while(playerHit){
            do {
                System.out.print("\nWould you like to Hit(H) or Stay(S): ");
                choice = input.nextLine();
                choice = choice.toUpperCase();
                //test input for validity. Must be h or s for hit or stay.
                if (choice.equals(CHOICE_HIT) || choice.equals(CHOICE_STAY)) {
                    validChoice = true;

                }
                else {
                    validChoice = false;

                }
            }
            while(!validChoice);

        //if choice is to hit, deal a card to the player and show their
        //new hand and score.
        if (choice.equals(CHOICE_HIT)){
           game1.dealCardWithHit(player);
           showCurrentHand(player);
           showCurrentScore(player);
            //If the deal causes a bust, player can no longer choose to hit.
            if (player.checkBust()){
                playerHit = false;
            }
            else {
                playerHit = true;
            }
        }
        else {
            playerHit = false;
            }
        }
        //On the condition that the player is not bust, display dealer's second
        //card and show updated score.
        if (!player.isBust()){
            System.out.println("\nThe " + dealer.getName() + "'s second card is: ");
            dealer.getCard(SECOND_CARD_IN_HAND);
            System.out.println(dealer.getCard(SECOND_CARD_IN_HAND));
            showCurrentScore(dealer);
            //Do the above while the dealer is under a score of 16.
            while(dealer.getCurrentScore() <= game1.DEALER_HIT_STAY_THRESHOLD){
                game1.dealCardWithHit(dealer);
            }
        }
        //Call checkBust on dealer to see if they are bust.
        dealer.checkBust();
        //show number of hits and show dealers hand and score.
        System.out.print("\nAfter 'Hitting' " + dealer.getNumberHits() + " time(s),");

        showCurrentHand(dealer);
        showCurrentScore(dealer);
        //Determine the outcome by passing player and dealer to the method.
        game1.determineOutcome(player, dealer);

        //If the dealer won, display name and outcome.
        if (game1.getWinner() == BlackJack.Winner.DEALER)
            System.out.println("\nUnfortunately " + player.getName() + ", the " + dealer.getName() + " won this hand.");
        //If the player won, display name and outcome.
        else if (game1.getWinner() == BlackJack.Winner.PLAYER)
            System.out.println("\n" + player.getName() + ", you have won this hand!");
        //If neither one, display tie message.
        else
            System.out.println("\n" + player.getName() + ", you and the " + dealer.getName() + " have tied on this hand.");
        //Display player's number of hits.
        System.out.println("\n" + player.getName() + ", you 'Hit' " + player.getNumberHits() + " time(s).");
        System.out.println("\nThank you for playing!\n");
    }
    //Method to display the current hand. Pass player p as argument.
    public static void showCurrentHand(BlackJack.BlackJackPlayer p){
        //display player's name and message...
        System.out.println("\n" + p.getName() + "'s current hand is:");
        //Format the player's hand for display.
        p.displayFormattedHand();
    }
    //Method to display current score. Pass player p as argument.
    public static void showCurrentScore(BlackJack.BlackJackPlayer p){
        //Show player's name and message...
        System.out.print("\n" + p.getName() + "'s current score is: ");
        //Call method to get score of player p.
        System.out.println(p.getCurrentScore());
    }
}
