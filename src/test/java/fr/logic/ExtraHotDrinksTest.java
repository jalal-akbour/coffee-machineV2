package fr.logic;

import maker.DrinkMaker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExtraHotDrinksTest {

    private final Order order = new Order();
    @InjectMocks
    private OrderAdapter orderAdapter = new OrderAdapter();
    @Mock
    DrinkMaker drinkMaker;

    @Test
    public void should_returnStringCommand_O_when_NotExtraHotOrangeOrder() {
        //Given
        order.setDrinkType(DrinkType.ORANGE);
        order.setNbSugar(0);
        order.setGivingMoney(0.6);
        order.setHotDrink(false);

        //When
        String translatedOrder = orderAdapter.translate(order);

        //Then
        Assert.assertEquals("O::", translatedOrder);
    }

    @Test
    public void should_returnStringCommand_Ch_when_extraHotCoffeeOrder() {
        //Given
        order.setDrinkType(DrinkType.COFFEE);
        order.setNbSugar(0);
        order.setHotDrink(true);

        //When
        String translatedOrder = orderAdapter.translate(order);

        //Then
        Assert.assertEquals("Ch::", translatedOrder);
    }

    @Test
    public void should_returnStringCommand_Hh_1_0_when_extraHotChocolateWithOneSugarOrder() {
        //Given
        order.setDrinkType(DrinkType.CHOCOLATE);
        order.setNbSugar(1);
        order.setHotDrink(true);

        //When
        String translatedOrder = orderAdapter.translate(order);

        //Then
        Assert.assertEquals("Hh:1:0", translatedOrder);
    }

    @Test
    public void should_returnStringCommand_Th_2_0_when_extraHotTeaWithTwoSugarsOrder() {
        //Given
        order.setDrinkType(DrinkType.TEA);
        order.setNbSugar(2);
        order.setHotDrink(true);

        //When
        String translatedOrder = orderAdapter.translate(order);

        //Then
        Assert.assertEquals("Th:2:0", translatedOrder);
    }

    @Test
    public void should_returnStringCommand_O_when_extraHotOrangeOrder() {
        //Given
        order.setDrinkType(DrinkType.ORANGE);
        order.setNbSugar(0);
        order.setGivingMoney(0.6);
        order.setHotDrink(true);

        //When
        String translatedOrder = orderAdapter.translate(order);

        //Then
        Assert.assertEquals("O::", translatedOrder);
    }

    @Test
    public void should_returnStringCommand_L_when_extraHotLemonOrder() {
        //Given
        order.setDrinkType(DrinkType.LEMON);
        order.setNbSugar(0);
        order.setGivingMoney(0.6);
        order.setHotDrink(true);

        //When
        String translatedOrder = orderAdapter.translate(order);

        //Then
        Assert.assertEquals("L::", translatedOrder);
    }

    @Test
    public void should_returnStringCommand_T_when_extraHotTomatoOrder() {
        //Given
        order.setDrinkType(DrinkType.TOMATO);
        order.setNbSugar(0);
        order.setGivingMoney(0.6);
        order.setHotDrink(true);

        //When
        String translatedOrder = orderAdapter.translate(order);

        //Then
        Assert.assertEquals("T::", translatedOrder);
    }

}
