package Patterns.Creational.Builder;

public class Client {
    public static void main(String[] args) {
        Director director = new Director();
        Website website = director.buildWebSite(new VisitCardWebSiteBuilder());
        System.out.println(website);
    }
}
