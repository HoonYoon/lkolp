package testo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TestoMain {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("lol", "perro", "Jhon", "Carlos", "Maria", "Ashely", "Brittany");
        final Random random = new Random();
        final List<String> usedName = new ArrayList<>();

        names.stream().map(t -> names.get(random.nextInt(names.size())))
                .filter(usedName::contains)
                .forEach(usedName::add);

        System.out.println(usedName);
    }
}
