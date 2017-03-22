package hello;

public class Deck {

    private Card[] deck;
    private int cardsUsed;

    public Deck() {
        deck = new Card[52];
        int cardCount = 0;
        for (int suit = 0; suit < 4; suit++) {
            for (int value = 1; value < 14; value++) {
                deck[cardCount] = new Card(value, suit);
                cardCount++;
            }
        }

    }

    public void shuffle() {
        for (int i = 51; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsUsed = 0;
    }

    public Card dealCard() {
        if (cardsUsed == 52) {
            System.out.println("no more cards");
            return null;
        }
        cardsUsed++;
        return deck[cardsUsed - 1];
    }

}