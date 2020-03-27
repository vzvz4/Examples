package Test;


public class App {

    public static void main(String[] args) {
        String str = "/signUp user";
        System.out.println(str.substring(8));

        String i = "";
        String str1 = " жду указаний ";
        String b = str1;
                b = b.concat(str1);

        System.out.println(i.hashCode()+" "+b.hashCode());
        System.out.println(str1.hashCode());

        i.concat("Я джун").concat(str1);
        i.concat("я мидл ").concat(str1);
        b = i;
        System.out.println(b.hashCode());
        b = b.concat(i).concat(" я сеньер").concat(str1);
        System.out.println(i + b);

        byte a = -1;
        System.out.println((char) a);
    }
}
