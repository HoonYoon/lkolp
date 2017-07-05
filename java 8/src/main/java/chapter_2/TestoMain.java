package chapter_2;

public class TestoMain {

    public static void main(String[] args) {
        TestoMain main = new TestoMain();

        Testo t = () -> false;

        main.lol(t);

    }

    public boolean lol (Testo t) {
        return t.test();
    }

}
