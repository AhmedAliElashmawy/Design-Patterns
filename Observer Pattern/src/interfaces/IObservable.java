package interfaces;

public interface IObservable {
    void register(IObserver observer);
    void remove(IObserver observer);
    void measurmentsChanged();
}
