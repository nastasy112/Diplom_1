package praktikum;

import lombok.EqualsAndHashCode;

import java.util.Objects;

/**
 * Модель булочки для бургера.
 * Булочке можно дать название и назначить цену.
 */
@EqualsAndHashCode
public class Bun {

    public String name;
    public float price;

    public Bun(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}