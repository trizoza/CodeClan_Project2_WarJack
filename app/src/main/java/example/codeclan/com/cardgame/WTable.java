package example.codeclan.com.cardgame;

import java.util.ArrayList;
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
            WCard cardOnTable = cardsOnTable.get(0);
            addCardAside(cardOnTable);
            cardsOnTable.remove(0);
        }
    }

    public void giveSideCardsToPlayer(WPlayer player) {
        for (WCard card : cardsOnSide) {
            WCard cardOnSide = cardsOnSide.get(0);
            player.addCard(cardOnSide);
            cardsOnSide.remove(0);
        }
    }

}
