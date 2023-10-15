//Abstract class CardGame.
public abstract class CardGame {
    //method to deal card passing type Player p.
    public static void dealCard(Player p){
        //Call to addCard2Hand method passing Card's one-arg
        //constructor as an argument, while passing 1 to the
        //constructor.
        p.addCard2Hand(new Card(1));
    }
    //method to shuffle the deck.
    public static void shuffleDeck(){
    }
    //CardGame default constructor
    public CardGame(){
    }
    //CardGame one-arg constructor passing numCards as argument.
    public CardGame(int numCards){
    }
    //Method to determine the outcome of the game, passing two arguments
    //of type Player.
    public void determineOutcome(Player p, Player d){
    }
    //Class Card is a subclass of CardGame.
    public static class Card extends CardGame {

        //initialize variables for rank, suit and score.
        private String rank;
        private String suit;
        private int score;

        //Getters and setters for rank, suit and score.
        public String getRank() {
            return rank;
        }

        public String getSuit() {
            return suit;
        }

        public int getScore() {
            return score;
        }

        private void setRank(String rank) {
            this.rank = rank;
        }

        private void setSuit(String suit) {
            this.suit = suit;
        }

        private void setScore(int score) {
            this.score = score;
        }

        //One-arg constructor for Card, passing numCards as argument.
        public Card(int numCards) {
        }

        //Override the toString method defined in the superclass.
        public String toString() {
            return "\t" + rank + " of " + suit;
        }
    }

    //Player class
    public static class Player {

        //Initialize variables name and currentScore.
        private String name;
        private int currentScore;
        //Getters and setters.
        public String getName(){
            return name;
        }
        public int getCurrentScore() {
            return currentScore;
        }
        private void setName(String name){
            this.name = name;
        }
        private void setCurrentScore(int currentScore){
            this.currentScore = currentScore;
        }

        //getCard method takes cardIndex as argument and returns an empty string for now.
        public String getCard(int cardIndex){
            return "";
        }

        //Method to add card to hand. Takes one argument of type Card.
        public void addCard2Hand(Card c){
            setCurrentScore(22);
        }
        //method to display hand properly formatted I assume.
        public void displayFormattedHand(){
        }
        //Player class default constructor.
        public Player(){
        }
        //Player class one-arg constructor takes name as an argument
        //and calls the setName function, passing name to it.
        public Player(String name){
            setName(name);
        }
    }
}
















