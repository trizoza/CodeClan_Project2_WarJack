package example.codeclan.com.cardgame;

import java.util.ArrayList;

/**
 * Created by user on 22/01/2017.
 */

public class BJGame {

    private BJDeck deck;
    private ArrayList<Player> players;
    private Player player1;
    private Player player2;

    public BJGame() {
        this.deck = new BJDeck();
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

    public BJDeck getDeck() {
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
            for (BJCard card : player.getBJHand()) {
                if (card.getValue() == 11) {
                    card.setAceValue(1);
                }
            }
        }
        /// PRINT OUT HAND
        String playersHand = "";
        for (BJCard card : player.getBJHand()) {
            playersHand += card.toString() + "\n";
        }
        playersHand += "\nTotal:  " + player.getValueOfHand() + " points.\n";
        return playersHand;
    }


    ////////// SET GOLDEN EYE (21 eye specialty)//////////////
    //for (Player player : players) {
    //    if (player.getBJHand().size() == 2 && player.getValueOfHand() == 22) {
    //        player.getBJHand().get(0).setAceValue(11);
    //        player.getBJHand().get(1).setAceValue(1);
    //    }
    //}

    //////////// EVALUATION //////////////

    public String evaluation() {
        String report = "";
        if (player1.getValueOfHand() == player2.getValueOfHand() && player1.getValueOfHand() <= 21){
            report = " It is a tie of " + player1.getValueOfHand() + " points.";
        }
        else if (player1.getValueOfHand() > 21 && player2.getValueOfHand() > 21) {
            report = " No one won. Both busted.";
        }
        else if (player1.getValueOfHand() <= 21 && player2.getValueOfHand() > 21) {
            report = " You won with " + player1.getValueOfHand() + " points over Android which busted with " + player2.getValueOfHand() + " points.";
        }
        else if (player2.getValueOfHand() <= 21 && player1.getValueOfHand() > 21) {
            report = " Android won with " + player2.getValueOfHand() + " points over you who busted with " + player1.getValueOfHand() + " points.";
        }
        else if (player1.getValueOfHand() <= 21 && player1.getValueOfHand() > player2.getValueOfHand()) {
            report = " You won with " + player1.getValueOfHand() + " points over Android with " + player2.getValueOfHand() + " points.";
        }
        else if (player2.getValueOfHand() <= 21 && player2.getValueOfHand() > player1.getValueOfHand()) {
            report = " Android won with " + player2.getValueOfHand() + " points over you with " + player1.getValueOfHand() + " points.";
        }
        return report;
    }

    public String play() {
        evaluation();
        String over = "over";
        return over;
    }

}
