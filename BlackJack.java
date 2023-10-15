
//Class blackjack is a subclass of CardGame and inherits its methods and properties
public class BlackJack extends CardGame {

    //enum is a group of constants
    enum Winner {DEALER, PLAYER, TIE}

    //declare var winner as type Winner
    private Winner winner;
    //Threshold above which dealer no longer hits
    final int DEALER_HIT_STAY_THRESHOLD = 16;
    //The dealer's name
    final String DEALER_NAME = "Dealer";

    //Create a new dealer and player of the type BlackJackPlayer
    //Dealer's name is passed to the dealer variable.
    private BlackJackPlayer player = new BlackJackPlayer();
    private BlackJackPlayer dealer = new BlackJackPlayer(DEALER_NAME);

    //Getters and setters. Getters return data where setters are what
    //allow you to change the property.
    public Winner getWinner(){
        return winner;
    }
    public BlackJackPlayer getPlayer(){
        return player;
    }
    public BlackJackPlayer getDealer() { return dealer; }
    private void setWinner(BlackJack.Winner winner){
        this.winner = winner;
    }

    //Method to deal after "hit" which calls the dealCard method, passing player
    //p as an argument
    public void dealCardWithHit(Player p){
        dealCard(p);
    }

    //method to determine the outcome.
    public void determineOutcome(){
    }

    //one-arg constructor for BlackJack, passing numCards as argument and
    //invoke the one-arg constructor of the super class.
    public BlackJack(int numCards){
        super(numCards);
    }

    //Class BlackJackPlayer is a subclass of Player.
    public static class BlackJackPlayer extends Player {

        //variable for bust threshold.
        final int BUST_SCORE = 21;
        //initialize numberHits and bust variables.
        private int numberHits;
        private boolean bust;

        //Setters and getters.
        public int getNumberHits() {
            return numberHits;
        }
        public boolean isBust() {
            return bust;
        }
        private void setNumberHits(int numberHits){
            this.numberHits = numberHits;
        }
        private void setBust(boolean bust){
            this.bust = bust;
        }

        //Method to check if hand is bust.
        public boolean checkBust(){
            boolean bust = false;
            return bust;
        }
        //Default constructor
        public BlackJackPlayer(){
        }
        //One-arg constructor passing name as an argument.
        public BlackJackPlayer(String name){
            super(name);
        }
    }
}










