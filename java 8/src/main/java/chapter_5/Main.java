package chapter_5;

import common_code.model.Trader;
import common_code.model.Transaction;
import common_code.model.TransactionCreation;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final static boolean SHOULD_BE_PRINT = true;
    private final static boolean SHOULD_NOT_BE_PRINT = false;

    public static void main(String[] args) {

        //Map
        //testing the flatMap function on Stream API
        List<String> words = Arrays.asList("goodbye", "hello");

//        words.stream().map(word -> word.split(""))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .forEach(System.out::println);

        //Quiz 5.2 part a
        quiz1(SHOULD_NOT_BE_PRINT);

        //Quiz 5.2 part b;
        quiz2(SHOULD_NOT_BE_PRINT);

        //Put all in practice 5.5

        List<Transaction> transactions = TransactionCreation.createTransaction();
        practice1(SHOULD_NOT_BE_PRINT, transactions);

        practice2(SHOULD_NOT_BE_PRINT, transactions);

        practice3(SHOULD_NOT_BE_PRINT, transactions);

        pratice4(SHOULD_BE_PRINT, transactions);

        pratice5(SHOULD_NOT_BE_PRINT, transactions);

        pratice6(SHOULD_NOT_BE_PRINT, transactions);

        pratice7(SHOULD_NOT_BE_PRINT, transactions);

        pratice8(SHOULD_NOT_BE_PRINT, transactions);


    }

    /**
     * Find the transaction with the smallest value.
     * @param shouldBePrint
     * @param transactions
     */
    private static void pratice8(boolean shouldBePrint, List<Transaction> transactions) {

        if (shouldBePrint){
            if (shouldBePrint) {
                Optional<Transaction> lowestTransactionValue = transactions.stream()
                        .reduce((t1,t2) -> t1.getValue() < t2.getValue()?t1:t2);

                System.out.println(lowestTransactionValue.get());
            }
        }
    }

    /**
     * What’s the highest value of all the transactions?
     * @param shouldBePrint
     * @param transactions
     */
    private static void pratice7(boolean shouldBePrint, List<Transaction> transactions) {

        if (shouldBePrint) {
            Optional<Integer> highestTransactionValue = transactions.stream()
                    .map(Transaction::getValue)
                    .reduce(Integer::max);

            System.out.println(highestTransactionValue);
        }
    }

    /**
     * Print all transactions’ values from the traders living in Cambridge
     * @param shouldBePrint
     * @param transactions
     */
    private static void pratice6(boolean shouldBePrint, List<Transaction> transactions) {

        if (shouldBePrint) {
            transactions.stream()
                    .filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("cambridge"))
                    .map(Transaction::getValue)
                    .forEach(System.out::println);
        }

    }

    /**
     * Are any traders based in Milan?
     * @param shouldBePrint
     * @param transactions
     */
    private static void pratice5(boolean shouldBePrint, List<Transaction> transactions) {
        if (shouldBePrint){

            Boolean isThereATraderInMilan = transactions.stream()
                    .map(Transaction::getTrader)
                    .anyMatch(trader -> trader.getCity().equalsIgnoreCase("milan"));

            System.out.println(isThereATraderInMilan);
        }
    }

    /**
     * Return a string of all traders’ names sorted alphabetically.
     * @param shouldBePrint
     * @param transactions
     */
    private static void pratice4(boolean shouldBePrint, List<Transaction> transactions) {
        if (shouldBePrint) {
            String traders = transactions.stream()
                    .map(Transaction::getTrader)
                    .map(Trader::getName)
                    .distinct()
                    .sorted()
                    .collect(Collectors.joining());

            System.out.println(traders);
        }
    }

    /**
     * Find all traders from Cambridge and sort them by name.
     * @param shouldBePrint
     * @param transactions
     */
    private static void practice3(boolean shouldBePrint, List<Transaction> transactions) {
        if (shouldBePrint) {
            transactions.stream()
                    .map(Transaction::getTrader)
                    .filter(trader -> trader.getCity().equalsIgnoreCase("cambridge"))
                    .distinct()
                    .sorted(Comparator.comparing(Trader::getName))
                    .forEach(System.out::println);
        }
    }


    /**
     * What are all the unique cities where the traders work?
     * @param shouldBePrint
     * @param transactions
     */
    private static void practice2(boolean shouldBePrint, List<Transaction> transactions) {
        if (shouldBePrint){
            transactions.stream()
                    .map(Transaction::getTrader)
                    .map(Trader::getCity)
                    .distinct()
                    .forEach(System.out::println);
        }
    }

    /**
     * Find all transactions in the year 2011 and sort them by value (small to high).
     * @param shouldBePrint
     */
    private static void practice1(boolean shouldBePrint, List<Transaction> transactions) {
        if (shouldBePrint){
            transactions.stream()
                    .filter(transaction -> transaction.getYear() == 2011)
                    .sorted(Comparator.comparing(Transaction::getValue))
                    .forEach(System.out::println);
        }
    }

    /**
     * <strong>Quiz 5.2 part a</strong>
     *
     * Given a list of numbers, how would you return a list of the square of each number? For
     * example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25].
     *
     * @param shouldPrint
     */
    public static void quiz1(boolean shouldPrint) {
        if (shouldPrint){
            List<Integer> numbers = Arrays.asList(1,2,3,4,5);


            numbers.stream()
                    .map(number -> number * number)
                    .forEach(System.out::println);
        }
    }

    /**
     * <strong>Quiz 5.2 part b</strong>
     *
     * Given two lists of numbers, how would you return all pairs of numbers? For example, given a
     * list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For
     * simplicity, you can represent a pair as an array with two elements.
     * @param shouldPrint
     */
    public static void quiz2(boolean shouldPrint) {
        if (shouldPrint){
            List<Integer> list1 = Arrays.asList(1,2,3);
            List<Integer> list2 = Arrays.asList(3,4);

            List<int[]> solution = list1.stream()
                    .flatMap( i -> list2.stream()
                            .filter(j -> (i+j) % 3 == 0)
                            .map(j -> new int[]{i,j})
                    )
                    .collect(Collectors.toList());

            for (int[] lol : solution){

                System.out.printf("(%d ,%d)%n",lol[0], lol[1]);

            }

        }
    }

}
