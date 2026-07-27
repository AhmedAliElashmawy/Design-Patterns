package models;

import interfaces.Room;

public class ExtraBed extends AbstractAmenity{

    public ExtraBed(Room room){
        super(room);
    }

    @Override
    public double cost() {
        return room.cost() + 30;
    }

    @Override
    public String getDescription() {
        return room.getDescription() + "+ Extra Bed ";
    }
}
