package hello;

import java.util.List;

public class Game {
    private Player dealer;
    private Player player;
    private Deck deck;

    public List<Card> getPlayerCards() {
        return player.getCards();
    }

    public List<Card> getDealerCards() {
        return dealer.getCards();
    }

    public Card getFirstDealerCard() {
        return dealer.getCard(0);
    }

    Game() {
        dealer = new Player();
        player = new Player();
    }

    public int getPlayerScore() {
        return player.getScore();
    }

    public int getDealerScore() {
        return dealer.getScore();
    }

    public int init() {
        System.out.println("----------------NEW GAME-------------------");
        deck = new Deck();
        deck.shuffle();
        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        player.addCard(deck.dealCard());

        System.out.println("dealer has: [" + dealer.getCard(0) + dealer.getCard(1));
        System.out.println("you have: " + player.getScore() + " " + player.getCards());

        if (player.getScore() == 21) {
            return 1;
        }

        if (dealer.getScore() == 21) {
            System.out.println("dealer wins with " + dealer.getCards());
            return -1;
        }
        return 0;
    }

    boolean playerStage() {

        Card card = deck.dealCard();
        player.addCard(card);
        System.out.println("new card: " + card);
        System.out.println("you have " + player.getScore() + player.getCards());
        if (player.getScore() > 21) {
            System.out.println("busted!");
            return false;

        }
        return true;
    }

    boolean dealerStage() {
        System.out.println("dealer's turn");
        System.out.println("dealer has " + dealer.getScore() + dealer.getCards());

        while (dealer.getScore() < 17) {
            Card card = deck.dealCard();
            dealer.addCard(card);
            System.out.println("dealer draws card " + card + " having a total of: " + dealer.getScore());
            if (dealer.getScore() > 21) {
                System.out.println("you win, dealer has " + dealer.getScore());
                return false;
            }
        }
        return true;
    }

    int getResult() {
        int diff = player.getScore() - dealer.getScore();
        if (diff > 0) {
            System.out.println("you win with " + player.getScore());
            return 1;
        } else if (diff < 0) {
            System.out.println("dealer wins with " + dealer.getScore());
            return -1;
        } else {
            System.out.println("draw");
            return 0;
        }
    }
}
