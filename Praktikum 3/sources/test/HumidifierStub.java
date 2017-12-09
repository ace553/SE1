package test;

import boundaryclasses.IHumidifier;

public class HumidifierStub implements IHumidifier {

	boolean _spraying;
	
	public HumidifierStub()
	{
		_spraying = false;
	}
	
	@Override
	public void sendSprayOn() {
		_spraying = true;
	}

	@Override
	public void sendSprayOff() {
		_spraying = false;
	}

}
