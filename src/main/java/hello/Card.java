package hello;


public class Card {
    private final static int SPADES = 0,
            HEARTS = 1,
            DIAMONDS = 2,
            CLUBS = 3;


    private final int suit;    //    SPADES, HEARTS, DIAMONDS, CLUBS.

    private final int rank;  //  from 1 to 11

    /**
     * @param val  valori intre 1 si 13
     * @param suit valori intre 0 si 3
     **/
    public Card(int val, int suit) {
        rank = val;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuitAsString() {
        switch (suit) {
            case SPADES:
                return "Spades";
            case HEARTS:
                return "Hearts";
            case DIAMONDS:
                return "Diamonds";
            case CLUBS:
                return "Clubs";
            default:
                return "noSuit";
        }
    }

    public String getValueAsString() {
        switch (rank) {
            case 1:
                return "A";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return "noValue";
        }
    }

    public String toString() {
        return getValueAsString() + " of " + getSuitAsString();
    }


}