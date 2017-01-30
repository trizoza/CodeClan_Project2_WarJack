package example.codeclan.com.cardgame;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by user on 21/01/2017.
 */

public class WarDeck {

    private CopyOnWriteArrayList<WarCard> pile;

    public WarDeck() {
        this.pile = new CopyOnWriteArrayList<>();
        this.setupDeck();
    }

    public void addCard(WarCard card) {
        pile.add(card);
    }

    public WarCard giveCard() {
        return pile.remove(0);
    }

    public void setupDeck() {
        for (WarCardName name : WarCardName.values()) {
            for (WarCardSuit suit : WarCardSuit.values()) {
                WarCard card = new WarCard(name, suit);
                addCard(card);
            }
        }
        Collections.shuffle(pile);
    }

    public int cardCount() {
        return pile.size();
    }

    public void distributeCards(Player player1, Player player2) {
        while (cardCount() != 0) {
            player1.addCard(giveCard());
            player2.addCard(giveCard());
        }
    }
}
