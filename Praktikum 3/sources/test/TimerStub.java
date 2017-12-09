package test;

import boundaryclasses.ITimer;

public class TimerStub implements ITimer {

	double _time;
	boolean _expired;
	
	public TimerStub()
	{
		_time = 0;
		_expired = false;
	}
	
	@Override
	public void startTime(double seconds) {
		_time = seconds;
	}

	@Override
	public boolean isTimerExpired() {
		return _expired;
	}

}
