package models;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import interfaces.IObservable;
import interfaces.IObserver;

public class WeatherData implements IObservable {
    private double temp;
    private double humidity;
    private double pressure;
    
    // Thread-safe list holding weak references to prevent memory leaks
    // CopyOnWriteArrayList to insure threds that removing an Observer dont make erros while the notify loop is working
    private List<WeakReference<IObserver>> observersList = new CopyOnWriteArrayList<>();

    public double getTemp() {
        return temp;
    }
    public double getHumidity() {
        return humidity;
    }
    public double getPressure() {
        return pressure;
    }

    // Mutex (synchronized) added to the critical section
    public synchronized void setMesurments(double temp, double humidity, double pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.measurmentsChanged();
    }

    @Override
    public void register(IObserver observer){
        this.observersList.add(new WeakReference<>(observer));
    }

    @Override
    public void remove(IObserver observer) {
        // Find the weak reference that wraps this specific observer and remove it
        for (WeakReference<IObserver> ref : observersList) {
            if (ref.get() == observer) {
                this.observersList.remove(ref);
                break;
            }
        }
    }

    @Override
    public void measurmentsChanged() {
        for(WeakReference<IObserver> ref : observersList){
            IObserver observer = ref.get(); // Unwrap the weak reference
            
            if (observer != null) {
                observer.update(); // Display is still alive, update it
            } else {
                this.observersList.remove(ref); // GC destroyed the display, clean up list
            }
        }
    }
}