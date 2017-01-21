package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */
public class WDeckTest {

    WDeck deck;
    WPlayer player1;
    WPlayer player2;

    @Before
    public void before() {
        deck = new WDeck();
        player1 = new WPlayer("Peter");
        player2 = new WPlayer("Kamila");
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

    @Test
    public void canDeckDistrubuteCards() {
        deck.distributeCards(player1, player2);
        assertEquals(0, deck.cardCount());
        assertEquals(16, player1.cardCount());
        assertEquals(16, player2.cardCount());
    }

}