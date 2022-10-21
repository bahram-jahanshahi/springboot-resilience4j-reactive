package se.bahram.resilience4j.springbootresilience4j.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import se.bahram.resilience4j.springbootresilience4j.services.SimpleService;

@RestController
@RequestMapping("/simple-rest")
public class SimpleRestController {

    private final SimpleService simpleService;

    public SimpleRestController(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    @GetMapping("/call")
    private Mono<String> call() {

        Mono<String> sayHello = simpleService.sayHello();

        return sayHello;
    }
}
