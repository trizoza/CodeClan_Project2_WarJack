package example.codeclan.com.cardgame;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by user on 21/01/2017.
 */

public class WDeck {

    private CopyOnWriteArrayList<WCard> pile;

    public WDeck() {
        this.pile = new CopyOnWriteArrayList<>();
        this.setupDeck();
    }

    public void addCard(WCard card) {
        pile.add(card);
    }

    public WCard giveCard() {
        return pile.remove(0);
    }

    public void setupDeck() {
        for (WCardName name : WCardName.values()) {
            for (WCardSuit suit : WCardSuit.values()) {
                WCard card = new WCard(name, suit);
                addCard(card);
            }
        }
        Collections.shuffle(pile);
    }

    public int cardCount() {
        return pile.size();
    }

    public void distributeCards(WPlayer player1, WPlayer player2) {
        while (cardCount() != 0) {
            player1.addCard(giveCard());
            player2.addCard(giveCard());
        }
    }
}
