package TemperatureConverter;

public class KelvinConverter implements BaseConverter{

    @Override
    public int getConvertedVal(int val) {
        return (int) 2.8 * val + 32;
    }
}
