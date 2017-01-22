package example.codeclan.com.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by user on 21/01/2017.
 */

public class WTable {

    private CopyOnWriteArrayList<WCard> cardsOnTable;
    private CopyOnWriteArrayList<WCard> cardsOnSide;

    public WTable() {
        this.cardsOnTable = new CopyOnWriteArrayList<>();
        this.cardsOnSide = new CopyOnWriteArrayList<>();
    }

    public CopyOnWriteArrayList<WCard> getCardsOnTable() {
        return cardsOnTable;
    }

    public CopyOnWriteArrayList<WCard> getCardsOnSide() {
        return cardsOnSide;
    }

    public void addCardToTable(WCard card) {
        cardsOnTable.add(card);
    }

    public void addCardAside(WCard card) {
        cardsOnSide.add(card);
    }

    public int cardCountOnTable() {
        return cardsOnTable.size();
    }

    public int cardCountOnSide() {
        return cardsOnSide.size();
    }

    public void moveCardsAside() {
        for (WCard card : cardsOnTable) {
            addCardAside(card);
            cardsOnTable.remove(0);
        }
    }

    public void giveSideCardsToPlayer(WPlayer player) {
        Collections.shuffle(cardsOnSide);
        for (WCard card : cardsOnSide) {
            player.addCard(card);
            cardsOnSide.remove(0);
        }
    }

    ////// not tested //////////

    public void distributeCardsFromSide(WPlayer player1, WPlayer player2) {
        Collections.shuffle(cardsOnSide);
        while (cardCountOnSide() != 0) {
            player1.addCard(cardsOnSide.remove(0));
            player2.addCard(cardsOnSide.remove(0));
        }
    }

}
