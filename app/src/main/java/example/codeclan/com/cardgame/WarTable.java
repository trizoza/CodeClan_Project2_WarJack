package example.codeclan.com.cardgame;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by user on 21/01/2017.
 */

public class WarTable {

    private CopyOnWriteArrayList<WarCard> cardsOnTable;
    private CopyOnWriteArrayList<WarCard> cardsOnSide;

    public WarTable() {
        this.cardsOnTable = new CopyOnWriteArrayList<>();
        this.cardsOnSide = new CopyOnWriteArrayList<>();
    }

    public CopyOnWriteArrayList<WarCard> getCardsOnTable() {
        return cardsOnTable;
    }

    public CopyOnWriteArrayList<WarCard> getCardsOnSide() {
        return cardsOnSide;
    }

    public void addCardToTable(WarCard card) {
        cardsOnTable.add(card);
    }

    public void addCardAside(WarCard card) {
        cardsOnSide.add(card);
    }

    public int cardCountOnTable() {
        return cardsOnTable.size();
    }

    public int cardCountOnSide() {
        return cardsOnSide.size();
    }

    public void moveCardsAside() {
        for (WarCard card : cardsOnTable) {
            addCardAside(card);
            cardsOnTable.remove(0);
        }
    }

    public void giveSideCardsToPlayer(Player player) {
        Collections.shuffle(cardsOnSide);
        for (WarCard card : cardsOnSide) {
            player.addCard(card);
            cardsOnSide.remove(0);
        }
    }

    //distributes cards evenly
    public void distributeCardsFromSide(Player player1, Player player2) {
        Collections.shuffle(cardsOnSide);
        while (cardCountOnSide() != 0) {
            player1.addCard(cardsOnSide.remove(0));
            player2.addCard(cardsOnSide.remove(0));
        }
    }

}
