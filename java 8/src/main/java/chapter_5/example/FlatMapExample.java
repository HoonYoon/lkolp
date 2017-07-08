package chapter_5.example;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FlatMapExample {

    public static void main(String[] args) {

        List<Developer> team = new ArrayList<>();

        Developer polygon = new Developer("Arturo");
        polygon.add("php");
        polygon.add("scala");
        polygon.add("groovy");
        polygon.add("c#");

        Developer busy = new Developer("Guillermo");
        busy.add("java");
        busy.add("javascript");

        team.add(polygon);
        team.add(busy);

        System.out.println(team);

        List<String> languages = team.stream()
                .map(Developer::getLanguages)
                .flatMap(Set::stream)
                .collect(toList());

        Stream<String> iii = polygon.getLanguages().stream();


        List<List<List<String>>> ooo = new ArrayList<>();

        Stream<Stream<List<String>>> yyy = ooo.stream().map(List::stream);

        Stream<List<String>> ttt = ooo.stream().flatMap(List::stream);


        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);

        Stream<int[]> eee = number1.stream()
                .flatMap(i -> number2.stream()
                        .filter(j -> (j + i) % 3 == 0)
                        .map(j -> new int[]{i, j})
                );

        Stream<Stream<Integer>> jjj = number1.stream()
                .map(i -> number2.stream());

        System.out.println(4 % 1 == 0);

    }

}

class Developer {

    private String name;
    private Set<String> languages;

    public Developer(String name) {
        languages = new HashSet<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(String language) {
        languages.add(language);
    }

    public Set<String> getLanguages() {
        return languages;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", languages=" + languages +
                '}';
    }
}


