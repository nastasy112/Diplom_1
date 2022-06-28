import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Database;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {

    Bun bun = new Bun("black bun", 100);
    Bun bun2 = new Bun("white bun", 200);
    Bun bun3 = new Bun("red bun", 300);

    @Test
    public void availableBunsReturnsCorrectValue(){
        Database database = new Database();
        List<Bun> expectedAvailableBuns = List.of(bun, bun2, bun3);

        List<Bun> actualAvailableBuns = database.availableBuns();

        Assert.assertEquals("Method availableBuns return incorrect value.", expectedAvailableBuns, actualAvailableBuns );
    }

}
