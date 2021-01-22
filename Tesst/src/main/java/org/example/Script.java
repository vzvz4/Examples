package org.example;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Script {
    private static final Consumer<Matcher> defaultConsumer =
            x -> System.out.println(x.group(1));
    private static final Consumer<Matcher> verboseRequested =
            defaultConsumer.andThen(x -> System.out.println(x.group(2)));

    public static void main(String... args) throws IOException {
        String result = "[[[\"Я только что анонсировал новый курс Learn Spring посвященный основам Spring\",\"I just announced the new Learn Spring course, focused on the fundamentals of Spring 5 and Sprin\",null,null,3,null,null,[[] ] ,[[[\"cce7c67b3f2439089dd6b428e0b83b88\",\"en_ru_2020q2.md\"] ] ] ] ] ,null,\"en\",null,null,null,1.0,[] ,[[\"en\"] ,null,[1.0] ,[\"en\"] ] ]\n";
        result = result.substring(0, result.indexOf("]"));
//        byte[] arrayData = Files.readAllBytes(Paths.get("/tmp/translator"));
//        String result = new String(arrayData);
//        System.out.println(result);
        
        Pattern pattern = Pattern.compile("\\[\\[\\[\"(.*)\",\"(.*)\",.*");
        Matcher matcher = pattern.matcher(result);
        Consumer<Matcher> consumer = defaultConsumer;

        if (args.length == 1 && (args[0].equals("-v") || args[0].equals("--verbose")))
            consumer = verboseRequested;

        while (matcher.find()) {
            consumer.accept(matcher);
        }
    }
}




