package wrapper;

public class Wrapper {
    private ISensorAPI _sensor;

    public Wrapper(ISensorAPI sensor) {
        _sensor = sensor;
    }

    public int getDistance(){
        _sensor.t();
        //TODO calculate correct output with _sensor.d()
        return 0;
    };
}
