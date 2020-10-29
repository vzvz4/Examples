package CollectionsExample.MyVersionOfArrayList;

public class App {
    public static void main(String[] args) {
        Col<Integer> col = new Col<>();
        Col<String> col2 = new Col<>(5);
        col.add(3);


        for (int i = 0; i < 20; i++) {
            col.add(i);
            col2.add("--->"+i);
        }


        col.add(555);


        for (String s: col2) {
            System.out.println(s);
        }

    }
}
