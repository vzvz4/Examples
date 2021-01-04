package Generics;

public class Generic <T> {
    private T obj;

    public Generic(T obj) {
        this.obj = obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    void showTYpe() {
        System.out.println(obj.getClass());
    }

    public static void main(String[] args) {
        Generic<Integer> digit = new Generic<>(3);
        Generic<String> word = new Generic<>("Java");
        digit.showTYpe();
        word.showTYpe();
        System.out.println(digit.getObj());
        System.out.println(word.getObj());
        String value = word.getObj();
        //digit.setObj("java");

        DoubleGeneric<Integer,String> dd = new DoubleGeneric<>(1, 3);
    }
}
class DoubleGeneric <T,V extends String> {
    private T[] obj;
    private V[] obj1;
    private T objF;
    private V obj1F;

    public DoubleGeneric(V... obj1) {
        this.obj1 = obj1;
    }

    public DoubleGeneric(T... obj) {
        this.obj = obj;
    }

    public DoubleGeneric(T objF, V obj1F) {
        this.objF = objF;
        this.obj1F = obj1F;
    }

    public T[] getObj() {
        return obj;
    }

    public void setObj(T[] obj) {
        this.obj = obj;
    }

    public V[] getObj1() {
        return obj1;
    }

    public void setObj1(V[] obj1) {
        this.obj1 = obj1;
    }

    public T getObjF() {
        return objF;
    }

    public void setObjF(T objF) {
        this.objF = objF;
    }

    public V getObj1F() {
        return obj1F;
    }

    public void setObj1F(V obj1F) {
        this.obj1F = obj1F;
    }
}
