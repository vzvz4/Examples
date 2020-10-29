package InterfacesExample.OOPHomeWorks;

import java.util.Random;

public interface Action {
    Random random = new Random();

    String getName();

    int getRunDistance();

    int getJumpHeight();

    void run();

    void jump();
}
