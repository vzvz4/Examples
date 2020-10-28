package TemperatureConverter;

public class FahrenheitConvert implements BaseConverter{

    @Override
    public int getConvertedVal(int val) {
        return val + 272;
    }
}
