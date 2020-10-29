package ReflectionEx;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

public class Ref {

    static class InnerClass {
        private int a;
        private String b;

        public InnerClass() {
        }

        public InnerClass(int a, String b) {
            this.a = a;
        }

        private InnerClass(int a) {
            this.a = a;
        }

        @ExampleInterface
        public int method(int a) {
            System.out.println("METHOD FROM INNER CLASS");
            return a;
        }

        @DefaultAnnotationEx(val = 4)
        public int defMethod(){
            return 0;
        }
    }

    private String str = "Ss";
    public int a = 2;
    private int c;

    public static void main(String[] args) {

        Ref ref = new Ref();

        try {
            Method[] mt1 = Ref.InnerClass.class.getDeclaredMethods();
            Method mt2 = Ref.InnerClass.class.getMethod("defMethod");
            DefaultAnnotationEx df = mt2.getAnnotation(DefaultAnnotationEx.class);
            System.out.println(df.val());


            for (Method m: mt1) {
               if (m.getAnnotation(ExampleInterface.class) != null)
                   System.out.println(m);
            }



            Class<Ref> cl = Ref.class;
            Class<InnerClass> clI = Ref.InnerClass.class;
            Field fd = cl.getDeclaredField("c");
            System.out.println(fd.getInt(ref));
            Constructor<?>[] cons = clI.getConstructors();
            System.out.println(Arrays.toString(cons));
            System.out.println(Ref.InnerClass.class.getDeclaredConstructor(int.class));
            Constructor cons2 = Ref.InnerClass.class.getDeclaredConstructor(int.class);
            System.out.println(cons2.getName());

            Class objClass = Ref.InnerClass.class;
            Constructor constr = Ref.InnerClass.class.getConstructor(int.class, String.class);

            InnerClass inCl = (InnerClass) objClass.newInstance(); //InstantiationException
            //если бы не было конструктора по умолчанию был бы выброшен эксепшн

            InnerClass inCl2 = (InnerClass) constr.newInstance(3,"Stt");
            System.out.println("New Object ----> " + inCl.method(3));
            System.out.println("New Object ----> " + inCl2.b);

            Method m = Ref.InnerClass.class.getMethod("method", int.class); //NoSuchMethodException, SecurityException
            System.out.println("method ----> " + m.getReturnType() + " | " + m.getName() +
                    " | " + Arrays.toString(m.getParameterTypes()));
            m.invoke(new Ref.InnerClass(3), 3); // InvocationTargetException

            //fd.setAccessible(true);
            //изменять final поля нельзя даже при помощи рефлексии
            System.out.println("Invoking --> " + m.invoke(new Ref.InnerClass(3), 3));
            System.out.println(fd.getInt(ref));

        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        Class cl4 = ref.getClass();
        List<Field> fields = Arrays.asList(cl4.getFields());
        System.out.println(fields.size());

        fields.forEach(System.out::println);
        System.out.println(Arrays.toString(cl4.getInterfaces()));
    }

    public void as() {
        System.out.println("s");
    }
}
