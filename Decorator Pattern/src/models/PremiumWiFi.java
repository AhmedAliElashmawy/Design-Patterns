package models;

import interfaces.Room;

public class PremiumWiFi extends AbstractAmenity{
    public PremiumWiFi(Room room){
        super(room);
    }

    @Override
    public double cost() {
        return room.cost() + 10;
    }
    @Override
    public String getDescription() {
        return room.getDescription() + "+ Premium WiFi ";
    }

}
