package Regex;

public class Split {
    public static void main(String[] args) {
        String a = "split this";
        String [] b = a.split(" ");

        System.out.println(a.replaceAll("\\S","w"));
    }
}
