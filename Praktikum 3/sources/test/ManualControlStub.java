package test;

import boundaryclasses.IManualControl;

public class ManualControlStub implements IManualControl {

	boolean _acknowledgement;
	
	public ManualControlStub()
	{
		_acknowledgement = false;
	}
	
	@Override
	public boolean receivedAcknowledgement() {
		return _acknowledgement;
	}

}
