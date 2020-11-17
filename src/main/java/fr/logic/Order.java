package fr.logic;

public class Order {

    private DrinkType drinkType;
    private int nbSugar;

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public int getNbSugar() {
        return nbSugar;
    }

    public void setNbSugar(int nbSugar) {
        this.nbSugar = nbSugar;
    }
}
