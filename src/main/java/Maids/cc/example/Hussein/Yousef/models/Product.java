package Maids.cc.example.Hussein.Yousef.models;




import javax.persistence.*;

@Entity
@Table(name = "prodcuts")
public class Product  extends AuditModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "product_id")
    Long id;

    @Column(name = "product_name")
    String name;

    @Column(name = "category")
    String category;

    @Column(name = "description")

    String description;

    @Column(name = "price")

    Double price;


    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
