package wrapper;

import java.io.IOException;
import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

public class ISensor {
    private ISensorAPI _sensor;

    public ISensor(ISensorAPI sensor) {
        _sensor = sensor;
    }
    
    public int getDistance() throws IOException {
        _sensor.t();
        char sensorOut = _sensor.d();
        int distance = 0;
        if (sensorOut > 255 || sensorOut < 0) {
            throw new IOException("Sensordaten ung�ltig: " + sensorOut);
        } else {
            distance = (int) (Math.acos(1.0 - ((sensorOut + 5.0) / 265.0)) * 60.0 / Math.PI);
            if (distance < 0) {
                distance = 0;
            }
        }


        return distance;
    }
}
