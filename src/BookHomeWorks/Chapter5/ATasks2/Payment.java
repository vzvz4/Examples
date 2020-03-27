package BookHomeWorks.Chapter5.ATasks2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Payment {

    private ArrayList<Product> products = new ArrayList<>();

    //id покупки
    private int id;

    //общая стоимость покупки
    private int cost;

    private class Product {
        private String productName;
        private int productCost;

        public Product() {
            productName = "";
            productCost = 0;
        }

        public Product(String productName, int productCost) {
            this.productName = productName;
            this.productCost = productCost;
        }

        public String getProductName() {
            return productName;
        }

        public int getProductCost() {
            return productCost;
        }
    }

    public Payment(int id) {
        this.id = id;
    }

    void addProducts() {
        Scanner sc = new Scanner(System.in);
        String name = "";
        int cost = 0;
        System.out.println("Для завершения списка ведите end");
        while (true) {
            System.out.println("Введите наименование и стоимость товара");
            name = sc.next();
            if (name.equals("end"))
                break;
                System.out.println("Введите стоимость товара");
                cost = sc.nextInt();
            products.add(new Product(name, cost));
        }
        sc.close();
    }

    void printCheck() {
        System.out.println("=======\nпокупка №" + id + "\n=======");
        for (Product p : products) {
            System.out.print(p.productName + " ");
            System.out.println(p.productCost);
            cost += p.productCost;
        }
        System.out.println("=======\nСтоимость " + cost + "\n=======");
    }
}
