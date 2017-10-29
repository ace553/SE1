package wrapper;

import org.junit.Test;

import static org.junit.Assert.*;

public class WrapperTest {
    private MockSensor _sensor;
    private Wrapper _wrapper;

    public WrapperTest(){
        _sensor = new MockSensor();
        _wrapper = new Wrapper(_sensor);
    }

    @Test
    public void id0(){
        _sensor.setTestValue((char) 0);
        assertEquals(0, _wrapper.getDistance());
    }
}