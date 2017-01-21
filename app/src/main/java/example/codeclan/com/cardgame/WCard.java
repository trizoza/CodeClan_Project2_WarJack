package example.codeclan.com.cardgame;

/**
 * Created by user on 20/01/2017.
 */

public class WCard {

    private WCardName name;
    private WCardSuit suit;
    private int value;

    public WCard(WCardName name, WCardSuit suit) {
        this.name = name;
        this.suit = suit;
        this.value = 0;
        this.setValue();
    }

    public WCardName getName() {
        return name;
    }

    public WCardSuit getSuit() {
        return suit;
    }

    public int getValue() {
        return this.value;
    }

    private void setValue() {
        if (this.name == WCardName.SEVEN) {
            value = 7;
        }
        if (this.name == WCardName.EIGHT) {
            value = 8;
        }
        if (this.name == WCardName.NINE) {
            value = 9;
        }
        if (this.name == WCardName.TEN) {
            value = 10;
        }
        if (this.name == WCardName.LOWER) {
            value = 11;
        }
        if (this.name == WCardName.UPPER) {
            value = 12;
        }
        if (this.name == WCardName.KING) {
            value = 13;
        }
        if (this.name == WCardName.ACE) {
            value = 14;
        }
    }

}
