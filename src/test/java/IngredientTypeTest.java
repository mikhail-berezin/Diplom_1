import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    public IngredientType type;
    private final String name;

    public IngredientTypeTest(IngredientType type, String name) {
        this.type = type;
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] getFelineData() {
        return new Object[][] {
                { SAUCE, "SAUCE" },
                { FILLING, "FILLING" }
        };
    }

    @Test
    public void toStringTest() {
        String nameValue = type.toString();
        assertEquals(nameValue, name);
    }
}
