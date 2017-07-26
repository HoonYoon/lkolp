package observable_pattern.my.example;

/**
 * Created by guillermo on 25/07/17.
 * change! observable_pattern.my.example
 */
public class Enemy implements Observer {

    private static int number = 0;
    private int id;

    public Enemy() {
        id = ++number;
    }

    @Override
    public void update() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "id=" + id +
                '}';
    }
}
