package example.codeclan.com.cardgame;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by user on 22/01/2017.
 */

public class BlackJackDeck {

    private CopyOnWriteArrayList<BlackJackCard> pile;

    public BlackJackDeck() {
        this.pile = new CopyOnWriteArrayList<>();
        this.setupDeck();
    }

    public void addCard(BlackJackCard card) {
        pile.add(card);
    }

    public BlackJackCard giveCard() {
        return pile.remove(0);
    }

    public BlackJackCard getCard() {
        return pile.get(0);
    }

    public void setupDeck() {
        for (BlackJackCardName name : BlackJackCardName.values()) {
            for (BlackJackCardSuit suit : BlackJackCardSuit.values()) {
                BlackJackCard card = new BlackJackCard(name, suit);
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
