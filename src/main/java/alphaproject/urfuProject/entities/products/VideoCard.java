package alphaproject.urfuProject.entities.products;

import alphaproject.urfuProject.entities.products.videocardSpecs.*;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@Entity
public class VideoCard extends AbstractProduct {
    @ManyToOne
    private VideoRam videoRam;

    private int busWidth;

    @ManyToOne
    private VideoMemoryType videoMemoryType;

    @ManyToOne
    private ChipManufacturer chipManufacturer;

    @ManyToOne
    private VideoVendor videoVendor;

    @ManyToOne
    private GPU gpu;

    @ManyToOne
    private ConnectionInterface connectionInterface;

    private int fanNumber;
}
