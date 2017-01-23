package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 22/01/2017.
 */
public class BJDeckTest {

    BJDeck deck;
    Player player1;
    Player player2;

    @Before
    public void before() {
        deck = new BJDeck();
        player1 = new Player("Peter");
        player2 = new Player("Kamila");
    }

    @Test
    public void canSetUpDeck() {
        assertEquals(52, deck.cardCount());
    }

    @Test
    public void canGiveCard() {
        deck.giveCard();
        assertEquals(51, deck.cardCount());
    }

    @Test
    public void canDealCard() {
        deck.dealCard(player1);
        assertEquals(51, deck.cardCount());
        assertEquals(1, player1.bjCardCount());
    }

    @Test
    public void canDeckDistrubuteCards() {
        deck.distributeCards(player1, player2);
        assertEquals(48, deck.cardCount());
        assertEquals(2, player1.bjCardCount());
        assertEquals(2, player2.bjCardCount());
    }

    @Test
    public void canGetCard() {
        BJCard card =  deck.getCard();
        assertNotNull(card.getValue());
    }
}