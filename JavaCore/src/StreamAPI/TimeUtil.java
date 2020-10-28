package StreamAPI;

import java.util.Arrays;

public class TimeUtil {

    @FunctionalInterface
    private interface ExecuteMethod {
        void process();

        default ExecuteMethod combineOperation(ExecuteMethod... executeMethod) {
            return () -> {
                process();
                Arrays.stream(executeMethod).forEach(ExecuteMethod::process);
            };
        }

        static long execute(ExecuteMethod method) {
            long start = System.currentTimeMillis();
            method.process();
            return System.currentTimeMillis() - start;
        }
    }


    public static void main(String[] args) {
        ExecuteMethod executeMethod1 = () -> ExecuteMethod.execute(TimeUtil::testMethod);
        ExecuteMethod executeMethod2 = () -> ExecuteMethod.execute(TimeUtil::testMethod);
        System.out.println(ExecuteMethod.execute(executeMethod1.combineOperation(executeMethod2,executeMethod1,executeMethod2)));
    }

    public static void testMethod() {
        int[] array = new int[1000000];
        Arrays.fill(array, 10);
    }
}
