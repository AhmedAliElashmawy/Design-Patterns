package models;

import interfaces.Room;


public class DeluxeSuite implements Room{
    @Override
    public double cost(){
        return 250;
    }
    @Override
    public String getDescription() {
        return "Deluxe Suite ";
    }
}
