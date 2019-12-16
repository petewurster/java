package com.pw2;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int size;

    Deck() {
        for(Card.Suits suit : Card.Suits.values()) {
            for(Card.Vals val : Card.Vals.values()) {
                this.cards.add(new Card(suit, val));
            }
        }
        this.size = this.cards.size();
    }

    public Card getCard(int index) {
        return this.cards.get(index);
    }

    public int getSize() {
        return this.size;
    }

    public Card popCard() {
        int x = Main.rnd.nextInt(this.size);
        Card temp = this.cards.get(x);
        this.cards.remove(x);
        this.size -= 1;
        return temp;
    }



}
