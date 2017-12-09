package test;

import boundaryclasses.IGate;

public class GateStub implements IGate {

	boolean _open;
	
	public GateStub()
	{
		_open = false;
	}
	
	@Override
	public void sendCloseGate() {
		_open = false;
	}

	@Override
	public void sendOpenGate() {
		_open = true;
	}

	@Override
	public boolean receivedGateClosed() {
		return !_open;
	}

	@Override
	public boolean receivedGateOpen() {
		return _open;
	}

}
