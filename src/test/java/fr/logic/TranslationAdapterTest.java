package fr.logic;

import maker.DrinkMaker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TranslationAdapterTest {

    private final Order order = new Order();
    @InjectMocks
    private OrderAdapter orderAdapter = new OrderAdapter();
    @Mock
    DrinkMaker drinkMaker;

    @Test
    public void should_returnStringCommand_T_when_translateOrderOfTeaWithoutSugar() {
        //Given
        order.setDrinkType(DrinkType.TEA);
        order.setNbSugar(0);

        //When
        String translatedOrder = orderAdapter.translate(order);

        //Then
        Assert.assertEquals("T::", translatedOrder);
    }

    @Test
    public void should_returnStringCommand_C_when_translateOrderOfCoffeeWithoutSugar() {
        //Given
        order.setDrinkType(DrinkType.COFFEE);
        order.setNbSugar(0);

        //When
        String translatedOrder = orderAdapter.translate(order);

        //Then
        Assert.assertEquals("C::", translatedOrder);
    }

    @Test
    public void should_returnStringCommand_H_when_translateOrderOfChocolateWithoutSugar() {
        //Given
        order.setDrinkType(DrinkType.CHOCOLATE);
        order.setNbSugar(0);

        //When
        String translatedOrder = orderAdapter.translate(order);

        //Then
        Assert.assertEquals("H::", translatedOrder);
    }

    @Test
    public void should_returnStringCommand_T_1_0_when_translateOrderOfTeaAndOneSugar() {
        //Given
        order.setDrinkType(DrinkType.TEA);
        order.setNbSugar(1);

        //When
        String translatedOrder = orderAdapter.translate(order);

        //Then
        Assert.assertEquals("T:1:0", translatedOrder);
    }

    @Test
    public void should_returnStringCommand_C_2_0_when_translateOrderOfCoffeeAndTwoSugar() {
        //Given
        order.setDrinkType(DrinkType.COFFEE);
        order.setNbSugar(2);

        //When
        String translatedOrder = orderAdapter.translate(order);

        //Then
        Assert.assertEquals("C:2:0", translatedOrder);
    }

    @Test
    public void should_returnStringCommand_H_1_0_when_translateOrderOfChocolateAndOneSugar() {
        //Given
        order.setDrinkType(DrinkType.CHOCOLATE);
        order.setNbSugar(1);

        //When
        String translatedOrder = orderAdapter.translate(order);

        //Then
        Assert.assertEquals("H:1:0", translatedOrder);
    }

    @Test
    public void should_returnEmptyString_when_translateNullOrder() {
        //When
        String translatedOrder = orderAdapter.translate(null);

        //Then
        Assert.assertEquals("", translatedOrder);
    }

    @Test
    public void should_sendCommandToMaker_when_notNullOrder() {
        //Given
        order.setDrinkType(DrinkType.TEA);
        order.setNbSugar(0);

        //When
        orderAdapter.checkOrderAndSentCommandToMaker(order);

        //Then
        Mockito.verify(drinkMaker).make("T::");
    }

    @Test
    public void should_notSendCommandToMaker_when_nullOrder() {
        //When
        orderAdapter.checkOrderAndSentCommandToMaker(null);

        //Then
        Mockito.verify(drinkMaker, Mockito.never()).make(Mockito.anyString());
    }
}
