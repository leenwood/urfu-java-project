package alphaproject.urfuProject.Services;

import alphaproject.urfuProject.Repositories.VideoCardRepository;
import alphaproject.urfuProject.entities.products.VideoCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VideoCardService {
    private final VideoCardRepository videoCardRepository;

    public List<VideoCard> getByName(String name){
        // Предобработка..
        return videoCardRepository.findVideoCardsByName(name);
    }

    public List<VideoCard> getById(Long id){
        // Предобработка..
        return videoCardRepository.findVideoCardsById(id);
    }

    public List<VideoCard> getByPrice(int price){
        // Предобработка..
        return videoCardRepository.findVideoCardsByPrice(price);
    }

    public void save(VideoCard videoCard){
        videoCardRepository.save(videoCard);
    }
}
