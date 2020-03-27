package InnerClassesExample.FormattedPrintWithInnerClass;

public class Human {

    Students students = new Students(3);

    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

//    @Override
//    public boolean equals(Object h) {
//        if (this != h)
//        return h.age == this.age && h.name.equals(this.name);
//        return true;
//    }

    class Students {
        int course;

        public int getCourse() {
            return course;
        }

        public Students(int course) {
            this.course = course;
        }
    }


}
