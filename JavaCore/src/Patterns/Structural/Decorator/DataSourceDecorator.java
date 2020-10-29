package Patterns.Structural.Decorator;

import Patterns.Structural.Decorator.DataSource;

import java.io.IOException;

public class DataSourceDecorator implements DataSource {
    private DataSource wrappee;

    public DataSourceDecorator(DataSource wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void writeData(String data) throws IOException {
        wrappee.writeData(data);
    }

    @Override
    public String readData() throws IOException {
        return wrappee.readData();
    }
}
