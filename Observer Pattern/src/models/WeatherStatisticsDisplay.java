package models;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import interfaces.IDisplay;
import interfaces.IObserver;

public class WeatherStatisticsDisplay implements IObserver,IDisplay {
    private List<Double> tempList = new ArrayList<>();
    private List<Double> humidityList = new ArrayList<>();
    private List<Double> pressureList = new ArrayList<>();
    private WeatherData data;

    public WeatherStatisticsDisplay(WeatherData data){
        this.data = data;
        this.data.register(this);
    }

    @Override
    public void update() {
        this.tempList.add(data.getTemp());
        this.humidityList.add(data.getHumidity());
        this.pressureList.add(data.getPressure());
        display();
    }
    @Override
    public void display() {
        if (!this.tempList.isEmpty()){
        double max = Collections.max(this.tempList);
        double min = Collections.min(this.tempList);
        double average = this.tempList.stream()
                         .mapToDouble(Double::doubleValue)
                         .average()
                         .orElse(0.0);
        System.out.println("Max Temp is:" + max + " Min Temp is:" + min + " Average Temp is:" + average);
        }
        else {
            System.out.println("No data to be displayed");
        }
    }
}
