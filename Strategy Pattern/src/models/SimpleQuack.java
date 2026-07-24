package src.models;

import src.interfaces.IQuackBehavior;

public class SimpleQuack implements IQuackBehavior {
    @Override
    public void quack() {
        System.out.println("Simple Quack");
    }
}
