package Arlgorithms;

import java.util.Arrays;

public class FindNumberWithDivisionBy2 {
    public static void main(String[] args) {
        String []str = "adolf igor ivan".split(" ");
        int[] arr = {11,562,223,1234,885,688,799,855, 14, 15, 854, 856};
        int[] arr2 = new int[233];
        for (int i = 0; i < arr2.length ; i++) {
            arr2[i] = i;
        }
        System.out.println(get(arr2, 231));
    }

    static int get(int []arr, int number) {
        System.out.println(" : " + number);
        Arrays.sort(arr);
        int rows = 0;
        int temp = arr.length;
        int index = 0;
        while (arr[index] != number && temp != 0) {
            temp = temp/2;
            if (arr[index] < number)
                index += temp;
            else index --;
            System.out.println(++rows);
            System.out.println(arr[index]);
        }

        System.out.println(Arrays.toString(arr));
        return index;
    }
}
