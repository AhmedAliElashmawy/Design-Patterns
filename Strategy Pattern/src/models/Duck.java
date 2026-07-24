package src.models;

import src.interfaces.IFlyBehavior;
import src.interfaces.IQuackBehavior;

public class Duck {
    private IFlyBehavior flyBehavior;
    private IQuackBehavior quackBehavior;

    public Duck(IFlyBehavior flyBehavior, IQuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(IFlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(IQuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void performFly() {
        this.flyBehavior.fly();
    }

    public void performQuack() {
        this.quackBehavior.quack();
    }
}
