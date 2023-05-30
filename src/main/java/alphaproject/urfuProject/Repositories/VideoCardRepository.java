package alphaproject.urfuProject.Repositories;

import alphaproject.urfuProject.entities.products.VideoCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoCardRepository extends JpaRepository<VideoCard, Long> {
    List<VideoCard> findVideoCardsById(long id);

    List<VideoCard> findVideoCardsByName(String name);

    List<VideoCard> findVideoCardsByPrice(long price);

    Page<VideoCard> findAllByName(String name, Pageable pageable);
}