package InterfacesExample.OOPHomeWorks;

import java.util.ArrayList;

public class Robots implements Action {
    static final int R_LIMIT = 300;
    private int runDistance;
    private int jumpHeight;
    private String id;

    public Robots(int runDistance, String id) {
        this.id = id;
        if (runDistance < R_LIMIT)
            this.runDistance = runDistance;
        else System.out.println("Robots can't run that long");
    }

    @Override
    public int getJumpHeight() {
        return jumpHeight;
    }

    @Override
    public void jump() {
        System.out.println("Robots can't jump at all!");
    }

    @Override
    public String getName() {
        return id;
    }

    @Override
    public int getRunDistance() {
        return runDistance;
    }

    @Override
    public void run() {
        System.out.println(id+" - Successful run");
    }

    public static ArrayList<Action> createRobots(int range) {
        ArrayList<Action> robots = new ArrayList<>();
        for (int i = 0; i < range; i++) {
            String id = "RobID: " + random.nextInt(99);
            robots.add(new Robots(random.nextInt(Robots.R_LIMIT/2)+R_LIMIT/2,id));
        }
        return robots;
    }
}
