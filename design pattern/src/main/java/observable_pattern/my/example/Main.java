package observable_pattern.my.example;

/**
 * Created by guillermo on 25/07/17.
 * change! observable_pattern.my.example
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * The whole point is to mock a game where the player use a global attack that kill all enemies in the arena.
 */
public class Main {

    public static void main(String[] args) {


        List<Observer> enemies = Arrays.asList(new Enemy(), new Enemy(), new Enemy(), new Enemy(),new Enemy());

        MainCharacter character = new MainCharacter(enemies);
        character.superAttack();
    }
}
