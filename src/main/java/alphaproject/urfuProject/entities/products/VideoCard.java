package alphaproject.urfuProject.entities.products;

import alphaproject.urfuProject.entities.products.videocardSpecs.*;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoCard extends AbstractProduct {
    @Column
    private VideoRam videoRam;

    @Column
    private int busWidth;

    @Column
    private VideoMemoryType videoMemoryType;

    @Column
    private ChipManufacturer chipManufacturer;

    @Column
    private VideoVendor videoVendor;

    @Column
    private GPU GPU;

    @Column
    private ConnectionInterface connectionInterface;

    @Column
    private int fanNumber;
}
