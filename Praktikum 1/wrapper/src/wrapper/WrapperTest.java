package wrapper;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Diese Klasse testet ob die ISensor-Klasse Werte von 0 bis 255 korrekt in einen Abstand in Zentimeter umrechnet.
 * Eine Äquivalenzklasse für diese Tests setzt sich aus der Menge aller Zahlen von 0 bis 255 zusammen die,
 * nach der Abstandsberechnungsformel, dem selben Abstand in Zentimetern entsprechen.
 * Die Äquivalenzklassen wurden mit Hilfe dafür üblicher Test überprüft. (untere Grenze, obere Grenze, Kandidat aus dem Bereich)
 * @author BCK
 *
 */
public class WrapperTest
{
    //MockSensor um dem ISensor vom Test definierte Werte zu liefern
    private MockSensor _sensor;
    //der zu testende Sensor
    private ISensor    _wrapper;

    public WrapperTest()
    {
        _sensor = new MockSensor();
        _wrapper = new ISensor(_sensor);
    }

    @Test
    // tests für d == 4, 1<=x<=4
    // das heißt, dass die Wrapper-Klasse 4cm ausgeben soll,
    // falls der gelieferte Sensorwert zwischen 1 und 4 liegt (iniklusive)
    public void id0()
    {
        // unterer Grenzwert
        _sensor.setTestValue(1);
        assertEquals(4, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(3);
        assertEquals(4, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(4);
        assertEquals(4, _wrapper.getDistance());
    }

    @Test
    // tests für d == 5, 5<=x<=7
    public void id1()
    {
        // unterer Grenzwert
        _sensor.setTestValue(5);
        assertEquals(5, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(6);
        assertEquals(5, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(7);
        assertEquals(5, _wrapper.getDistance());
    }

    @Test
    // tests für d == 6, 8<=x<=12
    public void id2()
    {
        // unterer Grenzwert
        _sensor.setTestValue(8);
        assertEquals(6, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(9);
        assertEquals(6, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(12);
        assertEquals(6, _wrapper.getDistance());
    }

    @Test
    // tests für d == 7, 13<=x<=17
    public void id3()
    {
        // unterer Grenzwert
        _sensor.setTestValue(13);
        assertEquals(7, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(15);
        assertEquals(7, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(17);
        assertEquals(7, _wrapper.getDistance());
    }

    @Test
    // tests für d == 8, 18<=x<=23
    public void id4()
    {
        // unterer Grenzwert
        _sensor.setTestValue(18);
        assertEquals(8, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(20);
        assertEquals(8, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(23);
        assertEquals(8, _wrapper.getDistance());
    }

    @Test
    // tests für d == 9, 24<=x<=30
    public void id5()
    {
        // unterer Grenzwert
        _sensor.setTestValue(24);
        assertEquals(9, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(26);
        assertEquals(9, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(30);
        assertEquals(9, _wrapper.getDistance());
    }

    @Test
    // tests für d == 10, 31<=x<=37
    public void id6()
    {
        // unterer Grenzwert
        _sensor.setTestValue(31);
        assertEquals(10, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(34);
        assertEquals(10, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(37);
        assertEquals(10, _wrapper.getDistance());
    }

    @Test
    // tests für d == 11, 38<=x<=45
    public void id7()
    {
        // unterer Grenzwert
        _sensor.setTestValue(38);
        assertEquals(11, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(40);
        assertEquals(11, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(45);
        assertEquals(11, _wrapper.getDistance());
    }

    @Test
    // tests für d == 12, 46<=x<=54
    public void id8()
    {
        // unterer Grenzwert
        _sensor.setTestValue(46);
        assertEquals(12, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(50);
        assertEquals(12, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(54);
        assertEquals(12, _wrapper.getDistance());
    }

    @Test
    // tests für d == 13, 55<=x<=63
    public void id9()
    {
        // unterer Grenzwert
        _sensor.setTestValue(55);
        assertEquals(13, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(60);
        assertEquals(13, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(63);
        assertEquals(13, _wrapper.getDistance());
    }

    @Test
    // tests für d == 14, 64<=x<=72
    public void id10()
    {
        // unterer Grenzwert
        _sensor.setTestValue(64);
        assertEquals(14, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(68);
        assertEquals(14, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(72);
        assertEquals(14, _wrapper.getDistance());
    }

    @Test
    // tests für d == 15, 73<=x<=82
    public void id11()
    {
        // unterer Grenzwert
        _sensor.setTestValue(73);
        assertEquals(15, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(77);
        assertEquals(15, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(82);
        assertEquals(15, _wrapper.getDistance());
    }

    @Test
    // tests für d == 16, 83<=x<=93
    public void id12()
    {
        // unterer Grenzwert
        _sensor.setTestValue(83);
        assertEquals(16, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(87);
        assertEquals(16, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(93);
        assertEquals(16, _wrapper.getDistance());
    }

    @Test
    // tests für d == 17, 94<=x<=104
    public void id13()
    {
        // unterer Grenzwert
        _sensor.setTestValue(94);
        assertEquals(17, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(99);
        assertEquals(17, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(104);
        assertEquals(17, _wrapper.getDistance());
    }

    @Test
    // tests für d == 18, 105<=x<=115
    public void id14()
    {
        // unterer Grenzwert
        _sensor.setTestValue(105);
        assertEquals(18, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(110);
        assertEquals(18, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(115);
        assertEquals(18, _wrapper.getDistance());
    }

    @Test
    // tests für d == 19, 116<=x<=127
    public void id15()
    {
        // unterer Grenzwert
        _sensor.setTestValue(116);
        assertEquals(19, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(120);
        assertEquals(19, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(127);
        assertEquals(19, _wrapper.getDistance());
    }

    @Test
    // tests für d == 20, 128<=x<=139
    public void id16()
    {
        // unterer Grenzwert
        _sensor.setTestValue(128);
        assertEquals(20, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(135);
        assertEquals(20, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(139);
        assertEquals(20, _wrapper.getDistance());
    }

    @Test
    // tests für d == 21, 140<=x<=152
    public void id17()
    {
        // unterer Grenzwert
        _sensor.setTestValue(140);
        assertEquals(21, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(145);
        assertEquals(21, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(152);
        assertEquals(21, _wrapper.getDistance());
    }

    @Test
    // tests für d == 22, 153<=x<=165
    public void id18()
    {
        // unterer Grenzwert
        _sensor.setTestValue(153);
        assertEquals(22, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(160);
        assertEquals(22, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(165);
        assertEquals(22, _wrapper.getDistance());
    }

    @Test
    // tests für d == 23, 166<=x<=178
    public void id19()
    {
        // unterer Grenzwert
        _sensor.setTestValue(166);
        assertEquals(23, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(170);
        assertEquals(23, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(178);
        assertEquals(23, _wrapper.getDistance());
    }

    // tests für d == 24, 179<=x<=191
    public void id20()
    {
        // unterer Grenzwert
        _sensor.setTestValue(179);
        assertEquals(24, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(180);
        assertEquals(24, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(191);
        assertEquals(24, _wrapper.getDistance());
    }

    // tests für d == 25, 192<=x<=204
    public void id21()
    {
        // unterer Grenzwert
        _sensor.setTestValue(192);
        assertEquals(25, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(200);
        assertEquals(25, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(204);
        assertEquals(25, _wrapper.getDistance());
    }

    // tests für d == 26, 205<=x<=218
    public void id22()
    {
        // unterer Grenzwert
        _sensor.setTestValue(205);
        assertEquals(26, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(210);
        assertEquals(26, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(218);
        assertEquals(26, _wrapper.getDistance());
    }

    // tests für d == 27, 219<=x<=232
    public void id23()
    {
        // unterer Grenzwert
        _sensor.setTestValue(219);
        assertEquals(27, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(225);
        assertEquals(27, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(232);
        assertEquals(27, _wrapper.getDistance());
    }

    // tests für d == 28, 234<=x<=236
    public void id24()
    {
        // unterer Grenzwert
        _sensor.setTestValue(234);
        assertEquals(28, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(235);
        assertEquals(28, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(236);
        assertEquals(28, _wrapper.getDistance());
    }

    // tests für d == 29, 237<=x<=260
    public void id25()
    {
        // unterer Grenzwert
        _sensor.setTestValue(237);
        assertEquals(29, _wrapper.getDistance());

        // Kandidat
        _sensor.setTestValue(240);
        assertEquals(29, _wrapper.getDistance());

        // oberer Grenzwert
        _sensor.setTestValue(255);
        assertEquals(29, _wrapper.getDistance());
    }
}
