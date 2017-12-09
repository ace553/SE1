package test;

/**
 * Test Framework for testing the FSM from Practice 3
 * @author Thomas Lehmann
 * @version 2015-11-18
 */
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fsm.IFSM;
import implementation.FSMImplementation;

public class FSMImplementationTest
{
	private PumpStub pumpA;
	private PumpStub pumpB;
	private GateStub gate;
	private OpticalSignalsStub signals;
	private HumiditySensorStub sensor;
	private HumidifierStub humidifier;
	private ManualControlStub operatorPanel;
	private TimerStub timer;
	private IFSM uut;

	@Before
	public void testSetup()
	{
		pumpA = new PumpStub();
		pumpB = new PumpStub();
		gate = new GateStub();
		signals = new OpticalSignalsStub();
		sensor = new HumiditySensorStub();
		humidifier = new HumidifierStub();
		operatorPanel = new ManualControlStub();
		timer = new TimerStub();
		uut = new FSMImplementation(pumpA, pumpB, gate, signals, humidifier, sensor, operatorPanel, timer);
	}

	@Test
	public void testPath()
	{
		//Monitoring
		assertEquals(false, pumpA._activated);
		assertEquals(false, pumpB._activated);
		assertEquals(true, gate._open);
		assertEquals(false, signals._lampAOn);
		assertEquals(false, signals._lampBOn);
		assertEquals(50, sensor._humidity, 0.1);
		assertEquals(false, humidifier._spraying);
		assertEquals(false, operatorPanel._acknowledgement);
		assertEquals(false, timer._expired);
		assertEquals(0, timer._time, 0.1);

		uut.evaluate();

		//Monitoring
		assertEquals(false, pumpA._activated);
		assertEquals(false, pumpB._activated);
		assertEquals(true, gate._open);
		assertEquals(false, signals._lampAOn);
		assertEquals(false, signals._lampBOn);
		assertEquals(50, sensor._humidity, 0.1);
		assertEquals(false, humidifier._spraying);
		assertEquals(false, operatorPanel._acknowledgement);
		assertEquals(false, timer._expired);
		assertEquals(0, timer._time, 0.1);

		sensor._humidity = 70;

		uut.evaluate();
		
		//CloseGate
		assertEquals(false, pumpA._activated);
		assertEquals(false, pumpB._activated);
		assertEquals(false, gate._open);
		assertEquals(false, signals._lampAOn);
		assertEquals(true, signals._lampBOn);
		assertEquals(70, sensor._humidity, 0.1);
		assertEquals(false, humidifier._spraying);
		assertEquals(false, operatorPanel._acknowledgement);
		assertEquals(false, timer._expired);
		assertEquals(0, timer._time, 0.1);

		uut.evaluate();

		//StartingPumps
		assertEquals(true, pumpA._activated);
		assertEquals(true, pumpB._activated);
		assertEquals(false, gate._open);
		assertEquals(false, signals._lampAOn);
		assertEquals(false, signals._lampBOn);
		assertEquals(70, sensor._humidity, 0.1);
		assertEquals(false, humidifier._spraying);
		assertEquals(false, operatorPanel._acknowledgement);
		assertEquals(false, timer._expired);
		assertEquals(5, timer._time, 0.1);

		uut.evaluate();

		//Dehumididifying
		assertEquals(true, pumpA._activated);
		assertEquals(true, pumpB._activated);
		assertEquals(false, gate._open);
		assertEquals(false, signals._lampAOn);
		assertEquals(false, signals._lampBOn);
		assertEquals(70, sensor._humidity, 0.1);
		assertEquals(false, humidifier._spraying);
		assertEquals(false, operatorPanel._acknowledgement);
		assertEquals(false, timer._expired);
		assertEquals(5, timer._time, 0.1);

		sensor._humidity = 50;

		uut.evaluate();

		//OpenGate
		assertEquals(false, pumpA._activated);
		assertEquals(false, pumpB._activated);
		assertEquals(true, gate._open);
		assertEquals(false, signals._lampAOn);
		assertEquals(true, signals._lampBOn);
		assertEquals(50, sensor._humidity, 0.1);
		assertEquals(false, humidifier._spraying);
		assertEquals(false, operatorPanel._acknowledgement);
		assertEquals(false, timer._expired);
		assertEquals(5, timer._time, 0.1);

		uut.evaluate();

		//Monitoring
		assertEquals(false, pumpA._activated);
		assertEquals(false, pumpB._activated);
		assertEquals(true, gate._open);
		assertEquals(false, signals._lampAOn);
		assertEquals(false, signals._lampBOn);
		assertEquals(50, sensor._humidity, 0.1);
		assertEquals(false, humidifier._spraying);
		assertEquals(false, operatorPanel._acknowledgement);
		assertEquals(false, timer._expired);
		assertEquals(5, timer._time, 0.1);

	}

}
