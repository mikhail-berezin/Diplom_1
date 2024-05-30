import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static constants.TestConstants.PRICE_DELTA;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getFelineData() {
        return new Object[][] {
                { "Пшеничная", 10.0f },
                { "Ржаная", 8.0f }
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        String nameValue = bun.getName();
        assertEquals(nameValue, name);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        float priceValue = bun.getPrice();
        assertEquals(priceValue, price, PRICE_DELTA);
    }
}
