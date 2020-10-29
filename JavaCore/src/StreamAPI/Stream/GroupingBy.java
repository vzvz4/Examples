package StreamAPI.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingBy {

    static class Human {
        String name, surname;
        int friendsAmount;
        // constructors, getters, etc are omitted
        public Human(String name, String surname, int friendsAmount) {
            this.name = name;
            this.surname = surname;
            this.friendsAmount = friendsAmount;
        }
        public String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", friendsAmount=" + friendsAmount +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human("Ned", "Stark", 1),
                new Human("Robb", "Stark", 2),
                new Human("Arya", "Stark", 1),
                new Human("Aegon", "Targaryen", 6),
                new Human("Daenerys", "Targaryen", 4),
                new Human("Jaime", "Lannister", 1),
                new Human("Tyrion", "Lannister", 3));

        Map<String, List<Human>> map = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname));
        for (Map.Entry<String, List<Human>> entry: map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        //эквивалент без стрима
        Map<String, List<Human>> map2 = new HashMap<>();
        for (Human human : humans) {
            String surname = human.getSurname();
            if (!map2.containsKey(surname)) { // если фамилии еще нет - создаем новый список
                List<Human> humanList = new ArrayList<>();
                humanList.add(human);
                map2.put(surname, humanList);
            } else {                        // если фамилия есть - добавляем представителя семьи =)
                List<Human> humanList = map2.get(surname);
                humanList.add(human);
            }
        }

        //1 сгруппировать
        Map<String, Long> map3 = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname, Collectors.counting()));

        System.out.println(map3);//output {Lannister=2, Targaryen=2, Stark=3}

        System.out.println("-----------------");

        //2 разделить и сгруппировать
        Map<Boolean, List<Human>> map4 = humans.stream()
                .collect(Collectors.partitioningBy(x -> x.friendsAmount > 2));

        map4.values()
                .stream()
                .flatMap(Collection::parallelStream)
                .forEach(System.out::println);
    }
}
