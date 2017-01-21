package example.codeclan.com.cardgame;

import java.util.ArrayList;

/**
 * Created by user on 20/01/2017.
 */

public class WPlayer {

    private String name;
    private ArrayList<WCard> hand;

    public WPlayer(String name) {
        this.name = name;
        this.hand = new ArrayList<WCard>();
    }

    public String getName() {
        return this.name;
    }

    public void addCard(WCard card) {
        hand.add(card);
    }

    public void giveCard() {
        hand.remove(0);
    }

    public int cardCount(){
        return hand.size();
    }

}

