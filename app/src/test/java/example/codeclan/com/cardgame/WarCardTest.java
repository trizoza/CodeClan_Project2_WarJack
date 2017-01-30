package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 20/01/2017.
 */
public class WarCardTest {

    WarCard card;

    @Before
    public void before() {
        card = new WarCard(WarCardName.SEVEN, WarCardSuit.NUT);
    }

    @Test
    public void canGetValue() {
        assertEquals(7, card.getValue());
    }

    @Test
    public void canGetName() {
        assertEquals(WarCardName.SEVEN, card.getName());
    }

    @Test
    public void canGetSuit() {
        assertEquals(WarCardSuit.NUT, card.getSuit());
    }

    @Test
    public void canGetDiffCard() {
        WarCard diffCard = new WarCard(WarCardName.ACE, WarCardSuit.GREEN);
        assertEquals(14, diffCard.getValue());
        assertEquals(WarCardName.ACE, diffCard.getName());
        assertEquals(WarCardSuit.GREEN, diffCard.getSuit());
    }

    @Test
    public void canGetString() {
        assertEquals("SEVEN of NUT", card.toString());
    }

}