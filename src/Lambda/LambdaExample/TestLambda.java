package Lambda.LambdaExample;

import Lambda.LambdaExample.Executable;

public class TestLambda {
    public void method(Executable e) {
        int a = e.execute(5,7);
        System.out.println(a);
    }

}
