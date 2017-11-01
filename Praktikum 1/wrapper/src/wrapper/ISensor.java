package wrapper;
/**
 * Dies ist die Wrapperklasse für einen Infrarotsensor, welcher den Wertebereich 4cm - 30cm unterstützt.
 * @author STARK
 *
 */
public class ISensor
{
    private ISensorAPI _sensor;

    public ISensor(ISensorAPI sensor)
    {
        _sensor = sensor;
    }

    /**
     * Gibt die gemessene Distanz des Sensors zurück!
     * Der Werte breich ist 4cm bis 30cm.
     * @return die Distanz in cm! 
     */
    public int getDistance()
    {
        _sensor.t();
        char sensorOut = _sensor.d();
        int distance = (int) (Math.acos(1.0 - ((sensorOut + 5.0) / 265.0)) * 60.0 / Math.PI);
        if (distance < 4)
        {
            distance = 4;
        }

        return distance;
    }
}
