import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static constants.TestConstants.CORRECT_RECEIPT;
import static constants.TestConstants.PRICE_DELTA;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockitoTest {

    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient firstIngredient;

    @Mock
    Ingredient secondIngredient;

    @Before
    public void initBurger() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
    }

    @Test
    public void getPriceTest() {

        Mockito.when(bun.getPrice()).thenReturn(10.0f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(15.0f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(50.0f);

        float burgerPrice = burger.getPrice();
        assertEquals(85.0f, burgerPrice, PRICE_DELTA);
    }

    @Test
    public void getReceiptTest() {

        Mockito.when(bun.getName()).thenReturn("Пшеничная булочка");
        Mockito.when(bun.getPrice()).thenReturn(10.0f);
        Mockito.when(firstIngredient.getType()).thenReturn(SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn("Горчичный соус");
        Mockito.when(firstIngredient.getPrice()).thenReturn(15.0f);
        Mockito.when(secondIngredient.getType()).thenReturn(FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn("Говяжья котлета");
        Mockito.when(secondIngredient.getPrice()).thenReturn(50.0f);

        String receipt = burger.getReceipt();

        assertEquals(CORRECT_RECEIPT, receipt);
    }
}