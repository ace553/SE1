package test;

import boundaryclasses.IPump;

public class PumpStub implements IPump {

	boolean _activated;
	
	public PumpStub()
	{
		_activated = false;
	}
	
	@Override
	public void sendActivate() {
		_activated = true;
	}

	@Override
	public void sendDeactivate() {
		_activated = false;
	}

	@Override
	public boolean receivedActivated() {
		return _activated;
	}

}
