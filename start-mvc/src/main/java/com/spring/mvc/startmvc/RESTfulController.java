package com.spring.mvc.startmvc;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/restful/*")
public class RESTfulController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, RESTful!";
    }

    @RequestMapping("/user/{num}")
    public User getUser(@PathVariable("num") int num) {
        User user = new User();
        user.setId("test");
        user.setNum(num);
        user.setEmail("test@test.com");

        return user;
    }

    @GetMapping("/user1") // localhost:8080/restful/user1?name=test
    public String setUser1(@RequestParam(required = false) String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/user2") // http://localhost:8080/restful/user2?id=test&num=1&email=test@test.com
    public String setUser2(@ModelAttribute User user) {
        return "Hello, " + user.getId() + "!";
    }

    @PostMapping("/user3")
    public String setUser3(@RequestBody Map<String, String> user) {
        return "Hello, " + user.get("id") + "!";
    }
}
