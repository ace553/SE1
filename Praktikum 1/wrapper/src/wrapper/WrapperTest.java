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
        _sensor.setTestValue(0);
        assertEquals(0, _wrapper.getDistance());
    }

    @Test
    //tests für d == 5, 4<=x<=7
    public void id1(){
        //unterer Grenzwert
        _sensor.setTestValue(4);
        assertEquals(5, _wrapper.getDistance());

        //Kandidat
        _sensor.setTestValue(5);
        assertEquals(5, _wrapper.getDistance());

        //oberer Grenzwert
        _sensor.setTestValue(7);
        assertEquals(5, _wrapper.getDistance());
    }

    @Test
    //tests für d == 6, 8<=x<=11
    public void id2(){
        //unterer Grenzwert
        _sensor.setTestValue(8);
        assertEquals(6, _wrapper.getDistance());

        //Kandidat
        _sensor.setTestValue(10);
        assertEquals(6, _wrapper.getDistance());

        //oberer Grenzwert
        _sensor.setTestValue(11);
        assertEquals(6, _wrapper.getDistance());
    }

    @Test
    //tests für d == 7, 12<=x<=16
    public void id3(){
        //unterer Grenzwert
        _sensor.setTestValue(13);
        assertEquals(7, _wrapper.getDistance());

        //Kandidat
        _sensor.setTestValue(15);
        assertEquals(7, _wrapper.getDistance());

        //oberer Grenzwert
        _sensor.setTestValue(16);
        assertEquals(7, _wrapper.getDistance());
    }

    @Test
    //tests für d == 8, 17<=x<=22
    public void id4(){
        //unterer Grenzwert
        _sensor.setTestValue(17);
        assertEquals(8, _wrapper.getDistance());

        //Kandidat
        _sensor.setTestValue(20);
        assertEquals(8, _wrapper.getDistance());

        //oberer Grenzwert
        _sensor.setTestValue(22);
        assertEquals(8, _wrapper.getDistance());
    }

    @Test
    //tests für d == 9, 23<=x<=29
    public void id5(){
        //unterer Grenzwert
        _sensor.setTestValue(23);
        assertEquals(9, _wrapper.getDistance());

        //Kandidat
        _sensor.setTestValue(25);
        assertEquals(9, _wrapper.getDistance());

        //oberer Grenzwert
        _sensor.setTestValue(29);
        assertEquals(9, _wrapper.getDistance());
    }

    @Test
    //tests für d == 10, 30<=x<=37
    public void id6(){
        //unterer Grenzwert
        _sensor.setTestValue(30);
        assertEquals(10, _wrapper.getDistance());

        //Kandidat
        _sensor.setTestValue(34);
        assertEquals(10, _wrapper.getDistance());

        //oberer Grenzwert
        _sensor.setTestValue(37);
        assertEquals(10, _wrapper.getDistance());
    }

    @Test
    //tests für d == 11, 37<=x<=44
    public void id7(){
        //unterer Grenzwert
        _sensor.setTestValue(37);
        assertEquals(11, _wrapper.getDistance());

        //Kandidat
        _sensor.setTestValue(40);
        assertEquals(11, _wrapper.getDistance());

        //oberer Grenzwert
        _sensor.setTestValue(44);
        assertEquals(11, _wrapper.getDistance());
    }

    @Test
    //tests für d == 12, 45<=x<=53
    public void id8(){
        //unterer Grenzwert
        _sensor.setTestValue(45);
        assertEquals(12, _wrapper.getDistance());

        //Kandidat
        _sensor.setTestValue(50);
        assertEquals(12, _wrapper.getDistance());

        //oberer Grenzwert
        _sensor.setTestValue(53);
        assertEquals(12, _wrapper.getDistance());
    }

    @Test
    //tests für d == 13, 54<=x<=62
    public void id9(){
        //unterer Grenzwert
        _sensor.setTestValue(54);
        assertEquals(13, _wrapper.getDistance());

        //Kandidat
        _sensor.setTestValue(60);
        assertEquals(13, _wrapper.getDistance());

        //oberer Grenzwert
        _sensor.setTestValue(62);
        assertEquals(13, _wrapper.getDistance());
    }

    @Test
    //tests für d == 14, 63<=x<=71
    public void id10(){
        //unterer Grenzwert
        _sensor.setTestValue(63);
        assertEquals(14, _wrapper.getDistance());

        //Kandidat
        _sensor.setTestValue(68);
        assertEquals(14, _wrapper.getDistance());

        //oberer Grenzwert
        _sensor.setTestValue(71);
        assertEquals(14, _wrapper.getDistance());
    }
}