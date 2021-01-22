package org.example;

import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {

   public static void main(String[] args) {
       String data = "[[[\"Отобразите перевод с помощью Zenity (что позволяет копировать текст) вместо использования уведомлений на рабочем столе:\",\"Display the translation with Zenity (which allows the text to be copied) instead of using desktop notifications:\",null,null,3,null,null,[[]\n" +
               "]" +
               ",[[[\"cce7c67b3f2439089dd6b428e0b83b88\",\"en_ru_2020q2.md\"]" +
               "]\n" +
               "]\n" +
               "]\n" +
               "]\n" +
               ",null,\"en\",null,null,null,1.0,[]\n" +
               ",[[\"en\"]\n" +
               ",null,[1.0]\n" +
               ",[\"en\"]\n" +
               "]\n" +
               "]";
       String a = "asd";
       String ptrn_ = "\\[\\[\\[\"(.*)\",\"(.*)\",.*";
       System.out.println(data.matches(ptrn_));
       Pattern pattern = Pattern.compile(ptrn_);
       Matcher matcher = pattern.matcher(data);
       Consumer<Matcher> consumer = o -> {
           System.out.println(o.group(1));
           System.out.println(o.group(2));
       };

       while (matcher.find()) {
            consumer.accept(matcher);
       }

   }
}
