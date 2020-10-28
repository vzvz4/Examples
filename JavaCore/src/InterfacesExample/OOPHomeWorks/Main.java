package InterfacesExample.OOPHomeWorks;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //проходим препядствия
        obstacleHandler(Cat.createCats(2));
        System.out.println("\nОчередь роботов\n");
        obstacleHandler(Robots.createRobots(2));//роботы не умеют прыгать.
    }

    //метод инициализации препядствий, участников и методов jump и run
    static void obstacleHandler(ArrayList<Action> list) {
        for (Action a : list) {
            for (CourseWall w : CourseWall.createWalls(4)) {
                w.wallInfo();
                w.jumpWall(a);
            }
            System.out.println("-----Jumps over");
            for (CourseRunTrack r : CourseRunTrack.createRunTracks(4)) {
                r.trackInfo();
                r.runTrackRoad(a);
            }
            System.out.println("-----Run over");
            System.out.println("_____________");
        }
    }
}
