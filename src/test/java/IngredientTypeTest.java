import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import java.util.EnumSet;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    IngredientType type;
    boolean expectedResult;

    public IngredientTypeTest(IngredientType type, boolean expectedResult) {
        this.type = type;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] checkIngredientType() {
        return new Object[][] {
                {IngredientType.SAUCE, true},
                {IngredientType.FILLING, true},
                {null, false}
        };
    }

    // Готово. Мок не нужен
    @Test
    public void IngredientTypeContainsCorrectValues() {
        boolean actualResult = EnumSet.allOf(IngredientType.class).contains(type);

        Assert.assertEquals(expectedResult, actualResult);
    }
}
