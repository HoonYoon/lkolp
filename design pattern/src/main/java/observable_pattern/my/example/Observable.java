package observable_pattern.my.example;

/**
 * Created by guillermo on 25/07/17.
 * change! observable_pattern.my.example
 */
public interface Observable {

    void registerObserver(Observer observer);

    void unRegisterObserver(Observer observer);

    void notifyObservers();
}
