package Test;


import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;

public class App {

//    [1,3,5,6]

    public static void main(String[] args) {
        double d = (double) 9/10;
        System.out.print(d);
        List<Integer> list = new ArrayList<>(Arrays.asList(1,3,4,5,6));
        list.add(3);
        System.out.println(list);
    }
    public int searchInsert(int[] nums, int target) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (target > nums[i]) {
                if (target == nums[i])
                    return i;
            } else return i;
        }
        return i;
    }
}
