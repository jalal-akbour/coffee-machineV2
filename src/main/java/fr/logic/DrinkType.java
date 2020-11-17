package fr.logic;

public enum DrinkType {
    TEA("T", 0.4,true),
    COFFEE("C", 0.6,true),
    CHOCOLATE("H", 0.5,true),
    ORANGE("O", 0.6,false),
    TOMATO("T", 0.6,false),
    LEMON("L", 0.6,false);

    public final String value;
    public final double price;
    public final boolean canBeExtraHot;

    DrinkType(String value, double price, boolean canBeExtraHot) {
        this.value = value;
        this.price = price;
        this.canBeExtraHot = canBeExtraHot;
    }
}