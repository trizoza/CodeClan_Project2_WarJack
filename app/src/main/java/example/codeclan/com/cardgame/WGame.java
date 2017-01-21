package example.codeclan.com.cardgame;

import java.util.ArrayList;

/**
 * Created by user on 21/01/2017.
 */

public class WGame {

    private WDeck deck;
    private ArrayList<WPlayer> players;
    private int turnCount;
    private WPlayer player1;
    private WPlayer player2;
    private WTable table;

    public WGame() {
        this.deck = new WDeck();
        this.players = new ArrayList<>();
        this.turnCount = 0;
        this.player1 = new WPlayer("Player");
        this.player2 = new WPlayer("Android");
        this.table = new WTable();
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

    public ArrayList<WPlayer> getPlayers() {
        return players;
    }

    public WTable getTable() {
        return table;
    }

    //////////////// REFACTORED GAME LOGIC METHODS /////////////////////

    public void singleCard() {

    }

    public void trippleCard() {

    }

    public void higherCard(WPlayer player) {
        table.moveCardsAside();
        table.giveSideCardsToPlayer(player);
        turnCount += 1;
    }

    //////////////////// GAME LOGIC /////////////////////

    public String play() {
        while (player1.cardCount() > 0 && player2.cardCount() > 0) {

            table.addCardToTable(player1.giveCard());
            table.addCardToTable(player2.giveCard());

            if (player1.cardCount() >= 3 && player2.cardCount() >= 3
                    && table.getCardsOnTable().get(0).getValue() == table.getCardsOnTable().get(1).getValue()) {

                table.moveCardsAside();
                table.addCardToTable(player1.giveCard());
                table.addCardToTable(player1.giveCard());
                table.addCardToTable(player1.giveCard());
                table.addCardToTable(player2.giveCard());
                table.addCardToTable(player2.giveCard());
                table.addCardToTable(player2.giveCard());

                while (player1.cardCount() >= 3 && player2.cardCount() >= 3
                        && table.getCardsOnTable().get(2).getValue() == table.getCardsOnTable().get(5).getValue()) {

                    table.moveCardsAside();
                    table.addCardToTable(player1.giveCard());
                    table.addCardToTable(player1.giveCard());
                    table.addCardToTable(player1.giveCard());
                    table.addCardToTable(player2.giveCard());
                    table.addCardToTable(player2.giveCard());
                    table.addCardToTable(player2.giveCard());

                }

                if (table.getCardsOnTable().get(2).getValue() > table.getCardsOnTable().get(5).getValue()) {

                    higherCard(player1);

                }

                else if (table.getCardsOnTable().get(2).getValue() < table.getCardsOnTable().get(5).getValue()) {

                    higherCard(player2);

                }

                else if (player1.cardCount() >= 2 && player2.cardCount() >= 2
                        && table.getCardsOnTable().get(2).getValue() == table.getCardsOnTable().get(5).getValue()) {

                    table.moveCardsAside();
                    table.addCardToTable(player1.giveCard());
                    table.addCardToTable(player1.giveCard());
                    table.addCardToTable(player2.giveCard());
                    table.addCardToTable(player2.giveCard());

                    if (table.getCardsOnTable().get(1).getValue() == table.getCardsOnTable().get(3).getValue()) {
                        table.moveCardsAside();

                        if (player1.cardCount() == 0 & player2.cardCount() == 0) {
                            //distribute cards evenly
                            table.distributeCardsFromSide(player1, player2);
                            turnCount += 1;

                        }

                        else if (player1.cardCount() > player2.cardCount()) {

                            table.giveSideCardsToPlayer(player1);
                            turnCount += 1;

                        }

                        else {

                            table.giveSideCardsToPlayer(player2);
                            turnCount += 1;

                        }

                    }

                    else if (table.getCardsOnTable().get(1).getValue() > table.getCardsOnTable().get(3).getValue()) {

                        higherCard(player1);

                    }

                    else {

                        higherCard(player2);

                    }

                }

            } else if (player1.cardCount() >= 2 && player2.cardCount() >= 2
                    && table.getCardsOnTable().get(0).getValue() == table.getCardsOnTable().get(1).getValue()) {

                table.moveCardsAside();
                table.addCardToTable(player1.giveCard());
                table.addCardToTable(player1.giveCard());
                table.addCardToTable(player2.giveCard());
                table.addCardToTable(player2.giveCard());

                if (table.getCardsOnTable().get(1).getValue() == table.getCardsOnTable().get(3).getValue()) {
                    table.moveCardsAside();

                    if (player1.cardCount() == 0 & player2.cardCount() == 0) {
                        //distribute cards evenly
                        table.distributeCardsFromSide(player1, player2);
                        turnCount += 1;

                    }

                    else if (player1.cardCount() > player2.cardCount()) {

                        table.giveSideCardsToPlayer(player1);
                        turnCount += 1;

                    }

                    else {

                        table.giveSideCardsToPlayer(player2);
                        turnCount += 1;

                    }

                }

                else if (table.getCardsOnTable().get(1).getValue() > table.getCardsOnTable().get(3).getValue()) {

                    higherCard(player1);

                }

                else {

                    higherCard(player2);

                }

            }

            else if (table.getCardsOnTable().get(0).getValue() == table.getCardsOnTable().get(1).getValue()) {

                table.moveCardsAside();

                if (player1.cardCount() == 0 & player2.cardCount() == 0) {
                    //distribute cards evenly
                    table.distributeCardsFromSide(player1, player2);
                    turnCount += 1;

                }

                else if (player1.cardCount() > player2.cardCount()) {

                    table.giveSideCardsToPlayer(player1);
                    turnCount += 1;

                }

                else {

                    table.giveSideCardsToPlayer(player2);
                    turnCount += 1;

                }

            }

            else if (table.getCardsOnTable().get(0).getValue() > table.getCardsOnTable().get(1).getValue()) {

                higherCard(player1);

            }

            else {

                higherCard(player2);

            }

        } /*OK end of main while loop*/

        if (player1.cardCount() != 0) {
            System.out.println("After " + turnCount + " turns Player won the game of War! Let his little win forever stay in the statistics of this device!");
            return player1.getName();
        } /*OK*/ else {
            System.out.println("After " + turnCount + " turns Android won the game of War! Let his little win forever stay in the statistics of this device!");
            return player2.getName();
        } /*OK*/


    }




}
