package fr.logic;

import maker.DrinkMaker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderAmountCheckTest {

    private final Order order = new Order();
    @InjectMocks
    private OrderAdapter orderAdapter = new OrderAdapter();
    @Mock
    DrinkMaker drinkMaker;

    @Test
    public void should_notSendMessage_when_orderWihCorrectAmount() {
        //Given
        order.setDrinkType(DrinkType.TEA);
        order.setNbSugar(0);
        order.setGivingMoney(0.5);

        //When
        orderAdapter.checkOrderAndSentCommandToMaker(order);

        //Then
        Mockito.verify(drinkMaker, Mockito.never()).make( Mockito.startsWith("M:"));
    }

    @Test
    public void should_sendMessageOfMissingAmount_when_orderOfTeaAndNotEnoughMoney() {
        //Given
        order.setDrinkType(DrinkType.TEA);
        order.setNbSugar(0);
        order.setGivingMoney(0.2);

        //When
        orderAdapter.checkOrderAndSentCommandToMaker(order);

        //Then
        Mockito.verify(drinkMaker).make("M:You must add 0.2 euro");
    }

    @Test
    public void should_sendMessageOfMissingAmount_when_orderOfCoffeeAndNotEnoughMoney() {
        //Given
        order.setDrinkType(DrinkType.COFFEE);
        order.setNbSugar(0);
        order.setGivingMoney(0.5);

        //When
        orderAdapter.checkOrderAndSentCommandToMaker(order);

        //Then
        Mockito.verify(drinkMaker).make("M:You must add 0.1 euro");
    }

    @Test
    public void should_sendMessageOfMissingAmount_when_orderOfChocolateAndNotEnoughMoney() {
        //Given
        order.setDrinkType(DrinkType.CHOCOLATE);
        order.setNbSugar(0);
        order.setGivingMoney(0.1);

        //When
        orderAdapter.checkOrderAndSentCommandToMaker(order);

        //Then
        Mockito.verify(drinkMaker).make("M:You must add 0.4 euro");
    }
}
