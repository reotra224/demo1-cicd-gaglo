package gn.traore.demo1cicdgaglo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello my DEAR TRAORE";
    }
}
