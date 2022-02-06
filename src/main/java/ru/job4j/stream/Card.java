package ru.job4j.stream;

import java.util.stream.Stream;

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

enum Value {
    V_6, V_7, V_8
}

class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit="
                + suit
                + ", value="
                + value
                + '}';
    }

    public static void main(String[] args) {
        Stream.of(Value.values())
                .flatMap(suit -> Stream.of(Suit.values())
                        .map(value -> new Card(value, suit)))
                .forEach(System.out::println);
    }
}