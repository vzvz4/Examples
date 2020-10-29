package InterfacesExample.OOPHomeWorks;

import java.util.ArrayList;

public class Cat implements Action {
    static final int R_LIMIT = 100;
    private int runDistance;
    static final int J_LIMIT = 10;
    private int jumpHeight;
    private String name;

    public Cat(int runDistance, int jumpHeight, String name) {
        this.name = name;
        if (jumpHeight < J_LIMIT)
            this.jumpHeight = jumpHeight;
        else System.out.println("Cats cant jump that height");
        if (runDistance < R_LIMIT)
            this.runDistance = runDistance;
        else System.out.println("Cats can't run that long");
    }

    @Override
    public int getJumpHeight() {
        return jumpHeight;
    }

    @Override
    public void jump() {
        System.out.println("Cat "+name + " - Successful jump on " + jumpHeight + "m");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRunDistance() {
        return runDistance;
    }

    @Override
    public void run() {
        System.out.println("Cat "+name + " - Successful run");
    }

    public static ArrayList<Action> createCats(int range) {
        ArrayList<Action> cats = new ArrayList<>();
        String[] catNames = {"Barsik","Ryjik","Snejok","Pushok","Murzik","Vasya"};
        for (int i = 0; i < range; i++) {
            cats.add(new Cat(random.nextInt(Cat.R_LIMIT/2)+R_LIMIT/2,random.nextInt(Cat.J_LIMIT/2)+J_LIMIT/2,catNames[random.nextInt(catNames.length)]));
        }
        return cats;
    }
}
