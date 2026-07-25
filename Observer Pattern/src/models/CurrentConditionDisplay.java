package models;

import interfaces.IDisplay;
import interfaces.IObserver;

public class CurrentConditionDisplay implements IObserver, IDisplay{
    private double temp = 0;
    private double humidity = 0;
    private WeatherData data;


    public CurrentConditionDisplay(WeatherData data){
        this.data = data;
        this.data.register(this);
    }
    @Override
    public void update() {
        this.temp = data.getTemp();
        this.humidity = data.getHumidity();
        display();
    }
    @Override
    public void display() {
        System.out.println("Current Temp is:" + this.temp + " Current Humidity is:" + this.humidity);
    }
}
