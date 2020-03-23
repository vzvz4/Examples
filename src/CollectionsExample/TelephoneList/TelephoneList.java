package CollectionsExample.TelephoneList;

import java.util.ArrayList;
import java.util.List;

public class TelephoneList {
    private List<Users> hm;

    public TelephoneList() {
        hm = new ArrayList<>();
    }

    private static class Users {
        private String surname;
        private Integer number;

        Users(String surname, Integer number) {
            this.surname = surname;
            this.number = number;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return "UserName - " + surname + ": TelNumber - " + number;
        }
    }

    void add(Users e) {
        hm.add(e);
    }

    void get(String s) {
        for (Users users : hm) {
            if (s.equals(users.getSurname()))
                System.out.println(users);
        }
    }

    public static void main(String[] args) {
        TelephoneList telList = new TelephoneList();

        telList.add(new TelephoneList.Users("User1", 123));
        telList.add(new TelephoneList.Users("User1", 1234));
        telList.add(new TelephoneList.Users("User2", 12345));

        telList.get("User1");
    }

}
