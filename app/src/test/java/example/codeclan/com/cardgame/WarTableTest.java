package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */
public class WarTableTest {

    WarTable table;
    Player player;
    WarCard card1;
    WarCard card2;
    WarCard card3;

    @Before
    public void before() {
        table = new WarTable();
        player = new Player("Peter");
        card1 = new WarCard(WarCardName.ACE, WarCardSuit.GREEN);
        card2 = new WarCard(WarCardName.KING, WarCardSuit.RED);
        card3 = new WarCard(WarCardName.UPPER, WarCardSuit.NUT);
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

    @Test
    public void canDistributeCardsFromSide() {
        Player dealer = new Player("Dealer");
        WarCard card4 = new WarCard(WarCardName.LOWER, WarCardSuit.RED);
        table.addCardToTable(card4);
        table.moveCardsAside();
        table.distributeCardsFromSide(player, dealer);
        assertEquals(2, player.cardCount());
        assertEquals(2, dealer.cardCount());
    }
}