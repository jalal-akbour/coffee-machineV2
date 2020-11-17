package fr.logic;

public class Order {

    private DrinkType drinkType;
    private int nbSugar;
    private double givingMoney;
    private boolean isHotDrink;

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

    public double getGivingMoney() {
        return givingMoney;
    }

    public void setGivingMoney(double givingMoney) {
        this.givingMoney = givingMoney;
    }

    public boolean isHotDrink() {
        return isHotDrink;
    }

    public void setHotDrink(boolean hotDrink) {
        isHotDrink = hotDrink;
    }
}
