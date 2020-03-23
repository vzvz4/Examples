package HomeWork;

import java.util.ArrayList;
import java.util.Random;

public class Peoples {

    static class Employee {
        private String name;
        private String email;
        private String telNumber;
        private int pay;
        private int age;

        Employee(String name, String email, String telNumber, int pay, int age) {
            this.name = name;
            this.email = email;
            this.telNumber = telNumber;
            this.pay = pay;
            this.age = age;
        }

        int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Employee " + name +": "+ "\n"+
                    "email: '" + email + '\'' +
                    ", telNumber: '" + telNumber + '\'' +
                    ", pay: " + pay +
                    ", age: " + age +"\n_____________________";
        }

        void setPay(int pay) throws Exception {
            if (pay > 0) {
                this.pay = pay;
            } else throw new Exception("setPay - Wrong pay");
        }

        void showInfo() {
            System.out.println("Info for - " + name + ": \n" + "Email: " + email + "\nTelephone number: " + telNumber + "\nPay: " + pay + "\nAge: " + age);
        }
    }

    public static ArrayList filterBiggerThan40(Employee[] people) {
        ArrayList<Employee> employeesList = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            if (people[i].getAge()>40) {
                employeesList.add(people[i]);
            }
        }
        return employeesList;
    }

    public static Employee[] createPersons(int n) {
        Random rand = new Random();
        Employee empArr[] = new Employee[n];
        String name[] = {"Danya", "Sasha", "Vasya", "Kolya", "Dima", "Oleg", "Denis", "Anton", "Victor","Mikhail"};
        String eMail = "@email.com";
        for (int i = 0; i < n; i++) {
            empArr[i] = new Employee(name[rand.nextInt(name.length-1)], name[rand.nextInt(name.length-1)]+eMail, "8914" + rand.nextInt(999) + rand.nextInt(9999), rand.nextInt(3000), 24 + rand.nextInt(45));
        }
        return empArr;
    }

    public static void main(String[] args) {
        ArrayList empListBiggerThen40 = filterBiggerThan40(createPersons(10));
        for (Object e : empListBiggerThen40) {
            System.out.println(e);
        }
    }
}


