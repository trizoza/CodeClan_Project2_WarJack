package example.codeclan.com.cardgame;

import java.util.ArrayList;

/**
 * Created by user on 22/01/2017.
 */

public class BlackJackGame {

    private BlackJackDeck deck;
    private ArrayList<Player> players;
    private Player player1;
    private Player player2;

    public BlackJackGame() {
        this.deck = new BlackJackDeck();
        this.players = new ArrayList<>();
        this.player1 = new Player("Player");
        this.player2 = new Player("Android");
        setupGame();
    }

    private void setupGame() {
        deck.distributeCards(player1, player2);
        players.add(player1);
        players.add(player2);
    }

    public int numOfPlayers() {
        return players.size();
    }

    public BlackJackDeck getDeck() {
        return deck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void twoAcesCatch(Player player) {
        if (player.getBJHand().size() == 2 && player.getValueOfHand() == 22) {
            player.getBJHand().get(0).setAceValue(11);
            player.getBJHand().get(1).setAceValue(1);
        }
    }

    public void hit(Player player) {
        deck.dealCard(player);
    }

    public String Turn(Player player) {
        /// TWO ACES CATCHER
        twoAcesCatch(player);
        /// ACE 11 -> 1 CATCHER
        if (player.getValueOfHand() > 21) {
            for (BlackJackCard card : player.getBJHand()) {
                if (card.getValue() == 11) {
                    card.setAceValue(1);
                }
            }
        }
        /// PRINT OUT HAND
        String playersHand = player.getValueOfHand() + " points.";
        return playersHand;
    }

    //////////// EVALUATION //////////////

    public String evaluation() {
        String report = "";
        if (player1.getValueOfHand() == player2.getValueOfHand() && player1.getValueOfHand() <= 21){
            report = "It is a tie of "
                    + player1.getValueOfHand()
                    + " points.";
        }
        else if (player1.getValueOfHand() > 21) {
            report = "You busted. Android wins.";
        }
        else if (player1.getValueOfHand() <= 21 && player2.getValueOfHand() > 21) {
            report = "Android busted. You won.";
        }
        else if (player1.getValueOfHand() <= 21 && player1.getValueOfHand() > player2.getValueOfHand()) {
            report = "You won";
        }
        else if (player2.getValueOfHand() <= 21 && player2.getValueOfHand() > player1.getValueOfHand()) {
            report = "Android won.";
        }
        return report;
    }

    public String statsEvaluation() {
        String stats = "";
        if (player1.getValueOfHand() == player2.getValueOfHand() && player1.getValueOfHand() <= 21){
            stats = "tie";
        }
        else if (player1.getValueOfHand() > 21) {
            stats = "android";
        }
        else if (player1.getValueOfHand() <= 21 && player2.getValueOfHand() > 21) {
            stats = "player";
        }
        else if (player1.getValueOfHand() <= 21 && player1.getValueOfHand() > player2.getValueOfHand()) {
            stats = "player";
        }
        else if (player2.getValueOfHand() <= 21 && player2.getValueOfHand() > player1.getValueOfHand()) {
            stats = "android";
        }
        return stats;
    }

}
