import models.CurrentConditionDisplay;
import models.ForcastDisplay;
import models.WeatherData;
import models.WeatherStatisticsDisplay;

public class Main {
    public static void main(String[] args) {
        WeatherData data = new WeatherData();
        CurrentConditionDisplay display1 = new CurrentConditionDisplay(data);
        WeatherStatisticsDisplay display2 = new WeatherStatisticsDisplay(data);
        ForcastDisplay display3 = new ForcastDisplay(data);

        data.setMesurments(24, 40, 12);
    
        data.setMesurments(10, 10, 10);
        data.remove(display3);

        data.setMesurments(100, 0, 0);
    }
}
