package TemperatureConverter;

import java.util.Arrays;
import java.util.Locale;

interface BaseConverter {
    int getConvertedVal(int val);

    static BaseConverter getInstance() {
        Locale locale = Locale.getDefault();
        String[] fahrenheitCountries = {"BS","US","BZ","KY","PW"};

        boolean isFahrenheitCountry = Arrays.asList(fahrenheitCountries).contains(locale.getCountry());

        if(isFahrenheitCountry) {
            return new FahrenheitConvert();
        } else {
            return new CelsiusConvert();
        }
    }
}
