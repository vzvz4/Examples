package SolveMath;

public class Solver {
    public static double func(double x) {
        return (int) Math.cos(Math.pow(x,5))+Math.pow(x,4)-345.3*x-23;
    }
    public static int solve(int start, int end) {
        if (end-start<=1)
            return start;
        int x = start + (end - start) / 2;
        if (func(start)*func(x) > 0)
            return solve(x,end);
        else return solve(start,x);
    }
    public static void main(String[] args) {
        System.out.println(solve(10,20));
    }
}
