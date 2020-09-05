package owpk;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "catalog")
@Data
public class POJOClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name= "cost")
    private String cost;

    @Column(name = "description")
    private String description;

    public POJOClass() {

    }

    public POJOClass(String name, String cost, String description) {
        this.name = name;
        this.cost = cost;
        this.description = description;
    }


    @Override
    public String toString() {
        return "POJOClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                '}';
    }
}
