package fr.logic;

public enum DrinkType {
    TEA("T"),
    COFFEE("C"),
    CHOCOLATE("H");

    public final String value;

    DrinkType(String value) {
        this.value = value;
    }
}