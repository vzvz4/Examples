package EnumExample;

public class Test {
    private static final int DOG = 0;
    private static final int CAT = 1;
    private static final int FROG = 2;

    public static void main(String[] args) {
        int animal = 100;

        switch (animal) {
            case DOG:
                System.out.println("DOG");
                break;
            case FROG:
                System.out.println("FROG");
                break;
            default:
                System.out.println("Its not an animal");
        }
        AnimalEnum animal1 = AnimalEnum.BIRD;
        switch (animal1) {
            case BIRD:
                System.out.println("its a BIRD");
                break;
            case LION:
                System.out.println("its a LION");
                break;
            case CROCODILE:
                System.out.println("its a CROCODILE");
                break;
        }
        Season season = Season.SUMMER;
        switch (season) {
            case AUTUMN:
                System.out.println("Everything is orange");
                break;
            case SPRING:
                System.out.println("Its warm outside");
                break;
            case SUMMER:
                System.out.println("Omg its so hot outside");
                break;
            case WINTER:
                System.out.println("Winter has come");
                break;
        }
        AnimalEnum animal3 = AnimalEnum.BIRD;
        System.out.println(animal3.getTranslation());

        Season season2 = Season.WINTER;
        season2.getTemperature();

        System.out.println(season2.name());
        System.out.println(Season.valueOf("AUTUMN"));
        System.out.println(season2.ordinal());
    }
}
