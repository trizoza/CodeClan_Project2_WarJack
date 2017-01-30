package example.codeclan.com.cardgame;

/**
 * Created by user on 22/01/2017.
 */

public class BlackJackCard {

    private BlackJackCardName name;
    private BlackJackCardSuit suit;
    private int value;

    public BlackJackCard(BlackJackCardName name, BlackJackCardSuit suit) {
        this.name = name;
        this.suit = suit;
        this.value = 0;
        this.setValue();
    }

    public BlackJackCardName getName() {
        return name;
    }

    public BlackJackCardSuit getSuit() {
        return suit;
    }

    public int getValue() {
        return this.value;
    }

    private void setValue() {
        if (this.name == BlackJackCardName.TWO) {
            value = 2;
        }
        if (this.name == BlackJackCardName.THREE) {
            value = 3;
        }
        if (this.name == BlackJackCardName.FOUR) {
            value = 4;
        }
        if (this.name == BlackJackCardName.FIVE) {
            value = 5;
        }
        if (this.name == BlackJackCardName.SIX) {
            value = 6;
        }
        if (this.name == BlackJackCardName.SEVEN) {
            value = 7;
        }
        if (this.name == BlackJackCardName.EIGHT) {
            value = 8;
        }
        if (this.name == BlackJackCardName.NINE) {
            value = 9;
        }
        if (this.name == BlackJackCardName.TEN) {
            value = 10;
        }
        if (this.name == BlackJackCardName.JACK) {
            value = 10;
        }
        if (this.name == BlackJackCardName.QUEEN) {
            value = 10;
        }
        if (this.name == BlackJackCardName.KING) {
            value = 10;
        }
        if (this.name == BlackJackCardName.ACE) {
            value = 11;
        }
    }

    public void setAceValue(int num) {
        this.value = num;
    }

    @Override
    public String toString() {
        return name + "of" + suit;
    }

}
