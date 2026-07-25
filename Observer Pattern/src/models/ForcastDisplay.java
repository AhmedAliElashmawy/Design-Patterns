package models;

import interfaces.IDisplay;
import interfaces.IObserver;

public class ForcastDisplay implements IObserver, IDisplay{
    private boolean isPressureRising = true;
    private double oldPressure = 0.0;
    private WeatherData data;

    public ForcastDisplay(WeatherData data){
        this.data = data;
        this.data.register(this);
    }

    @Override
    public void update() {
        double newPressure = this.data.getPressure();
        if(newPressure > oldPressure){
            isPressureRising = true;
        }
        else{
            isPressureRising = false;
        }
        oldPressure = newPressure;
        display();
    }
    @Override
    public void display() {
        if (!this.isPressureRising){
        System.out.println("Improving weather on the way!");
        }
        else{
            System.out.println("More of the same");
        }
    }
}
