package chapter_6;


import common_code.model.Dish;
import common_code.model.Menu;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;


public class Main {

    public enum CaloriesLevel {DIET, NORMAL, FAT}

    ;

    private final static boolean SHOULD_BE_PRINTED = true;
    private final static boolean SHOULD_NOT_BE_PRINTED = false;

    private static Random random;
    private static List<String> dishesName = Arrays.asList("Salmon", "hamburger", "pizza", "salad Cesar", "sushi");
    private static List<String> dishesUsed;

    public static void main(String[] args) {

        Main main = new Main();
        List<Dish> menu = Menu.generateMenu();

        example1(SHOULD_NOT_BE_PRINTED, menu);

        main.example2(SHOULD_BE_PRINTED, menu);

        Map<Boolean, List<Integer>> lol = main.example3(SHOULD_BE_PRINTED,33);

    }

    private Map<Boolean, List<Integer>>example3(boolean shouldBePrinted, int i) {

        return IntStream.rangeClosed(2,i).boxed()
                .collect(partitioningBy(this::isPrime));

    }

    private boolean isPrime(int candidate){
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate %i == 0);

    }

    private void example2(boolean shouldBePrinted, List<Dish> menu) {
        //Example of grouping..
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                .collect(groupingBy(Dish::getType));

        System.out.println("Example og groupingBy");
        System.out.println(dishesByType);

        //Example of multilevel grouping
        System.out.println("\nExample of multilevel groupingBy");

        Map<Dish.Type, Map<CaloriesLevel, List<Dish>>> dishesByTypeCalorieLevel =
                menu.stream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloriesLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloriesLevel.NORMAL;
                    else return CaloriesLevel.FAT;
                })));

        System.out.println(dishesByTypeCalorieLevel);

        //Example of grouping using other Collectors methods.
        System.out.println("\nExample of grouping using other Collectors methods");

        Map<Dish.Type, Optional<Dish>> mostCaloriesByType =
                menu.stream().collect(groupingBy(Dish::getType, maxBy(comparing(Dish::getCalories))));
        System.out.println(mostCaloriesByType);

        //Example similar to the above but since the use of Optimal is irrelevant we prefer to return dish instead.
        System.out.println("\nExample similar to the above but without Optional");

        Map<Dish.Type, Dish> mostCaloriesByType2 =
                menu.stream().collect(groupingBy(Dish::getType,
                        collectingAndThen(
                        maxBy(comparingInt(Dish::getCalories)),Optional::get)
                ));

        System.out.println(mostCaloriesByType2);

        //Example using collect to get the total amount of calories per type
        System.out.println("\nExample to find the total amount of calories per dish type");

        Map<Dish.Type,Integer> totalCaloriesPerType =
                menu.stream()
                .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));

        System.out.println(totalCaloriesPerType);

        //Example to check the calories level there are in the menu
        System.out.println("\nExample to show the calories level by dish type");

        Map<Dish.Type,Set<CaloriesLevel>> caloriesLevelByType =
                menu.stream()
                .collect(groupingBy(Dish::getType,mapping(dish -> {
                    if (dish.getCalories()<= 400) return CaloriesLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloriesLevel.NORMAL;
                    else return CaloriesLevel.FAT;
                }, toSet())));

        System.out.println(caloriesLevelByType);

        //Example to separate the menu such as it display the dishes that are vegetarian or not.
        System.out.println("\nExample separate list to vegetarian or not");

        Map<Boolean,List<Dish>> portionedMenu =
                menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));

        System.out.println(portionedMenu);

        //Example to show partitioningBy
        System.out.println("\nExample of partitioningBy");
        Map<Boolean, Long> counting =
                menu.stream()
                .collect(partitioningBy(Dish::isVegetarian,counting()));

    }


    /**
     * These are example using collect as a summation
     *
     * @param shouldBePrint
     */
    public static void example1(boolean shouldBePrint, List<Dish> menu) {
        if (shouldBePrint) {

            // This shows how summarizingInt return a statistic of dishes base on their calories
            IntSummaryStatistics menuStatistic = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));

            System.out.println("Example of summarizingInt");
            System.out.println(menuStatistic);

            //counting the number of dishes in the menu
            int nroOfDishes = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
            System.out.println("\n Example of summingInt");
            System.out.println(nroOfDishes);

            //counting the number of dishes in the menu using Collectors.reducing
            int reducingDishes = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
            System.out.println("\n Example of reducing");
            System.out.println(reducingDishes);

        }
    }

}
