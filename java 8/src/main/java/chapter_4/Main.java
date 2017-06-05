package chapter_4;

import common_code.model.Dish;
import common_code.model.Menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Dish> menu = Menu.generateMenu();

        //Example 1 - showing how stream word in general
        List<String> threeHighCaloriesDishNames = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());

        /*
        * Function descriptors of some intermediate function in stream API
        *
        * filter: T -> boolean
        * map: T -> R
        * sorted: (T,T) -> int
        *
         */
        System.out.println(threeHighCaloriesDishNames);
    }

}
