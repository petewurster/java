package com.pw2;

import java.util.Random;

public class Main {
    public static Random rnd = new Random();

    public static void main(String[] args) {
        Deck deck = new Deck();
        Card aaa = deck.popCard();

        System.out.println("you drew the " + aaa);


//        //prints all cards
//        for(int x = 0; x < deck.getSize(); x++) {
//            System.out.println(deck.getCard(x));
//        }




    }
}
