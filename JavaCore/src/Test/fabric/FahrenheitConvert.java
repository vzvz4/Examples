package Test.fabric;

public class FahrenheitConvert implements Convert {

    @Override
    public float convert(float temp) {
        return temp + 300;
    }
}
