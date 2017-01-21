package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */
public class WDeckTest {

    WDeck deck;

    @Before
    public void before() {
        deck = new WDeck();
    }

    @Test
    public void canSetUpDeck() {
        assertEquals(32, deck.cardCount());
    }

    @Test
    public void canGiveCard() {
        deck.giveCard();
        assertEquals(31, deck.cardCount());
    }

}