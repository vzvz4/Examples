package Patterns.Structural.Decorator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(String data) throws IOException {
        StringBuilder result = new StringBuilder();
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(data.getBytes(StandardCharsets.UTF_8));

            for (byte b : hashInBytes) {
                result.append(String.format("%02x", b));
            }
            super.writeData(result.toString());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public String readData() throws IOException {
        return super.readData();
    }

}
