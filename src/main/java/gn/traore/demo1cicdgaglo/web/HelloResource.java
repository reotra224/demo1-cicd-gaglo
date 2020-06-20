package gn.traore.demo1cicdgaglo.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloResource {

    @GetMapping("/hello")
    public ResponseEntity sayHello() {
        Map<String, String> data = new HashMap<>();
        data.put("Hello", "Hello my dear TRAORE");
        return ResponseEntity.ok(data);
    }
}
