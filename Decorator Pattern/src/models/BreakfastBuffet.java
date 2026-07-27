package models;

import interfaces.Room;

public class BreakfastBuffet extends AbstractAmenity{
    public BreakfastBuffet(Room room){
        super(room);
    }

    @Override
    public double cost(){
        return room.cost() + 35;
    }
    @Override
    public String getDescription(){
        return room.getDescription() + "+ Breakfast Buffet ";
    }
}
