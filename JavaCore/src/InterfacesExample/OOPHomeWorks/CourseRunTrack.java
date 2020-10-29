package InterfacesExample.OOPHomeWorks;

import java.util.ArrayList;

public class CourseRunTrack {
    private int dist;

    public CourseRunTrack(int dist) {
        this.dist = dist;
    }

    void runTrackRoad(Action a) {
        if (a.getRunDistance() >= dist) {
            a.run();
        } else System.out.println(a.getName() + " - Run failed" + "(" + a.getRunDistance() + "m)");
    }

    void trackInfo() {
        System.out.println("Track distance - " + dist + "m");
    }

    public static ArrayList<CourseRunTrack> createRunTracks(int range) {
        ArrayList<CourseRunTrack> coursesRunTrack = new ArrayList<>();
        for (int i = 0; i < range; i++) {
            int randomTrack = Action.random.nextInt(15) + 35;
            coursesRunTrack.add(new CourseRunTrack(randomTrack));
        }
        return coursesRunTrack;
    }
}
