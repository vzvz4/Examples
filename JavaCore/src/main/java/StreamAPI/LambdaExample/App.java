package StreamAPI.LambdaExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        //лямбда это анаонимная функция
        //лямбда основана на использовании функционального интерфейса

        TestLambda testLambda = new TestLambda();
        TestLambda.method((x, y) -> x + y);

        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();
        fillArr(arr);
        fillList(list);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(list.toArray()));
//        for (int i = 0; i < 10; i++) {
//            arr[i] = arr[i]*2;
//            list.set(i, list.get(i)*2);
//        }

        //map method
        arr = Arrays.stream(arr).map(a -> a * 2).toArray();
        arr = Arrays.stream(arr).map(a -> a + 3).toArray();
        arr = Arrays.stream(arr).map(a -> ++a).toArray();
        list = list.stream().map(a -> a * 2).collect(Collectors.toList());

        System.out.println("mapArr " + Arrays.toString(arr));
        System.out.println("mapList " + list);


        //filter method
        arr = Arrays.stream(arr).filter(a -> a % 2 == 0).toArray();
        list = list.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        System.out.println("filterArr " + Arrays.toString(arr));
        System.out.println("filterList " + list);

        //for each
        Arrays.stream(arr).forEach(a -> System.out.println(a + " foreachArr"));
        list.stream().forEach(a -> System.out.println(a + " foreachList"));

        //reduce
        int sum = Arrays.stream(arr).reduce((acc, b) -> acc + b).getAsInt();
        int sum2 = list.stream().reduce((acc, b) -> acc + b).get();

        System.out.println("reduce " + sum);
        System.out.println("reduce " + sum2);

        //методы можно группировать в один
        int[] arr2 = new int[10];
        fillArr(arr2);
        System.out.println(Arrays.toString(Arrays.stream(arr2).filter(a -> a % 2 != 0).map(a -> a * 2).toArray()));
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }

}
