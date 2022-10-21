package se.bahram.resilience4j.springbootresilience4j.services;

import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class SimpleService {

    @TimeLimiter(name = "backendA", fallbackMethod = "sayHelloFallBack")
    public Mono<String> sayHello() {

        return Mono.just("Hello there, I am Simple Service!").delayElement(Duration.ofSeconds(10));
    }

    private Mono<String> sayHelloFallBack(Exception e) {
        System.out.println(e.getMessage());
        return Mono.just("Handled the SayHello Exception: " + e.getMessage());
    }
}
