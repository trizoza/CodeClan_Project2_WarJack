package example.codeclan.com.cardgame;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by user on 20/01/2017.
 */

public class Player {

    private String name;
    private CopyOnWriteArrayList<WCard> wHand;
    private CopyOnWriteArrayList<BJCard> bjHand;

    public Player(String name) {
        this.name = name;
        this.wHand = new CopyOnWriteArrayList<>();
        this.bjHand = new CopyOnWriteArrayList<>();

    }

    public String getName() {
        return this.name;
    }


    ///////// WAR METHODS //////////////////////////////

    public void addCard(WCard card) { wHand.add(card);
    }

    public WCard giveCard() {
        return wHand.remove(0);
    }

    public int cardCount(){
        return wHand.size();
    }

    //////// BLACK JACK METHODS ////////////////////////

    public void addBJCard(BJCard card) { bjHand.add(card); }

    public BJCard giveBJCard() { return bjHand.remove(0); }

    public int bjCardCount(){
        return bjHand.size();
    }

}

