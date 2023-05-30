package alphaproject.urfuProject.Services;

import alphaproject.urfuProject.Repositories.VideoCardRepository;
import alphaproject.urfuProject.entities.products.VideoCard;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VideoCardService {
    private final VideoCardRepository videoCardRepository;

    public List<VideoCard> getAllVideoCards() {
        // Предобработка..
        return videoCardRepository.findAll();
    }

    public String getAllVideoCardsString() {
        // Предобработка..
        var cards = videoCardRepository.findAll();
        StringBuilder res = new StringBuilder();
        for (var card : cards
        ) {
            res.append(card.toString());
        }
        return res.toString();
    }

    public List<VideoCard> getTenVideoCards() {
        return videoCardRepository.findAll().subList(10, (1)* 10L > videoCardRepository.count()
                                                                    ? (int)videoCardRepository.count()
                                                                    : (+1)*10);
    }

    public List<VideoCard> getByName(String name) {
        // Предобработка..
        return videoCardRepository.findVideoCardsByName(name);
    }

    public Page<VideoCard> getPage(int start, int end) {
        return videoCardRepository.findAll(PageRequest.of(start,end));
    }

    public List<VideoCard> getById(Long id) {
        // Предобработка..
        return videoCardRepository.findVideoCardsById(id);
    }

    public List<VideoCard> getByPrice(int price) {
        // Предобработка..
        return videoCardRepository.findVideoCardsByPrice(price);
    }

    public void save(VideoCard videoCard) {
        videoCardRepository.save(videoCard);
    }
}
