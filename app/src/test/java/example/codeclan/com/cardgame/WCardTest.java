package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 20/01/2017.
 */
public class WCardTest {

    WCard card;

    @Before
    public void before() {
        card = new WCard(WCardName.SEVEN, WCardSuit.NUT);
    }

    @Test
    public void canGetValue() {
        assertEquals(7, card.getValue());
    }

    @Test
    public void canGetName() {
        assertEquals(WCardName.SEVEN, card.getName());
    }

    @Test
    public void canGetSuit() {
        assertEquals(WCardSuit.NUT, card.getSuit());
    }


}