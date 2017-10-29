package wrapper;

public class MockSensor implements ISensorAPI{
    private char _testValue;

    public void setTestValue(char t){
        _testValue = t;
    }

    public char d(){
        return _testValue;
    };

    public void t(){

    }
}
