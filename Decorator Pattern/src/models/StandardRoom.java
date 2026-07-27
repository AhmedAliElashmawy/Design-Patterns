package models;

import interfaces.Room;
public class StandardRoom implements Room{
    @Override
    public double cost() {
        return 100;
    }
    @Override
    public String getDescription() {
        return "Standard Room ";
    }
}
