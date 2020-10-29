package HabrRiddles;

import java.util.Arrays;
import java.util.Random;

public class Ves {
    int [] arrNumbers;
    int [] arrWeight;
    int [] ranges;
    int sum;
    public Ves(int arrNumbers[], int arrWeight[]) {
        this.arrNumbers = arrNumbers;
        this.arrWeight = arrWeight;
        ranges = new int[arrNumbers.length];

        sum = 0;
        for (int w: arrWeight) {
            sum+=w;
        }
        int lastSum = 0;
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = lastSum;
            lastSum+=arrWeight[i];
        }
    }
    @Override
    public String toString(){
        return Arrays.toString(arrNumbers);
    }

    int massives() {
        int random = (int) (Math.random()*(sum-1));
        int ourRange = 0;
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i]>=random)
                break;
            ourRange = i;
        }
      return arrNumbers[ourRange];
    }
//    int massives() {
//        int random = (int) (Math.random()*(sum-1));
//        int index = Arrays.binarySearch(ranges, random);
//        return arrNumbers[index >= 0? index : -index-2];
//    }
}
