import models.BreakfastBuffet;
import models.DeluxeSuite;
import models.ExtraBed;
import models.PremiumWiFi;
import models.SpaAccess;
import interfaces.Room;

public class Main {
    public static void main(String[] args) {
        Room DeluxeWifiBreckfastTwobedSpa = new SpaAccess(new ExtraBed(new ExtraBed(new PremiumWiFi(new BreakfastBuffet(new DeluxeSuite())))));

        System.out.println(DeluxeWifiBreckfastTwobedSpa.cost());
        System.out.println(DeluxeWifiBreckfastTwobedSpa.getDescription());

    }
}
