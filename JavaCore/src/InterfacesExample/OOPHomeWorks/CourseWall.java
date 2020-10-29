package InterfacesExample.OOPHomeWorks;

import java.util.ArrayList;

public class CourseWall {
    private int height;

    public CourseWall(int height) {
        this.height = height;
    }

    void jumpWall(Action a) {
        if (a.getJumpHeight() >= height) {
            a.jump();
        } else System.out.println(a.getName() + " - Jump failed"+"("+a.getJumpHeight()+"m)");
    }

    void wallInfo() {
        System.out.println("Wall height - " + height + "m");
    }

    public static ArrayList<CourseWall> createWalls(int range) {
        ArrayList<CourseWall> courseWalls = new ArrayList<>();
        for (int i = 0; i < range; i++) {
            int randomWall = Action.random.nextInt(5)+4;
            courseWalls.add(new CourseWall(randomWall));
        }
        return courseWalls;
    }
}
