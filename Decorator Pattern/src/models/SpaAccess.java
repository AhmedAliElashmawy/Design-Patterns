package models;

import interfaces.Room;

public class SpaAccess extends AbstractAmenity{
    public SpaAccess(Room room){
        super(room);
    }

    @Override
    public double cost() {
        return room.cost() + 50;
    }
    @Override
    public String getDescription() {
        return room.getDescription() + "+ Spa Access ";
    }
}
