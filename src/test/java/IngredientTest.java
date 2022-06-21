import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    @Spy
    Ingredient ingredient = new Ingredient(FILLING, "Сыр",15.0f);

    // Готово. Мок нужен, тк есть зависимость от конструктора Ingredient и класса IngredientType
    @Test
    public void getPriceReturnsCorrectValue(){
        float expectedPrice = 15.0f;

        float actualPrice = ingredient.getPrice();

        Assert.assertEquals("Method getPrice return incorrect value.", expectedPrice, actualPrice, 0.0);
    }

    // Готово. Мок нужен, тк есть зависимость от конструктора Ingredient и класса IngredientType
    @Test
    public void getNameReturnsCorrectValue(){
        String expectedName = "Сыр";

        String actualName = ingredient.getName();

        Assert.assertEquals("Method getName return incorrect value.", expectedName, actualName);
    }

    // Готово. Мок нужен, тк есть зависимость от конструктора Ingredient и класса IngredientType
    @Test
    public void getTypeReturnsCorrectValue(){
        IngredientType expectedType = FILLING;

        IngredientType actualType = ingredient.getType();

        Assert.assertEquals("Method getType return incorrect value.", expectedType, actualType);
    }
}
