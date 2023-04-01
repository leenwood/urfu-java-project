package alphaproject.urfuProject.entities.products.videocardSpecs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public abstract class AbstractBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column()
    @Getter
    @Setter
    private String name;

    @Column()
    @Getter
    @Setter
    private String description;

    @Column()
    @Getter
    @Setter
    private String alias;
}
