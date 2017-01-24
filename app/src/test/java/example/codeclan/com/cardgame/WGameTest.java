package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */

public class WGameTest {

    WGame game;

    @Before
    public void before() {
        game = new WGame();
    }

    @Test
    public void canSetupGame() {
        assertEquals(2, game.numOfPlayers());
        assertEquals(16, game.getPlayers().get(0).cardCount());
        assertEquals(16, game.getPlayers().get(1).cardCount());
        assertEquals(0, game.getDeck().cardCount());
        assertEquals(0, game.getTable().cardCountOnTable());
        assertEquals(0, game.getTable().cardCountOnSide());
        assertEquals("Player", game.getPlayers().get(0).getName());
        assertEquals("Android", game.getPlayers().get(1).getName());
    }

}