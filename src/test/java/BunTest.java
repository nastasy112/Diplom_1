import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    @Spy
    Bun bun = new Bun("Стандартная", 50.0f);

    // Готово. Мок нужен, тк есть зависимость от конструктора Bun
    @Test
    public void getNameReturnsCorrectValue(){
        String expectedName = "Стандартная";

        String actualName = bun.getName();

        Assert.assertEquals("Method getName return incorrect value.", expectedName, actualName );
    }

    // Готово. Мок нужен, тк есть зависимость от конструктора Bun
    @Test
    public void getPriceReturnsCorrectValue(){
        float expectedPrice = 50.0f;

        float actualPrice = bun.getPrice();

        Assert.assertEquals("Method getPrice return incorrect value.", expectedPrice, actualPrice, 0.0);
    }
}
