package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 22/01/2017.
 */
public class BJCardTest {

    BJCard card;

    @Before
    public void before() {
        card = new BJCard(BJCardName.SEVEN, BJCardSuit.DIAMOND);
    }

    @Test
    public void canGetValue() {
        assertEquals(7, card.getValue());
    }

    @Test
    public void canGetName() {
        assertEquals(BJCardName.SEVEN, card.getName());
    }

    @Test
    public void canGetSuit() {
        assertEquals(BJCardSuit.DIAMOND, card.getSuit());
    }

    @Test
    public void canGetDiffCard() {
        BJCard diffCard = new BJCard(BJCardName.ACE, BJCardSuit.HEART);
        assertEquals(11, diffCard.getValue());
        assertEquals(BJCardName.ACE, diffCard.getName());
        assertEquals(BJCardSuit.HEART, diffCard.getSuit());
    }

    @Test
    public void canGetString() {
        assertEquals("SEVEN of DIAMOND", card.toString());
    }

}