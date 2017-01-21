package example.codeclan.com.cardgame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 21/01/2017.
 */

public class WDeck {

    private ArrayList<WCard> pile;

    public WDeck() {
        this.pile = new ArrayList<>();
        this.setupDeck();
    }

    public void addCard(WCard card) {
        pile.add(card);
    }

    public void giveCard() {
        pile.remove(0);
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
}
