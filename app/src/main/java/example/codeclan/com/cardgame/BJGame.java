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

    public void playerTurn() {

        twoAcesCatch(player1);

        String p1c1 = player1.getBJHand().get(0).toString();
        String p1c2 = player1.getBJHand().get(1).toString();
        String p1Hand = p1c1 + " and " + p1c2;
        System.out.println("You: " + p1Hand + " has value of " + player1.getValueOfHand());

    }



    public void androidTurn() {

        twoAcesCatch(player2);

        String p2c1 = player2.getBJHand().get(0).toString();
        String p2c2 = player2.getBJHand().get(1).toString();
        String p2Hand = p2c1 + " and " + p2c2;
        System.out.println("Android: " + p2Hand + " has value of " + player2.getValueOfHand());

        while (player2.getValueOfHand() <= 17) {
            deck.dealCard(player2);
            if (player2.getValueOfHand() > 21) {
                for (BJCard card : player2.getBJHand()) {
                    if (card.getValue() == 11) {
                        card.setAceValue(1);
                    }
                }
            }
        }

    }

        ////////// SET GOLDEN EYE (21 eye specialty)//////////////
        //for (Player player : players) {
        //    if (player.getBJHand().size() == 2 && player.getValueOfHand() == 22) {
        //        player.getBJHand().get(0).setAceValue(11);
        //        player.getBJHand().get(1).setAceValue(1);
        //    }
        //}

    //////////// EVALUATION //////////////

    public void evaluation() {

        if (player1.getValueOfHand() == player2.getValueOfHand() && player1.getValueOfHand() <= 21){
            System.out.println(" It is a tie of " + player1.getValueOfHand() + " points.");
            System.out.println(" You played:");
            for (BJCard card : player1.getBJHand()) {
                System.out.println(card.toString());
            }
            System.out.println(" Android played:");
            for (BJCard card : player2.getBJHand()) {
                System.out.println(card.toString());
            }
        }

        else if (player1.getValueOfHand() > 21 && player2.getValueOfHand() > 21) {
            System.out.println(" No one won.");
            System.out.println(" You busted " + player1.getValueOfHand() + " points:");
            for (BJCard card : player1.getBJHand()) {
                System.out.println(card.toString());
            }
            System.out.println(" Android busted " + player2.getValueOfHand() + " points:");
            for (BJCard card : player2.getBJHand()) {
                System.out.println(card.toString());
            }
        }

        else if (player1.getValueOfHand() <= 21 && player2.getValueOfHand() > 21) {
            System.out.println(" You won with " + player1.getValueOfHand() + " points:");
            for (BJCard card : player1.getBJHand()) {
                System.out.println(card.toString());
            }
            System.out.println(" Over Android who busted with " + player2.getValueOfHand() + " points:");
            for (BJCard card : player2.getBJHand()) {
                System.out.println(card.toString());
            }
        }

        else if (player2.getValueOfHand() <= 21 && player1.getValueOfHand() > 21) {
            System.out.println(" Android won with " + player2.getValueOfHand() + " points:");
            for (BJCard card : player2.getBJHand()) {
                System.out.println(card.toString());
            }
            System.out.println(" Over you who busted with " + player1.getValueOfHand() + " points:");
            for (BJCard card : player1.getBJHand()) {
                System.out.println(card.toString());
            }
        }

        else if (player1.getValueOfHand() <= 21 && player1.getValueOfHand() > player2.getValueOfHand()) {
            System.out.println(" You won with " + player1.getValueOfHand() + " points:");
            for (BJCard card : player1.getBJHand()) {
                System.out.println(card.toString());
            }
            System.out.println(" Over Android with " + player2.getValueOfHand() + " points:");
            for (BJCard card : player2.getBJHand()) {
                System.out.println(card.toString());
            }
        }

        else if (player2.getValueOfHand() <= 21 && player2.getValueOfHand() > player1.getValueOfHand()) {
            System.out.println(" Android won with " + player2.getValueOfHand() + " points:");
            for (BJCard card : player2.getBJHand()) {
                System.out.println(card.toString());
            }
            System.out.println(" Over you with " + player1.getValueOfHand() + " points:");
            for (BJCard card : player1.getBJHand()) {
                System.out.println(card.toString());
            }
        }
    }

    public String play() {
        playerTurn();
        androidTurn();
        evaluation();
        String over = "over";
        return over;
    }

}
