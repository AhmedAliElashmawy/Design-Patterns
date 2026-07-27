package models;

import interfaces.Room;

public abstract class AbstractAmenity implements Room {
    public Room room;
    public AbstractAmenity(Room room){
        this.room = room;
    }
}
