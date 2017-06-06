package factory_pattern;

/**
 * Created by guillermo on 06/06/17.
 * change! factory_pattern
 */
public abstract class PizzaStore {

    public Pizza orderingPizza(String type) {

        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;

    }


    public abstract Pizza createPizza(String type);
}
