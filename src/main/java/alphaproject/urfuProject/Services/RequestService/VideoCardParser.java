package alphaproject.urfuProject.Services.RequestService;

import alphaproject.urfuProject.entities.products.VideoCard;
import alphaproject.urfuProject.entities.products.videocardSpecs.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class VideoCardParser {
    public VideoCard parse() {
        Gson gson = new Gson();
        VideoCardAdapter vca = new VideoCardAdapter();
        JsonElement e = vca.getVideoCards("https://leenwood.space/api/videocards");
        JsonObject jsonObj =  e.getAsJsonObject();
        VideoCard vc = new VideoCard();

        ChipManufacturer cm = gson.fromJson(jsonObj.get("ChipManufacturer").getAsJsonObject(), ChipManufacturer.class);
        ConnectionInterface ci = gson.fromJson(jsonObj.get("ConnectionInterface").getAsJsonObject(), ConnectionInterface.class);
        GPU gpu = gson.fromJson(jsonObj.get("GPU").getAsJsonObject(), GPU.class);
        VideoMemoryType vmt = gson.fromJson(jsonObj.get("VideoMemoryType").getAsJsonObject(), VideoMemoryType.class);
        VideoRam vr = gson.fromJson(jsonObj.get("VideoRam").getAsJsonObject(), VideoRam.class);
        VideoVendor vv = gson.fromJson(jsonObj.get("VideoVendor").getAsJsonObject(), VideoVendor.class);
        int bw = jsonObj.get("BusWidth").getAsInt();
        int fn = jsonObj.get("FanNumber").getAsInt();

        vc.setChipManufacturer(cm);
        vc.setConnectionInterface(ci);
        vc.setGpu(gpu);
        vc.setVideoMemoryType(vmt);
        vc.setVideoRam(vr);
        vc.setVideoVendor(vv);
        vc.setBusWidth(bw);
        vc.setFanNumber(fn);

        return vc;

    }
}
