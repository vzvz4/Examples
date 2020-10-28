package StreamAPI.Stream;


import java.util.*;

public class AppStream {
    //необходимо вычислить все ли буквы из алфавита находятся в предложении
    public static boolean check(String sentence) {
        return sentence.chars()
                .map(Character::toLowerCase) //получаем IntStream символов в нижнем регистре
                .filter(Character::isAlphabetic)//отфильтровываем только символы
                .distinct()//оставляем только уникальные символы
                .count() == 26;//подсчитываем количесвто если оно равно количеству букв в алфавите то все ОК

        //или
//        return sentence.chars()
//                .filter(Character::isLetter)
//                .map(Character::toLowerCase)
//                .distinct()
//                .count() == 26;

        //или
//        return sentence.toLowerCase()
//                .replaceAll("[^a-z]", "")
//                .chars()
//                .mapToObj(ch -> (char) ch)
//                .collect(Collectors.toSet())
//                .size() == 26;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //filter
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);

        List<String> names = Arrays.asList("John", "Jan", "Tirion", "Marry", "Nikolas");
        //подсчет количества
        long count = names.stream()
                .filter(i -> i.length() > 4)
                .count();

        List<Integer[]> stops = new ArrayList<>();
        stops.add(new Integer[]{10, 5});
        int sum = stops.stream()
                .mapToInt(x -> x[0] - x[1])
                .sum();

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList.stream() // получить поток
                .filter(s -> s.startsWith("c")) //отфильтровать значения, оставить те, что начинаются с «с»
                .map(String::toUpperCase)  // преобразовать все значения, перевести в верхний регистр
                .sorted() // отсортировать по порядку (дефолтный порядо)
                .forEach(System.out::println); // вывести каждый элемент на экран


        List<String> names2 = Arrays.asList("john", "arya", "sansa");
//        names2.stream()
//                .map(StringUtils::capitalize)
//                .forEach(System.out::println); //output John Arya Sansa

        List<String> names3 = Arrays.asList("John", "Daenerys", "Tyrion", "", null, "Arya");
        names3.stream()
                .filter(Objects::nonNull)
                .filter(name -> !name.isEmpty() && name.contains("a"))
                .forEach(System.out::println);


        class Car {
            private String number;
            private int year;

            public Car(String number, int year) {
                this.number = number;
                this.year = year;
            }

            public String getNumber() {
                return number;
            }

            public int getYear() {
                return year;
            }
        }

        List<Car> cars = Arrays.asList(
                new Car("AA1111BX", 2007),
                new Car("AK5555IT", 2010),
                new Car(null, 2012),
                new Car("", 2015),
                new Car("AI3838PP", 2017));
        cars.stream()
                .filter(c -> c.getYear() > 2010) // выбираем только машины, выпущенные после 2010 года
                .map(Car::getNumber) // преобразовываем Машины в номера, теперь у нас Stream номеров машин
                .filter(s -> s != null && !s.isEmpty()) // выбираем только не пустые номера
                .limit(2) //ограничение до 2 элементов
                .forEach(System.out::println); // выводим результат


    }
}
