package Test.fabric;

import java.util.Locale;

public class Fabric {

    public static Convert getInstance() {
        Convert convert;
        Locale locale = Locale.getDefault();
        switch (locale.getCountry()) {
            case "RU" :
                convert = new CelsiusConvert();
            case "UA" :
                convert = new FahrenheitConvert();
            default:
                convert = new CelsiusConvert();
        }
        return convert;
    }
}
