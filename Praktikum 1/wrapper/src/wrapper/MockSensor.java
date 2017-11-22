package wrapper;
/**
 * Diese Klasse emuliert einen Abstandssensor, der Werte zwischen 0 und 255 zurückgibt.
 * Diese Klasse soll nur zum Testen verwendet werden und nicht an Stellen benutzt werden, wo ein funktionstüchtiger
 * Sensor benötigt wird.
 * @author BCK
 *
 */
public class MockSensor implements ISensorAPI{
    private char _testValue;
    
    private char _dValue;
    
    public MockSensor()
	{
		_dValue = 0;
	}
    
    /**
     * Setzt einen zu erzeugenden Abstandswert, der im Sensor gespeichert wird
     * @param discreteValue bestimmter distanz Wert 0-255
     */
    public void setTestValue(int discreteValue){
        _testValue = (char) discreteValue;
    }

    @Override
    public char d(){
        return _dValue;
    };

    @Override
    public void t(){
    	_dValue = _testValue;
    }
}
