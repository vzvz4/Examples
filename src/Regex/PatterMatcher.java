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
    }
}
