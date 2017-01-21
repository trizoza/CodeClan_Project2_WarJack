package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */
public class WTableTest {

    WTable table;
    WPlayer player;
    WCard card1;
    WCard card2;
    WCard card3;

    @Before
    public void before() {
        table = new WTable();
        player = new WPlayer("Peter");
        card1 = new WCard(WCardName.ACE, WCardSuit.GREEN);
        card2 = new WCard(WCardName.KING, WCardSuit.RED);
        card3 = new WCard(WCardName.UPPER, WCardSuit.NUT);
        table.addCardToTable(card1);
        table.addCardToTable(card2);
        table.addCardToTable(card3);
    }

    @Test
    public void canAddCardToTable() {
        assertEquals(3, table.cardCountOnTable());
        assertEquals(0, table.cardCountOnSide());
    }

    @Test
    public void canMoveCardsAside() {
        table.moveCardsAside();
        assertEquals(0, table.cardCountOnTable());
        assertEquals(3, table.cardCountOnSide());
    }

    @Test
    public void canGiveCardsToPlayer() {
        table.moveCardsAside();
        table.giveSideCardsToPlayer(player);
        assertEquals(0, table.cardCountOnTable());
        assertEquals(0, table.cardCountOnSide());
        assertEquals(3, player.cardCount());
    }

}