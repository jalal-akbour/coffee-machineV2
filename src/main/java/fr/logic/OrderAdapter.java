package fr.logic;

import maker.DrinkMaker;

public class OrderAdapter {
    public static final String SEPARATOR = ":";

    private DrinkMaker drinkMaker;

    public String translate(Order order) {
        StringBuilder translatedOrder = new StringBuilder();

        if (order != null) {
            DrinkType drinkType = order.getDrinkType();
            int nbSugar = order.getNbSugar();

            translatedOrder.append(drinkType.value);
            translatedOrder.append(SEPARATOR);
            if (nbSugar > 0) {
                translatedOrder.append(nbSugar);
                translatedOrder.append(SEPARATOR);
                translatedOrder.append("0");
            } else {
                translatedOrder.append(SEPARATOR);
            }
        }
        return translatedOrder.toString();
    }

    public void checkOrderAndSentCommandToMaker(Order order) {
        String translatedOrder = translate(order);
        if (!translatedOrder.isEmpty()) {
            sendOrderToMaker(translatedOrder);
        }
    }

    private void sendOrderToMaker(String command) {
        drinkMaker.make(command);
    }
}
