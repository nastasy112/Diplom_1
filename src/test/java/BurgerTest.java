import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Spy
    Bun bun = new Bun("Стандартная", 50.0f);
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Кетчуп", 5.0f);
    Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Сыр", 15.0f);

    // Готово. Мок нужен, тк есть зависимость от конструктора Bun
    @Test
    public void setBunsCorrect(){
        Burger burger = new Burger();
        Bun expectedBun = bun;

        burger.setBuns(bun);
        Bun actualBun = burger.bun;

        Assert.assertEquals("Method setBuns set incorrect bun.", expectedBun, actualBun);
    }

    // Готово. Мок нужен, тк есть зависимость от класса Ingredient
    @Test
    public void checkAddIngredient(){
        Burger burger = new Burger();
        List<Ingredient> expectedIngredients = List.of(ingredient);

        burger.addIngredient(ingredient);
        List<Ingredient> actualIngredients = burger.ingredients;

        Assert.assertEquals("Method addIngredient isn't working", expectedIngredients, actualIngredients);
    }

    // Готово. Мок нужен, тк есть зависимость от класса Ingredient
    @Test
    public void checkRemoveIngredient(){
        Burger burger = new Burger();
        List<Ingredient> expectedIngredients = List.of();

        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        List<Ingredient> actualIngredients = burger.ingredients;

        Assert.assertEquals("Method removeIngredient isn't working", expectedIngredients, actualIngredients);
    }

    // Готово. Мок нужен, тк есть зависимость от класса Ingredient
    @Test
    public void checkMoveIngredient(){
        Burger burger = new Burger();
        List<Ingredient> expectedIngredients = List.of(ingredient2, ingredient);

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        List<Ingredient> actualIngredients = burger.ingredients;

        Assert.assertEquals("Method moveIngredient isn't working", expectedIngredients, actualIngredients);
    }

    // Готово. Мок нужен, тк есть зависимость от класса Bun и от класса Ingredient
    @Test
    public void  getPriceReturnCorrectValue(){
        Burger burger = new Burger();
        burger.bun = bun;
        float expectedPrice = 105.0f;

        burger.addIngredient(ingredient);
        burger.getPrice();
        float actualPrice = burger.getPrice();

        Assert.assertEquals("Method getPrice return incorrect value", expectedPrice, actualPrice, 0.0);
    }

    // Готово. Мок нужен, тк есть зависимость от класса Bun и от класса Ingredient
    @Test
    public void  getReceiptReturnCorrectValue(){
        Burger burger = new Burger();
        burger.bun = bun;
        String expectedReceipt = "(==== Стандартная ====)\r\n" +
                "= sauce Кетчуп =\r\n" +
                "= filling Сыр =\r\n" +
                "(==== Стандартная ====)\r\n" +
                "\r\n" +
                "Price: 120,000000" +
                "\r\n";

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.getReceipt();
        String actualReceipt = burger.getReceipt();

        Assert.assertEquals("Method getReceipt return incorrect value", expectedReceipt, actualReceipt);
    }
}
