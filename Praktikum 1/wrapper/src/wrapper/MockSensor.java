package wrapper;

public class MockSensor implements ISensorAPI{
    private char _testValue;

    public void setTestValue(int discreteValue){
        _testValue = (char) discreteValue;
    }

    public char d(){
        return _testValue;
    };

    public void t(){

    }
}
