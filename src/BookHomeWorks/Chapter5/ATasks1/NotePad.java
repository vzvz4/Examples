package BookHomeWorks.Chapter5.ATasks1;

public class NotePad {
    String name;

    class Date {
        int date;
        public Date(int date) {
            this.date = date;
        }
        void addDate(int date){
            Date date1 = new Date(date);
        }
    }

    class Task {
        String task;

        void showTask() {
            System.out.println(task);
        }

        void addTask(String task) {
            this.task += task;
            System.out.println(this.task);
        }
    }

    void makeTask() {
        Date date = new Date(13);
    }
}
