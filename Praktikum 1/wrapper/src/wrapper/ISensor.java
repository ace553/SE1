package wrapper;

import java.io.IOException;
import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

public class ISensor
{
    private ISensorAPI _sensor;

    public ISensor(ISensorAPI sensor)
    {
        _sensor = sensor;
    }

    
    
    public int getDistance() throws IOException
    {
        _sensor.t();
        char sensorOut = _sensor.d();
        int distance = 0;
        if(sensorOut > 255 || sensorOut < 0)
        {
            throw new IOException("Sensordaten ungültig: " + sensorOut);
        }
        else
        {
        distance = (int) (Math.acos(1 - ((sensorOut + 5) / 265)) * 60/Math.PI);    
        if(distance < 0)
        {
            distance = 0;
        }
        
        }
        
        
        return distance;
    };
}
