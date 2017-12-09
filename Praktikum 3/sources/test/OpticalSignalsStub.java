package test;

import boundaryclasses.IOpticalSignals;

public class OpticalSignalsStub implements IOpticalSignals {

	boolean _lampAOn;
	boolean _lampBOn;
	
	
	public OpticalSignalsStub()
	{
		_lampAOn = false;
		_lampBOn = true;
	}
	
	
	@Override
	public void switchLampAOn() {
		_lampAOn = true;
	}

	@Override
	public void switchLampAOff() {
		_lampAOn = false;
	}

	@Override
	public void switchLampBOn() {
		_lampBOn = true;
	}

	@Override
	public void switchLampBOff() {
		_lampBOn = false;
	}

}
