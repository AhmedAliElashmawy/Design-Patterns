package src.models;

import src.interfaces.IFlyBehavior;

public class JetFly implements IFlyBehavior{
    @Override
    public void fly(){
        System.out.println("Jet Fly");
    }
}
