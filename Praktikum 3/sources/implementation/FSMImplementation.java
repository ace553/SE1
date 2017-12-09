package implementation;

import boundaryclasses.IGate;
import boundaryclasses.IHumidifier;
import boundaryclasses.IHumiditySensor;
import boundaryclasses.IManualControl;
import boundaryclasses.IOpticalSignals;
import boundaryclasses.IPump;
import boundaryclasses.ITimer;
import fsm.IFSM;

public class FSMImplementation implements IFSM
{
    private FSMState        state;
    private IPump           pumpA;
    private IPump           pumpB;
    private IGate           gate;
    private IOpticalSignals signals;
    private IHumiditySensor sensor;
    private IHumidifier     humidifier;
    private IManualControl  operatorPanel;
    private final double    upperBound;
    private final double    lowerBound;
    private boolean         pumpOkA, pumpOkB;
    private ITimer          timer;

    public FSMImplementation(IPump pumpA, IPump pumpB, IGate gate, IOpticalSignals signals, IHumidifier humidifier, IHumiditySensor sensor, IManualControl operatorPanel, ITimer timer)
    {
        this.state = FSMState.Monitoring;
        this.pumpA = pumpA;
        this.pumpB = pumpB;
        this.gate = gate;
        this.signals = signals;
        this.sensor = sensor;
        this.humidifier = humidifier;
        this.operatorPanel = operatorPanel;
        upperBound = 60;
        lowerBound = 20;
        this.timer = timer;
    }

    @Override
    public void evaluate()
    {
        switch (this.state)
        {
            case CloseGate:
                if (this.gate.receivedGateClosed())
                {
                    changeTo(FSMState.StartingPumps);
                }
                break;
            case Dehudmitifying:
                if (this.sensor.getHumidity() < this.upperBound)
                {
                    changeTo(FSMState.OpenGate);
                }
                break;
            case Hudmitifying:
                if (this.sensor.getHumidity() < this.lowerBound)
                {
                    changeTo(FSMState.Monitoring);
                }
                break;
            case Monitoring:
                if (this.sensor.getHumidity() > this.lowerBound)
                {
                    changeTo(FSMState.Hudmitifying);
                }
                break;
            case OpenGate:
                if (this.gate.receivedGateOpen())
                {
                    changeTo(FSMState.Monitoring);
                }
                break;
            case PumpError:
                if (this.operatorPanel.receivedAcknowledgement())
                {
                    changeTo(FSMState.Monitoring);
                }
                break;
            case StartingPumps:

                this.pumpOkA = this.pumpOkA ^ this.pumpA.receivedActivated();
                this.pumpOkB = this.pumpOkB ^ this.pumpB.receivedActivated();

                if (pumpOkA && pumpOkB)
                {
                    changeTo(FSMState.Dehudmitifying);
                }
                else if (this.timer.isTimerExpired())
                {
                    changeTo(FSMState.PumpError);
                }
                break;

        }

    }

    /**
     * This Method does an "Zustandsübergang" to given state.
     * 
     * @param state
     *            The State, in which the FSM should change to.
     */
    private void changeTo(FSMState state)
    {
        exitAction(this.state);
        this.state = state;
        entryAction(this.state);
    }

    /**
     * This Method performs the exit-Action for a specific state.
     * 
     * @param state
     *            The specific state.
     */
    private void exitAction(FSMState state)
    {
        switch (state)
        {
            case CloseGate:
                this.signals.switchLampBOff();
                break;
            case Dehudmitifying:
                this.pumpA.sendDeactivate();
                this.pumpB.sendDeactivate();
                break;
            case Hudmitifying:
                this.humidifier.sendSprayOff();
                this.signals.switchLampAOff();
                break;
            case Monitoring:
                // Nothing
                break;
            case OpenGate:
                this.signals.switchLampBOff();
                break;
            case PumpError:
                // Nothing
                break;
            case StartingPumps:
                // Nothing
                break;

        }
    }

    /**
     * This Method performs the entry-Action for a specific state.
     * 
     * @param state
     *            The specific state.
     */
    private void entryAction(FSMState state)
    {
        switch (state)
        {
            case CloseGate:
                this.signals.switchLampBOn();
                this.gate.sendCloseGate();
                break;
            case Dehudmitifying:
                // Nothing
                break;
            case Hudmitifying:
                this.signals.switchLampAOn();
                this.humidifier.sendSprayOn();
                break;
            case Monitoring:
                // Nothing
                break;
            case OpenGate:
                this.signals.switchLampBOn();
                this.gate.sendOpenGate();
                break;
            case PumpError:
                this.gate.sendOpenGate();
                this.pumpA.sendDeactivate();
                this.pumpB.sendDeactivate();
                break;
            case StartingPumps:
                pumpOkA = false;
                pumpOkB = false;
                pumpA.sendActivate();
                pumpB.sendActivate();
                timer.startTime(5);
                break;

        }
    }

}
