package alphaproject.urfuProject.entities.products;

import jakarta.persistence.*;

@Entity
public abstract class AbstractProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column()
    private int price;

    @Column()
    private String description;

    @Column()
    private String originalUrl;

    @Column(nullable = false)
    @ManyToOne()
    private Category category;

    @Column(nullable = false)
    private int dateCreate;

    public Long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(int dateCreate) {
        this.dateCreate = dateCreate;
    }
}