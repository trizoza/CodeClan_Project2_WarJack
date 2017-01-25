package example.codeclan.com.cardgame;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by user on 21/01/2017.
 */

public class WGame {

    private WDeck deck;
    private ArrayList<Player> players;
    private int turnCount;
    private Player player1;
    private Player player2;
    private WTable table;
    private String gameReport;
    private String card01;
    private String card02;
    private String card03;
    private String card04;
    private String card05;
    private String card06;


    public WGame() {
        this.deck = new WDeck();
        this.players = new ArrayList<>();
        this.turnCount = 0;
        this.player1 = new Player("You");
        this.player2 = new Player("Android");
        this.table = new WTable();
        this.gameReport = "";
        this.card01 = "";
        this.card02 = "";
        this.card03 = "";
        this.card04 = "";
        this.card05 = "";
        this.card06 = "";
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

    public int getTurnCount() {
        return turnCount;
    }

    public WDeck getDeck() {
        return deck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public WTable getTable() {
        return table;
    }

    public String getGameReport() {
        return this.gameReport;
    }

    public String getCard01() {
        return this.card01;
    }
    public void setCard01(String card) { this.card01 = card; }
    public String getCard02() {
        return this.card02;
    }
    public void setCard02(String card) { this.card02 = card; }
    public String getCard03() {
        return this.card03;
    }
    public void setCard03(String card) { this.card03 = card; }
    public String getCard04() {
        return this.card04;
    }
    public void setCard04(String card) { this.card04 = card; }
    public String getCard05() {
        return this.card05;
    }
    public void setCard05(String card) { this.card05 = card; }
    public String getCard06() {
        return this.card06;
    }
    public void setCard06(String card) { this.card06 = card; }

    ////// not tested ///////////

    public void setGameReport(Player player, int num) {
        String playedCard = table.getCardsOnTable().get(num).toString();
        String handCount = String.valueOf(player.cardCount());
        gameReport += player.getName() + " : " + playedCard + "\n"+ handCount +" cards remain\n\n";
    }

    ////// not tested //////////
    public void evaluateCards(int first, int second) {

        if (table.getCardsOnTable().get(first).getValue() > table.getCardsOnTable().get(second).getValue()) {
            String winningCard = String.valueOf(table.getCardsOnTable().get(first).getName());
            String loosingCard = String.valueOf(table.getCardsOnTable().get(second).getName());
            gameReport += winningCard + " trumps " + loosingCard + "\nYou take the cards!";
            higherCard(player1);
        }

        else if (table.getCardsOnTable().get(first).getValue() < table.getCardsOnTable().get(second).getValue()) {
            String winningCard = String.valueOf(table.getCardsOnTable().get(second).getName());
            String loosingCard = String.valueOf(table.getCardsOnTable().get(first).getName());
            gameReport += winningCard + " trumps " + loosingCard + "\nAndroid takes the cards!";
            higherCard(player2);
        }

        else {
            String bothCard = String.valueOf(table.getCardsOnTable().get(0).getName());
            gameReport += "Two " + bothCard + "s. \nDraw!";
            table.moveCardsAside();
        }
    }

    ////// not tested //////////

    public void singleCard() {

        table.addCardToTable(player1.giveCard());
        setGameReport(player1, 0);
        setCard01(table.getCardsOnTable().get(0).toString());

        table.addCardToTable(player2.giveCard());
        setGameReport(player2, 1);
        setCard04(table.getCardsOnTable().get(1).toString());
        evaluateCards(0,1);

        setCard02("");
        setCard03("");
        setCard05("");
        setCard06("");
    }

    ////// not tested //////////

    public void doubleCard() {

        table.addCardToTable(player1.giveCard());
        setGameReport(player1, 0);
        setCard01(table.getCardsOnTable().get(0).toString());

        table.addCardToTable(player1.giveCard());
        setGameReport(player1, 1);
        setCard02(table.getCardsOnTable().get(1).toString());

        table.addCardToTable(player2.giveCard());
        setGameReport(player2, 2);
        setCard04(table.getCardsOnTable().get(2).toString());

        table.addCardToTable(player2.giveCard());
        setGameReport(player2, 3);
        setCard05(table.getCardsOnTable().get(3).toString());

        evaluateCards(1,3);

        setCard03("");
        setCard06("");
    }

    ////// not tested //////////

    public void trippleCard() {

        table.addCardToTable(player1.giveCard());
        setGameReport(player1, 0);
        setCard01(table.getCardsOnTable().get(0).toString());

        table.addCardToTable(player1.giveCard());
        setGameReport(player1, 1);
        setCard02(table.getCardsOnTable().get(1).toString());

        table.addCardToTable(player1.giveCard());
        setGameReport(player1, 2);
        setCard03(table.getCardsOnTable().get(2).toString());

        table.addCardToTable(player2.giveCard());
        setGameReport(player2, 3);
        setCard04(table.getCardsOnTable().get(3).toString());

        table.addCardToTable(player2.giveCard());
        setGameReport(player2, 4);
        setCard05(table.getCardsOnTable().get(4).toString());

        table.addCardToTable(player2.giveCard());
        setGameReport(player2, 5);
        setCard06(table.getCardsOnTable().get(5).toString());

        evaluateCards(2,5);
    }

    ////// not tested //////////

    public void higherCard(Player player) {
        table.moveCardsAside();
        table.giveSideCardsToPlayer(player);
    }

    //////////////////// GAME LOGIC /////////////////////

    public String play() {
        /// GAME FLOW
        turnCount += 1;
        gameReport = "";
        if (player1.cardCount() > 0 && player2.cardCount() > 0
                && table.cardCountOnTable() == 0
                && table.cardCountOnSide() == 0) {
            singleCard();
        }

        else if (player1.cardCount() >= 3 && player2.cardCount() >= 3
                && table.cardCountOnTable() == 0
                && table.cardCountOnSide() >= 2) {
            trippleCard();
        }

        else if (player1.cardCount() >= 2 && player2.cardCount() >= 2
                && table.cardCountOnTable() == 0
                && table.cardCountOnSide() >= 2) {
            doubleCard();
        }

        else if (player1.cardCount() > 0 && player2.cardCount() > 0
                && table.cardCountOnTable() == 0
                && table.cardCountOnSide() >= 2) {
            singleCard();
        }

        else {
            if (player1.cardCount() == 0 && player2.cardCount() == 0) {
                table.distributeCardsFromSide(player1, player2);
                gameReport += "SUPER TIE! RESHUFFLE THE PILE!";
            }
            /// PLAYER 1 WON
            else if (player1.cardCount() > player2.cardCount()) {
                table.giveSideCardsToPlayer(player1);
                String turns = String.valueOf(turnCount);
                gameReport += "YOU WON ALL 32 CARDS IN " + turns + " TURNS!" +
                        "\n\nLET YOUR LITTLE VICTORY STAY FOREVER IN THE STATISTICS OF THIS DEVICE!";
            }
            /// ANDROID WON
            else {
                table.giveSideCardsToPlayer(player2);
                String turns = String.valueOf(turnCount);
                gameReport += "ANDROID WON ALL 32 CARDS IN " + turns + " TURNS!" +
                        "\n\nLET HIS LITTLE VICTORY STAY FOREVER IN THE STATISTICS OF THIS DEVICE!";
            }
        }
        return gameReport;
    }

/////////////   ORIGINAL -FULLY-AUTOMATED- PLAY METHOD - IM GONNA MISS YOU!!! /////////////////////////////////
//
//    public String Play() {
//        /// NEW TURN, EACH PLAYER PLAYS 1 CARD
//        while (player1.cardCount() > 0 && player2.cardCount() > 0) {
//            singleCard();
//
//            /// BOTH PLAYERS HAVE MORE THAN 3 CARDS THEY PLAYED CARDS OF SAME VALUE
//            /// AFTER SINGLE TURN AT THE BEGINNING OF WHILE LOOP
//            if (player1.cardCount() >= 3 && player2.cardCount() >= 3
//                    && table.getCardsOnTable().get(0).getValue() == table.getCardsOnTable().get(1).getValue()) {
//
//                table.moveCardsAside();
//                trippleCard();
//                System.out.println("A");
//
//                /// BOTH PLAYERS HAVE MORE THAN 3 CARDS THEY PLAYED CARDS OF SAME VALUE
//                while (player1.cardCount() >= 3 && player2.cardCount() >= 3
//                        && table.getCardsOnTable().get(2).getValue() == table.getCardsOnTable().get(5).getValue()) {
//                    table.moveCardsAside();
//                    trippleCard();
//                    turnCount += 1;
//                    System.out.println("B");
//                }
//
//                ///BOTH PLAYERS HAVE MORE THAN 2 CARDS AND THEY PLAYED CARDS OF SAME VALUE
//                if (player1.cardCount() >= 2 && player2.cardCount() >= 2
//                        && table.getCardsOnTable().get(2).getValue() == table.getCardsOnTable().get(5).getValue()) {
//                    table.moveCardsAside();
//                    doubleCard();
//                    System.out.println("C");
//
//                    if (table.getCardsOnTable().get(1).getValue() == table.getCardsOnTable().get(3).getValue()) {
//                        table.moveCardsAside();
//                        if (player1.cardCount() == 0 && player2.cardCount() == 0) {
//                            table.distributeCardsFromSide(player1, player2);
//                            System.out.println("D");
//                        }
//                        else if (player1.cardCount() > player2.cardCount()) {
//                            table.giveSideCardsToPlayer(player1);
//                            System.out.println("E");
//                        }
//                        else {
//                            table.giveSideCardsToPlayer(player2);
//                            System.out.println("F");
//                        }
//                    }
//
//                    else if (table.getCardsOnTable().get(1).getValue() > table.getCardsOnTable().get(3).getValue()) {
//                        higherCard(player1);
//                        System.out.println("G");
//                    }
//
//                    else {
//                        higherCard(player2);
//                        System.out.println("H");
//                    }
//                    turnCount += 1;
//                }
//
//                /// BOTH PLAYERS HAVE MORE THAN 1 CARD AND THEY PLAYED CARDS OF SAME VALUE
//                else if (player1.cardCount() >= 1 && player2.cardCount() >= 1
//                        && table.getCardsOnTable().get(2).getValue() == table.getCardsOnTable().get(5).getValue()) {
//                    table.moveCardsAside();
//                    singleCard();
//                    System.out.println("I");
//
//                    if (table.getCardsOnTable().get(0).getValue() == table.getCardsOnTable().get(1).getValue()) {
//                        table.moveCardsAside();
//                        if (player1.cardCount() == 0 && player2.cardCount() == 0) {
//                            table.distributeCardsFromSide(player1, player2);
//                            System.out.println("J");
//                        }
//                        else if (player1.cardCount() > player2.cardCount()) {
//                            table.giveSideCardsToPlayer(player1);
//                            System.out.println("K");
//                        }
//                        else {
//                            table.giveSideCardsToPlayer(player2);
//                            System.out.println("L");
//                        }
//                    }
//
//                    else if (table.getCardsOnTable().get(0).getValue() > table.getCardsOnTable().get(1).getValue()) {
//                        higherCard(player1);
//                        System.out.println("M");
//                    }
//
//                    else {
//                        higherCard(player2);
//                        System.out.println("N");
//                    }
//                    turnCount += 1;
//                }
//
//                /// ONE OF THE PLAYERS DOES NOT HAVE ANY MORE CARDS AND THEY PLAYED CARDS OF SAME VALUE
//                else if (table.getCardsOnTable().get(2).getValue() == table.getCardsOnTable().get(5).getValue()) {
//                    table.moveCardsAside();
//                    if (player1.cardCount() == 0 && player2.cardCount() == 0) {
//                        table.distributeCardsFromSide(player1, player2);
//                        System.out.println("O");
//                    }
//                    else if (player1.cardCount() > player2.cardCount()) {
//                        table.giveSideCardsToPlayer(player1);
//                        System.out.println("P");
//                    }
//                    else {
//                        table.giveSideCardsToPlayer(player2);
//                        System.out.println("Q");
//                    }
//                    turnCount += 1;
//                }
//
//                /// FIRST PLAYER PLAYED HIGHER CARD
//                else if (table.getCardsOnTable().get(2).getValue() > table.getCardsOnTable().get(5).getValue()) {
//                    higherCard(player1);
//                    System.out.println("R");
//                }
//
//                /// SECOND PLAYER PLAYED HIGHER CARD
//                else {
//                    higherCard(player2);
//                    System.out.println("S");
//                }
//                turnCount += 1;
//            }
//
//            /// BOTH PLAYERS HAVE MORE THAN 2 CARDS AND THEY PLAYED CARDS OF SAME VALUE
//            /// AFTER SINGLE TURN AT THE BEGINNING OF WHILE LOOP
//            else if (player1.cardCount() >= 2 && player2.cardCount() >= 2
//                    && table.getCardsOnTable().get(0).getValue() == table.getCardsOnTable().get(1).getValue()) {
//                table.moveCardsAside();
//                doubleCard();
//                System.out.println("T");
//
//                if (table.getCardsOnTable().get(1).getValue() == table.getCardsOnTable().get(3).getValue()) {
//                    table.moveCardsAside();
//                    if (player1.cardCount() == 0 & player2.cardCount() == 0) {
//                        table.distributeCardsFromSide(player1, player2);
//                        System.out.println("U");
//                    }
//                    else if (player1.cardCount() > player2.cardCount()) {
//                        table.giveSideCardsToPlayer(player1);
//                        System.out.println("V");
//                    }
//                    else {
//                        table.giveSideCardsToPlayer(player2);
//                        System.out.println("W");
//                    }
//                }
//
//                else if (table.getCardsOnTable().get(1).getValue() > table.getCardsOnTable().get(3).getValue()) {
//                    higherCard(player1);
//                    System.out.println("X");
//                }
//
//                else {
//                    higherCard(player2);
//                    System.out.println("Y");
//                }
//                turnCount += 1;
//            }
//
//            /// BOTH PLAYERS HAVE MORE THAN 1 CARD THEY PLAYED CARDS OF SAME VALUE
//            /// AFTER SINGLE TURN AT THE BEGINNING OF WHILE LOOP
//            else if (player1.cardCount() >= 1 && player2.cardCount() >= 1
//                    && table.getCardsOnTable().get(0).getValue() == table.getCardsOnTable().get(1).getValue()) {
//                table.moveCardsAside();
//                singleCard();
//                System.out.println("Z");
//                if (table.getCardsOnTable().get(0).getValue() == table.getCardsOnTable().get(1).getValue()) {
//
//                    if (player1.cardCount() == 0 && player2.cardCount() == 0) {
//                        table.distributeCardsFromSide(player1, player2);
//                        System.out.println("1");
//                    }
//                    else if (player1.cardCount() > player2.cardCount()) {
//                        table.giveSideCardsToPlayer(player1);
//                        System.out.println("2");
//                    }
//                    else {
//                        table.giveSideCardsToPlayer(player2);
//                        System.out.println("3");
//                    }
//                }
//
//                else if (table.getCardsOnTable().get(0).getValue() > table.getCardsOnTable().get(1).getValue()) {
//                    higherCard(player1);
//                    System.out.println("4");
//                }
//
//                else {
//                    higherCard(player2);
//                    System.out.println("5");
//                }
//                turnCount += 1;
//            }
//
//            /// BOTH PLAYERS PLAYED CARDS OF SAME VALUE BUT AT LEAST ONE OF THEM HAS NO MORE CARDS
//            /// SINGLE TURN AT THE BEGINNING OF WHILE LOOP
//            else if (table.getCardsOnTable().get(0).getValue() == table.getCardsOnTable().get(1).getValue()) {
//                table.moveCardsAside();
//                if (player1.cardCount() == 0 & player2.cardCount() == 0) {
//                    table.distributeCardsFromSide(player1, player2);
//                    System.out.println("5");
//                }
//                else if (player1.cardCount() > player2.cardCount()) {
//                    table.giveSideCardsToPlayer(player1);
//                    System.out.println("6");
//                }
//                else {
//                    table.giveSideCardsToPlayer(player2);
//                    System.out.println("7");
//                }
//                turnCount += 1;
//            }
//
//            /// FIRST PLAYER PLAYED HIGHER CARD
//            else if (table.getCardsOnTable().get(0).getValue() > table.getCardsOnTable().get(1).getValue()) {
//                higherCard(player1);
//                System.out.println("8");
//            }
//
//            /// SECOND PLAYER PLAYED HIGHER CARD
//            else {
//                higherCard(player2);
//                System.out.println("9");
//            }
//            turnCount += 1;
//        } /*end of main while loop*/
//
//        if (player1.cardCount() > player2.cardCount()) {
//            System.out.println("After " + turnCount + " turns You won the game of War! Let your little victory forever stay in the statistics of this device!");
//
//        }
//        else {
//            System.out.println("After " + turnCount + " turns Android won the game of War! Let his little victory forever stay in the statistics of this device!");
//
//        }
//        System.out.println(player1.getName() + " " + player1.cardCount());
//        System.out.println(player2.getName() + " " + player2.cardCount());
//        String over = "Game over";
//        return over;
//    }
//
/////////////////   SERIOUSLY, WE HAD SUCH A GREAT TIME TOGETHER ////////////////////////////////////////////////////////



}
