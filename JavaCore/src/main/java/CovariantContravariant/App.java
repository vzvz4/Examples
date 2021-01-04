package CovariantContravariant;


import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

//        Формально, ковариантность/контравариантность типов – это сохранение/обращение порядка наследования для производных типов.
//        Проще говоря, когда у ковариантных сущностей типами-параметрами являются родитель и наследник,
//        они сами становятся как бы родителем и наследником. Контравариантные наоборот, становятся наследником и родителем.


//        Ковариантность: List<Integer> можно присвоить в переменную типа List<? extends Number> (как будто он наследник List<Number>).
//        Контравариантность: в качестве параметра метода List<Number>#sort типа Comparator<? super Number>
//        может быть передан Comparator<Object> (как будто он родитель Comparator<Number>)

//        Отношение типов «можно присвоить» – не совсем наследование, такие типы называются совместимыми (отношение «is a»).
//
//        Существует еще одно связанное понятие – инвариантность. Инвариантность – это отсутствие свойств ковариантности и контрвариантности.
//        Дженерики без вайлдкардов инвариантны: List<Number> нельзя положить ни в переменную типа List<Double>, ни в List<Object>.

        //Ковариантность <? extends Number> - любой тип наследником которого является тип Number
        List<? extends Number> listA = new ArrayList<>();
        List<Integer> listAA = new ArrayList<>();
        listA.add(null);

        listAA.add(3);
        listA = listAA;


        //Контравариантность <? super Integer> - любой тип от которого наследуется тип Integer
        List<? super  Integer> listB = new ArrayList<>();
        List<Number> listBB = new ArrayList<>();
        listB.add(3);
        listBB.add(3L);
        listB = listBB;

        //Инвариантность - только тот тип который объявлен в дженерике
        List<Integer> listC = new ArrayList<>();
        List<Number> listCC = new ArrayList<>();
        //listC = listCC; error



        List<? extends Integer> a = new ArrayList<Integer>();
        List<? super Integer> b = new ArrayList<Integer>();
        //a.add(3);    // fails; let’s try with null
        a.add(null); // works
        b.add(3);    // no problem here
        Integer ai = a.get(0); // no problem here either
        //Integer bi = b.get(0); // fails; let’s try with Object
        Object o = b.get(0);   // works

    }
}
