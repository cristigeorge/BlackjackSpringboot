package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Player {

    private List<Card> hand;   // Cartile din mana unui jucator

    public Player() {
        // initial jucatorul are 0 carti in mana
        hand = new ArrayList<Card>();
    }

    /**
     * @return player's blackjack score
     */
    public int getScore() {
        int val = 0; // Suma valorilor cartilor din mana
        boolean ace = false;  // este true daca am un as in mana
        int cards = getCardCount();    // nr de carti

        for (int i = 0; i < cards; i++) {
            Card card = getCard(i);
            int cardVal = card.getRank();
            if (cardVal > 10) {
                cardVal = 10;
            }
            if (cardVal == 1) {
                ace = true;
            }
            val = val + cardVal;
        }


        if (ace == true && val + 10 <= 21)
            val = val + 10;

        return val;

    }


    public void addCard(Card c) {
        if (c != null)
            hand.add(c);
    }

    public int getCardCount() {
        return hand.size();
    }

    public Card getCard(int position) {
        if (position >= 0 && position < hand.size())
            return hand.get(position);
        else
            return null;
    }

    public List<Card> getCards() {
        int i = 0;
        List<Card> v = new Vector<Card>();
        while (i < hand.size()) {
            v.add(hand.get(i));
            i++;
        }
        return v;


    }


}