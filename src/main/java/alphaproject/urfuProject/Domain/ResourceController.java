package alphaproject.urfuProject.Domain;

import alphaproject.urfuProject.Repositories.VideoCardRepository;
import alphaproject.urfuProject.entities.products.VideoCard;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ResourceController {
    private final VideoCardRepository videoCardRepository;
    @GetMapping("/login")
    public String loginEndpoint() {
        return "Login!";
    }

    @GetMapping("/hello")
    public String helloEndpoint() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "Hello "+auth.getName()+"!" +
                " Your role is "+auth.getAuthorities();
    }
    @GetMapping("/gpu")
    public List<VideoCard> getAllGPU(){
        return videoCardRepository.findAll();
    }
}