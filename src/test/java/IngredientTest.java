import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static constants.TestConstants.PRICE_DELTA;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    public IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getFelineData() {
        return new Object[][]{
                { SAUCE, "Кетчуп", 20.0f },
                { FILLING, "Котлета", 80.0f }
        };
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType typeValue = ingredient.getType();

        assertEquals(typeValue, type);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String nameValue = ingredient.getName();

        assertEquals(nameValue, name);
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float priceValue = ingredient.getPrice();

        assertEquals(priceValue, price, PRICE_DELTA);
    }
}
