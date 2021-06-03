package Patterns.Behavioral.Memento.Ex1;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        int delay = 5000;

        SimpleObject simpleObject = new SimpleObject(2, "Hive");
        History<SimpleObject> history = new History<>();

        history.push(simpleObject); // 1 Add origin object to history

        System.out.printf("Object %s is going to do something...\n", simpleObject);
        Thread.sleep(delay);

        simpleObject.doSomethingUseful(2); //2 Changing object state

        history.push(simpleObject); //3 Push changed state to history

        System.out.println();

        // ----------------------------

        System.out.printf("OOps we broke something in our object, this is it now: %s\n", simpleObject);
        Thread.sleep(delay);
        System.out.println("Trying to restore it back...");

        history.undo(); //4 Returning first state

        Thread.sleep(delay);
        System.out.printf("Here is your object %s\n\n", simpleObject);

        // ----------------------------

        Thread.sleep(delay);
        System.out.println("Ahh its ok nothing to worry about! we can keep any state");
        Thread.sleep(delay);
        System.out.println("Returning last state...");

        history.redo(); //5 Returning last state

        Thread.sleep(delay);
        System.out.printf("Here is your object %s\n\n", simpleObject);
    }
}
