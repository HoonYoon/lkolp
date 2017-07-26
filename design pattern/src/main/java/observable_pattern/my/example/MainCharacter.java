package observable_pattern.my.example;

import java.util.List;
import java.util.Set;

/**
 * Created by guillermo on 25/07/17.
 * change! observable_pattern.my.example
 */
public class MainCharacter implements Observable {

    private List<Observer> observers;

    public MainCharacter(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unRegisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        observers.forEach(Observer::update);

    }

    public void superAttack(){
        System.out.println("Super Attack");
        notifyObservers();
    }
}
