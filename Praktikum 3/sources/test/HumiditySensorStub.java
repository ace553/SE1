package test;

import boundaryclasses.IHumiditySensor;

public class HumiditySensorStub implements IHumiditySensor {

	double _humidity;
	
	public HumiditySensorStub()
	{
		_humidity = 50;
	}
	
	@Override
	public double getHumidity() {
		return _humidity;
	}

}
