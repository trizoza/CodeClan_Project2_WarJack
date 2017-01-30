package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 22/01/2017.
 */
public class BlackJackCardTest {

    BlackJackCard card;

    @Before
    public void before() {
        card = new BlackJackCard(BlackJackCardName.SEVEN, BlackJackCardSuit.DIAMOND);
    }

    @Test
    public void canGetValue() {
        assertEquals(7, card.getValue());
    }

    @Test
    public void canGetName() {
        assertEquals(BlackJackCardName.SEVEN, card.getName());
    }

    @Test
    public void canGetSuit() {
        assertEquals(BlackJackCardSuit.DIAMOND, card.getSuit());
    }

    @Test
    public void canGetDiffCard() {
        BlackJackCard diffCard = new BlackJackCard(BlackJackCardName.ACE, BlackJackCardSuit.HEART);
        assertEquals(11, diffCard.getValue());
        assertEquals(BlackJackCardName.ACE, diffCard.getName());
        assertEquals(BlackJackCardSuit.HEART, diffCard.getSuit());
    }

    @Test
    public void canGetString() {
        assertEquals("SEVEN of DIAMOND", card.toString());
    }

    @Test
    public void canSetAceValueToOne() {
        BlackJackCard diffCard = new BlackJackCard(BlackJackCardName.ACE, BlackJackCardSuit.HEART);
        assertEquals(11, diffCard.getValue());
        diffCard.setAceValue(1);
        assertEquals(1, diffCard.getValue());
        diffCard.setAceValue(3);
        assertEquals(3, diffCard.getValue());
    }

}