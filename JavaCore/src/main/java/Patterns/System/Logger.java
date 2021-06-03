package Patterns.System;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private Class<?> clazz;

    private Logger(Class<?> clazz) {
        this.clazz = clazz;
    }

    public static Logger getLogger(Class<?> clazz) {
        return new Logger(clazz);
    }

    public void log(String msg) {
        System.out.printf("[INFO %s : %s : %s] - %s\n",
                new SimpleDateFormat("HH:mm:ss").format(new Date()),
                clazz.getSimpleName(),
                Thread.currentThread().getName(),
                msg);
    }
}
