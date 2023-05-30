package alphaproject.urfuProject.Services.DTO;

import lombok.Data;

@Data
public class VideoCardResponse {
    int id;
    String name;
    int price;
    String currency;
    String videoMemory;
    String typeVideoMemory;
    String chipVendor;
    String busWidth;
    String vendor;
}
