package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 20/01/2017.
 */
public class PlayerTest {

    Player player;
    WarCard wCard;
    BlackJackCard bjCard;

    @Before
    public void before() {
        player = new Player("Peter");
        wCard = new WarCard(WarCardName.NINE, WarCardSuit.PUMPKIN);
        bjCard = new BlackJackCard(BlackJackCardName.KING, BlackJackCardSuit.CLUB);

    }

    ////// WAR TESTS ///////////////////////////

    @Test
    public void canGetCard() {
        player.addCard(wCard);
        assertEquals(1, player.cardCount());
    }

    @Test
    public void canPlayerRemoveCard() {
        player.addCard(wCard);
        player.giveCard();
        assertEquals(0, player.cardCount());
    }

    ////// BJ TESTS ///////////////////////////

    @Test
    public void canGetBJCard() {
        player.addBJCard(bjCard);
        assertEquals(1, player.bjCardCount());
    }

    @Test
    public void canPlayerRemoveBJCard() {
        player.addBJCard(bjCard);
        player.giveBJCard();
        assertEquals(0, player.bjCardCount());
    }

    @Test
    public void canGetBJHand() {
        player.addBJCard(bjCard);
        assertEquals(10, player.getBJHand().get(0).getValue());
    }

    @Test
    public void canGetValueOfEmptyHand() {
        assertEquals(0, player.getValueOfHand());
    }

    @Test
    public void canGetValueOfHand() {
        player.addBJCard(bjCard);
        assertEquals(10, player.getValueOfHand());
    }

}