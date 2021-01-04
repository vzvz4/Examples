package Test;

import java.util.regex.Pattern;

public class Calendar {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\A\\$2(a|y|b)?\\$(\\d\\d)\\$[./0-9A-Za-z]{53}");
        System.out.println(
                pattern.matcher(
                        "$2y$11$H7RMGWLES6N5MJJYChfu2uXt.agiR5klltgqxw8jvpY6PY/CGTX8e")
                       .matches());

//        data[{Entity}, {Entity}]
//        {
//            "entities" : [{
//                "objectName" : "wallet"
//                "filterBy" : [{"name" : "ethkraken"}]
//                "fieldsToShow" : ["name","pool_balances]
//                "entitiesToShow" : [{
//                    "objectName" : "pool_balances"
//                    "filterBy" : [{"pool" : "hiveon"}]
//                    "fieldsToShow" : ["name", ""]
//                }]
//            }
//        }]


    }
}
