package Decorator_pattern;


public class StartBuzzMain {


    public static void main(String[] args) {

        Beverage beverage = new DarkRoast();
        beverage = new Mocha(beverage);
        beverage = new Soy(beverage);
        beverage = new Whip(beverage);


        System.out.println(beverage.cost());
        System.out.println(beverage.getDescription());
    }
}
