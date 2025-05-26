package io.appsteer.registry.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceCheckController {
    @GetMapping("/check-resources")
    public String checkResources() {
        return """
            CSS available: <a href="/css/custom-eureka.css">/css/custom-eureka.css</a><br>
            Template available: <a href="/eureka/status">/eureka/status</a>
            """;
    }
}