package CollectionsExample;
import java.util.ArrayList;
import java.util.List;

public class ArrayListE {
    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            arrList.add(i);
        }
        System.out.println(arrList);
        arrList.forEach(System.out::print);
    }
}
