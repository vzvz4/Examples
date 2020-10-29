package SortingMethods;

import java.util.Arrays;

public class SortingMethods {

    public static void main(String[] args) {

        String str2 = "ozemanids";
        //System.out.println(str2.substring(1,2));
        String st = str2.substring(str2.length()-3);
        st = st.toUpperCase();
        String pt = str2.substring(0,str2.length()-st.length());
        System.out.println(pt+st);
        //System.out.println(startOz("oz"));

        int b = 3;
        int aDiff = Math.abs(b - 10);
        System.out.println(aDiff);
        int [] a = {7,4,5,9,14,15,2,8};

        int min = a[0];
            for (int i = 1; i<a.length; i++) {
                if (min>a[i]) min = a[i];
            }
        System.out.println(max1020(20,9));
            sortArrays(array);
            bubbleSorting(array);
            insertSort(a);
        System.out.println(everyNth("Vladek", 2));
    }
    public static String everyNth (String str1, int n) {
        String b = "";
        for (int i=0;i<str1.length(); i+=n) {
            b = b + str1.charAt(i);
        }
        return b;
    }

    ///////////////////////////////////
    //обычная сортировка через цикл
    static int [] array = {0,3,2,4,5,1,7,6,9,8};
    public static void sortArrays (int [] arrayToSort) {
        long start = System.nanoTime();
        int indexMin;
        for (int index = 0; index < arrayToSort.length-1; index++) {
            indexMin=index;
            for (int scanIndex = index; scanIndex < arrayToSort.length; scanIndex++) {
                if (arrayToSort[indexMin] > arrayToSort[scanIndex]) {
                    indexMin = scanIndex;
                }
            }
            int temp = arrayToSort[index];
            arrayToSort[index] = arrayToSort[indexMin];
            arrayToSort[indexMin] = temp;
        }
        long stop = System.nanoTime();
        System.out.println(stop-start);
        System.out.println(Arrays.toString(arrayToSort));
    }
    //////////////////////////////////////////////
    //сортировка пузырьком
    public static void bubbleSorting (int [] arrayToSort) {
        long start = System.nanoTime();
        for (int i = 0; i < arrayToSort.length-1; i++) {
            int min;
            for (int b = 0; b < arrayToSort.length - i-1; b++) { //44,23
                if (arrayToSort[b] > arrayToSort[b + 1]) {
                    min = arrayToSort[b + 1];
                    int temp = arrayToSort[b];
                    arrayToSort[b] = min;
                    arrayToSort[b + 1] = temp;
                }
            }
        }
        long stop = System.nanoTime();
        System.out.println(stop-start);
        System.out.println(Arrays.toString(arrayToSort));
    }

    ////////////////////////////////////////
    //сортировка вставками
    public static void insertSort (int [] arrayToSort) {
        long start = System.nanoTime();
        // пройти по массиву
        // выбираем элемент
        // устанавливаем элемент на нужное место в массиве
        int element;
        int index;
        for (int i = 0; i < arrayToSort.length; i++) {
            element = arrayToSort[i];
            index = i;
            while (index>0&&arrayToSort[index-1]>element) {
                arrayToSort[index] = arrayToSort[index-1];
                index--;
                arrayToSort[index] = element;
            }
        }
        long stop = System.nanoTime();
        System.out.println(stop-start);
        System.out.println(Arrays.toString(arrayToSort));
    }

    public static String startOz (String str) {
        String b = "";
        if (str.substring(0,1).equals("o"))
        b = b+ str.substring(0,1);
        if (str.substring(1,2).equals("z"))
        b = b + str.substring(1,2);
        return b;
    }
    public static int max1020(int a, int b) { //21, 19
        // First make it so the bigger value is in a
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }

        // Knowing a is bigger, just check a first
        if (a >= 10 && a <= 20) return a;
        if (b >= 10 && b <= 20) return b;
        return 0;
    }
}
