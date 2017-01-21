package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 20/01/2017.
 */
public class WPlayerTest {

    WPlayer player;
    WCard card;

    @Before
    public void before() {
        player = new WPlayer("Peter");
        card = new WCard(WCardName.NINE, WCardSuit.PUMPKIN);
    }

    @Test
    public void canGetCard() {
        player.addCard(card);
        assertEquals(1, player.cardCount());
    }

    @Test
    public void canPlayerRemoveCard() {
        player.addCard(card);
        player.giveCard();
        assertEquals(0, player.cardCount());
    }

}