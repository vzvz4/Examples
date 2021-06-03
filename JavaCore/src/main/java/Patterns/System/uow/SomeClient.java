package Patterns.System.uow;

import Patterns.System.identitymap.IdentityMap;

public class SomeClient {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            UnitOfWork.newCurrent();
            Product product = new Product(1, 2, "Phone");
            product.markNew();
            Product product1 = new Product(2, 3, "Jeans");
            product1.markNew();
            UnitOfWork.getCurrent().commit();
        });

        Thread t2 = new Thread(() -> {
            UnitOfWork.newCurrent();
            Product product = new Product(1, 15, "IPhone");
            product.markNew();
            Product product1 = new Product(10, 3, "Jeans");
            product1.markNew();
            UnitOfWork.getCurrent().commit();
        });

        Thread t3 = new Thread(() -> {
            UnitOfWork.newCurrent();
            Product fromDB = (Product) FictionDataBase.get("4");
            fromDB.setPrice(300);
            fromDB.setTitle("Keanu Reeves");
            fromDB.markDirty();
            UnitOfWork.getCurrent().commit();
        });
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("-------------------------------");
        IdentityMap.getInstance().printCurrentCache();
        System.out.println("-------------------------------");

    }
}
