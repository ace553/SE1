package wrapper;

public class ISensor {
    private ISensorAPI _sensor;

    public ISensor(ISensorAPI sensor) {
        _sensor = sensor;
    }

    public int getDistance() {
        _sensor.t();
        char sensorOut = _sensor.d();
        int distance = (int) (Math.acos(1.0 - ((sensorOut + 5.0) / 265.0)) * 60.0 / Math.PI);
        if (distance < 0) {
            distance = 0;
        }

        return distance;
    }
}
