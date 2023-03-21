package alphaproject.urfuProject.Domain;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
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
}