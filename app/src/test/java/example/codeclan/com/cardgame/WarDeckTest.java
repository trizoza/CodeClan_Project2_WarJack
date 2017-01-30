package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */
public class WarDeckTest {

    WarDeck deck;
    Player player1;
    Player player2;

    @Before
    public void before() {
        deck = new WarDeck();
        player1 = new Player("Peter");
        player2 = new Player("Kamila");
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