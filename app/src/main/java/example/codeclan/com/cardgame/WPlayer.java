package example.codeclan.com.cardgame;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by user on 20/01/2017.
 */

public class WPlayer {

    private String name;
    private CopyOnWriteArrayList<WCard> hand;

    public WPlayer(String name) {
        this.name = name;
        this.hand = new CopyOnWriteArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addCard(WCard card) {
        hand.add(card);
    }

    public WCard giveCard() {
        return hand.remove(0);
    }

    public int cardCount(){
        return hand.size();
    }

}

