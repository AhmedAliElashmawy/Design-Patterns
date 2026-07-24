package src;

import src.models.Duck;
import src.models.JetFly;
import src.models.NoQuack;
import src.models.SimpleFly;
import src.models.SimpleQuack;

public class Main {
    public static void main(String[] args) {
        Duck wildDuck = new Duck(new SimpleFly(), new SimpleQuack());
        System.out.println("\nWild Duck");
        wildDuck.performFly();
        wildDuck.performQuack();

        wildDuck.setFlyBehavior(new JetFly());
        wildDuck.setQuackBehavior(new NoQuack());
        System.out.println("\nWild Duck after changing strategies");
        wildDuck.performFly();
        wildDuck.performQuack();

        Duck rubberDuck = new Duck(new JetFly(), new NoQuack());
        System.out.println("\nRubber Duck");
        rubberDuck.performFly();
        rubberDuck.performQuack();
    }
}
