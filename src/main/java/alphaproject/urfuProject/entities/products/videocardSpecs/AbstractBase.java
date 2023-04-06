package alphaproject.urfuProject.entities.products.videocardSpecs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractBase {
    @Id
    private Long id;

    private String name;

    private String description;

    private String alias;
}
