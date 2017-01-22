package example.codeclan.com.cardgame;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by user on 22/01/2017.
 */

public class BJDeck {

    private CopyOnWriteArrayList<BJCard> pile;

    public BJDeck() {
        this.pile = new CopyOnWriteArrayList<>();
        this.setupDeck();
    }

    public void addCard(BJCard card) {
        pile.add(card);
    }

    public BJCard giveCard() {
        return pile.remove(0);
    }

    public void setupDeck() {
        for (BJCardName name : BJCardName.values()) {
            for (BJCardSuit suit : BJCardSuit.values()) {
                BJCard card = new BJCard(name, suit);
                addCard(card);
            }
        }
        Collections.shuffle(pile);
    }

    public int cardCount() {
        return pile.size();
    }

    public void dealCard(Player player) {
        player.addBJCard(giveCard());
    }

    public void distributeCards(Player player1, Player player2) {
        player1.addBJCard(giveCard());
        player2.addBJCard(giveCard());
        player1.addBJCard(giveCard());
        player2.addBJCard(giveCard());
    }

}
