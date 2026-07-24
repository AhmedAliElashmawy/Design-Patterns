package src.models;

import src.interfaces.IFlyBehavior;

public class SimpleFly implements IFlyBehavior{
    @Override
    public void fly(){
        System.out.println("Simple Fly");
    }
}
