package com.pw2;

public class Card {

    static enum Suits {Hearts, Clubs, Spades, Diamonds};
    static enum Vals {Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King};

    final private Suits suit;
    final private Vals val;

    Card(Suits suit, Vals val) {
        this.suit = suit;
        this.val = val;
    }

    public String toString() {
        return this.val.toString() + " of " + this.suit.toString();
    }



}
