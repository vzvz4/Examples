package Regex;

public class RegularExpression {
    public static void main(String[] args) {
        /*
                http://RegExLib.com

                +  - 1 или более
                *  - 0 или более
                ?  - 0 или 1 символов до
                Например: (123)? - были ли "до" символы 1 2 3
                |  - или
                ^  - отрицание
                .  - любой сивол
                $  - конец строки

                {2} - 2 символа до (\\d{2})
                {2,} - 2 или более символа (\\d{2,})
                {2,4} - от 2 до 4 символа (\\d{2,4})
                (x|y|z) - может быть один из трех
                [] - все возможные символы которые могут встретиться
                Например: [abc] = (a|b|c)
                [a-zA-Z] - все английские буквы
                [0-9] - все цифры
                Например: [^abc] - все символы кроме a b c

                \\d - одна цифра
                \\w - одна буква (\\w = [a-zA-Z])

         */
        String str1 = "123";
        String[] vv = str1.split("(?=[0-9])"); // vv = [1,2,3]
        String a = "-122";
        String b = "122";
        String c = "+122";
        System.out.println(a.matches("(([+\\-])?\\d*)"));
        System.out.println(b.matches("((\\+|-)?\\d*)"));
        System.out.println(c.matches("((\\+|-)?\\d*)"));

        String str = "33awdawd33311awdawdg1234656";
        System.out.println(str.matches("[a-zA-Z31]+\\d+"));

        String url = "http://www.google.com";
        String url4 = "https://com.yandex.com";
        System.out.println(url.matches("https?://(www\\.)?.+\\.(com|ru)"));
        System.out.println(url4.matches("https?://(www\\.)?.+\\.(com|ru)"));

        String f = "123";
        System.out.println(f.matches("\\d{2}"));

    }
}
