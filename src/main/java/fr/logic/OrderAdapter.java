package fr.logic;

import maker.DrinkMaker;
import java.util.Objects;

public class OrderAdapter {
    public static final String SEPARATOR = ":";

    private DrinkMaker drinkMaker;

    public String translate(Order order) {
        StringBuilder translatedOrder = new StringBuilder();

        if (order != null) {
            DrinkType drinkType = order.getDrinkType();
            int nbSugar = order.getNbSugar();

            translatedOrder.append(drinkType.value);
            if (drinkType.canBeExtraHot && order.isHotDrink()) {
                translatedOrder.append("h");
            }
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
        if (!Objects.isNull(order) && isValidAmount(order.getDrinkType(), order.getGivingMoney()) && !translatedOrder.isEmpty()) {
            sendOrderToMaker(translatedOrder);
        }
    }

    private void sendOrderToMaker(String command) {
        drinkMaker.make(command);
    }

    private void sendMessageToMaker(String message) {
        drinkMaker.make("M:" + message);
    }

    private double calculateMissingAmount(DrinkType drinkType, double givingMoney) {
        return (drinkType.price * 100 - givingMoney * 100) / 100;
    }

    private boolean isValidAmount(DrinkType drinkType, double givingMoney) {
        double missingAmount = calculateMissingAmount(drinkType, givingMoney);

        if (missingAmount > 0) {
            String orderMsg = "You must add " + missingAmount + " euro";

            sendMessageToMaker(orderMsg);
            return false;
        }
        return true;
    }
}
