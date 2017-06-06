package factory_pattern;

/**
 * Created by guillermo on 06/06/17.
 * change! factory_pattern
 */
public class Pizza {

    private String pizzaName;

    public Pizza(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public void prepare() {
        System.out.println("Preparing pizza " + toString());
    }

    public void bake() {
        System.out.println("baking");
    }

    public void cut() {
        System.out.println("cutting");
    }

    public void box() {
        System.out.println("boxing pizza " + toString());
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaName='" + pizzaName + '\'' +
                '}';
    }

    class FrozenPizza {

    }
}
