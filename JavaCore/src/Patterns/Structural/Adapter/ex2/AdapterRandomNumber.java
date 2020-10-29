package Patterns.Structural.Adapter.ex2;

import java.io.IOException;
import java.nio.CharBuffer;

public class AdapterRandomNumber extends RandomNumbers implements Readable {
    private int count;

    public AdapterRandomNumber(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- <= 0)
            return -1;
        String str = next() + " ";
        cb.append(str);
        return str.length();
    }
}
