package example.codeclan.com.cardgame;

/**
 * Created by user on 20/01/2017.
 */

public class WarCard {

    private WarCardName name;
    private WarCardSuit suit;
    private int value;

    public WarCard(WarCardName name, WarCardSuit suit) {
        this.name = name;
        this.suit = suit;
        this.value = 0;
        this.setValue();
    }

    public WarCardName getName() {
        return name;
    }

    public WarCardSuit getSuit() {
        return suit;
    }

    public int getValue() {
        return this.value;
    }

    private void setValue() {
        if (this.name == WarCardName.SEVEN) {
            value = 7;
        }
        if (this.name == WarCardName.EIGHT) {
            value = 8;
        }
        if (this.name == WarCardName.NINE) {
            value = 9;
        }
        if (this.name == WarCardName.TEN) {
            value = 10;
        }
        if (this.name == WarCardName.LOWER) {
            value = 11;
        }
        if (this.name == WarCardName.UPPER) {
            value = 12;
        }
        if (this.name == WarCardName.KING) {
            value = 13;
        }
        if (this.name == WarCardName.ACE) {
            value = 14;
        }
    }

    @Override
    public String toString() {
        return name + "of" + suit;
    }

}
