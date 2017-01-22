package example.codeclan.com.cardgame;

/**
 * Created by user on 22/01/2017.
 */

public class BJCard {

    private BJCardName name;
    private BJCardSuit suit;
    private int value;

    public BJCard(BJCardName name, BJCardSuit suit) {
        this.name = name;
        this.suit = suit;
        this.value = 0;
        this.setValue();
    }

    public BJCardName getName() {
        return name;
    }

    public BJCardSuit getSuit() {
        return suit;
    }

    public int getValue() {
        return this.value;
    }

    private void setValue() {
        if (this.name == BJCardName.TWO) {
            value = 2;
        }
        if (this.name == BJCardName.THREE) {
            value = 3;
        }
        if (this.name == BJCardName.FOUR) {
            value = 4;
        }
        if (this.name == BJCardName.FIVE) {
            value = 5;
        }
        if (this.name == BJCardName.SIX) {
            value = 6;
        }
        if (this.name == BJCardName.SEVEN) {
            value = 7;
        }
        if (this.name == BJCardName.EIGHT) {
            value = 8;
        }
        if (this.name == BJCardName.NINE) {
            value = 9;
        }
        if (this.name == BJCardName.TEN) {
            value = 10;
        }
        if (this.name == BJCardName.JACK) {
            value = 10;
        }
        if (this.name == BJCardName.QUEEN) {
            value = 10;
        }
        if (this.name == BJCardName.KING) {
            value = 10;
        }
        if (this.name == BJCardName.ACE) {
            value = 11;
        }
    }

    @Override
    public String toString() {
        return name + " of " + suit;
    }

}
