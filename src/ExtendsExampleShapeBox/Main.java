package ExtendsExampleShapeBox;

public class Main {
    public static void main(String[] args) {
        Box box = new Box(6);
        System.out.println(box.getVolume()+"м3 - получен объем Склада");

        Cube cube = new Cube(4);
        System.out.println(cube.getVolume()+"м3 - получен объем кубика");

        System.out.println(" на склад положили кубик, осталось еще место? "+box.add(cube));
        System.out.println(box.getPlaceTaken()+"м3 занято на складе");
        System.out.println(" на склад положили кубик, осталось еще место? "+box.add(cube));
        System.out.println(box.getPlaceTaken()+"м3 занято на складе");
        System.out.println(" на склад положили кубик, осталось еще место? "+box.add(cube));
        System.out.println(" на склад положили кубик, осталось еще место? "+box.add(cube));
        System.out.println(" на склад положили кубик, осталось еще место? "+box.add(cube));

    }
}
