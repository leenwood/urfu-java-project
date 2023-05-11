package alphaproject.urfuProject.entities.products;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public abstract class AbstractProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int price;

    private String description;

    private String name;

    private String originalUrl;

    @JoinColumn(nullable = false)
    @ManyToOne()
    private Category category;

    private int dateCreate;
}