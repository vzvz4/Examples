package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatterMatcher {
    public static void main(String[] args) {
        String str = "Hello Guys, how are you today? fine can i go now? ok no you this is my emal if you need\n" +
                "Keep in touch oleg@email.ru and ok i can pop you another one here it is spina@alrosa.com";

        Pattern email = Pattern.compile("(\\w+)@(\\w+)\\.(com|ru)");
                                         //id1    id2      id3
        Matcher matcher = email.matcher(str);

        //скобки образуют group id который можно передать в параметр методу group();

        while(matcher.find()) {
            System.out.println(matcher.group(2));
        }
//-------------------------------------------------------------------------------
        Pattern pattern = Pattern.compile("a*b");
        Matcher matcher2 = pattern.matcher("aabtextaabtextabtextb the end");
        StringBuffer buffer = new StringBuffer();

        while (matcher2.find()) {
            matcher2.appendReplacement(buffer, "-");
            // buffer = "-" -> "-text-" -> "-text-text-" -> "-text-text-text-"
        }
        matcher2.appendTail(buffer);
        System.out.println(buffer.toString());
//-------------------------------------------------------------------------------
        String text = "Егор Алла Анна";
        Pattern pattern2 = Pattern.compile("А.+?а");
        Matcher matcher3 = pattern2.matcher(text);
        while (matcher3.find()) {
            int start = matcher3.start();
            int end = matcher3.end();
            System.out.println("Найдено совпадение " + text.substring(start,end) + " с "+ start + " по " + (end-1) + " позицию");
        }
        System.out.println(matcher3.replaceFirst("Ира"));
        System.out.println(matcher3.replaceAll("Ольга"));
        System.out.println(text);
    }
    }
