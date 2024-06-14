import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class BurgerParametrizedTest {

    Burger burger;

    @Before
    public void initBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        Bun bun = new Bun("Ржаная булочка", 8.0f);
        burger.setBuns(bun);
        assertEquals(burger.bun, bun);
    }

    @Test
    public void addIngredientTest() {
        Ingredient ingredient = new Ingredient(SAUCE,"Соус сладкий чили", 14.0f);
        burger.addIngredient(ingredient);
        assertEquals(getLastAddedIngredient(burger), ingredient);
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient = new Ingredient(SAUCE,"Соус барбекю", 16.0f);
        burger.addIngredient(ingredient);
        int ingredientsSize = burger.ingredients.size();
        burger.removeIngredient(ingredientsSize - 1);
        assertEquals(burger.ingredients.size(), ingredientsSize - 1);
    }

    @Test
    public void moveIngredientTest() {
        Ingredient firstIngredient = new Ingredient(SAUCE,"Майочуп", 14.5f);
        Ingredient secondIngredient = new Ingredient(SAUCE,"Кетчица", 15.6f);
        Ingredient thirdIngredient = new Ingredient(SAUCE,"Горонез", 15.4f);

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);

        burger.moveIngredient(2, 0);

        assertEquals(burger.ingredients.get(0), thirdIngredient);
        assertEquals(burger.ingredients.get(1), firstIngredient);
        assertEquals(burger.ingredients.get(2), secondIngredient);
    }

    private Ingredient getLastAddedIngredient(Burger burger) {
        int lastIngredientIndex = burger.ingredients.size() - 1;
        if (lastIngredientIndex == -1) return null;
        return burger.ingredients.get(lastIngredientIndex);
    }
}