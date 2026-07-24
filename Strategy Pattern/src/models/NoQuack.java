package src.models;

import src.interfaces.IQuackBehavior;

public class NoQuack implements IQuackBehavior {
    @Override
    public void quack() {
        System.out.println("No Quack");
    }
}
