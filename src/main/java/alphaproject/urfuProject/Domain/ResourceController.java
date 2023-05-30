package alphaproject.urfuProject.Domain;

import alphaproject.urfuProject.Services.DTO.ResponseDto;
import alphaproject.urfuProject.Services.DTO.VideoCardResponse;
import alphaproject.urfuProject.Services.VideoCardService;
import alphaproject.urfuProject.entities.products.VideoCard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@EnableSpringDataWebSupport
public class ResourceController {
    private final VideoCardService videoCardService;

    @GetMapping("/login")
    public String loginEndpoint() {
        return "Login!";
    }

    @GetMapping("/hello")
    public String helloEndpoint() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "Hello " + auth.getName() + "!" +
                " Your role is " + auth.getAuthorities();
    }

    @GetMapping("/g")
    public Page<VideoCard> getPage() {
        return videoCardService.getPage(0, 1);
    }

    @GetMapping("/gpu")
    public List<VideoCard> getAllGPU() {
        return videoCardService.getAllVideoCards();
    }

    @GetMapping("/gpu2")
    public String getAllGPUs() {
        return videoCardService.getAllVideoCardsString();
    }

    @GetMapping("/updateGpu")
    public Object updateGpu() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "https://leenwood.space/api/open/videocards/";
        ResponseEntity<ResponseDto> response = restTemplate.getForEntity(resourceUrl, ResponseDto.class);
        ObjectMapper mapper = new ObjectMapper();
        //JsonNode root = mapper.readTree(response);
        // JsonNode name = root.path("name");
        var DAOlistVideCards = response.getBody();
        for (var videocard:DAOlistVideCards.getVideocards()
             ) {

        }

        return DAOlistVideCards;
    }
}
