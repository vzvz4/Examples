package Patterns.System.uow;

public class Product extends DomainObject {
    // @Id
    private int id;
    private int price;
    private String title;

    public Product(int id, int price, String title) {
        this.id = id;
        this.price = price;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    protected String getKey() {
        return Integer.toString(id);
    }
}
