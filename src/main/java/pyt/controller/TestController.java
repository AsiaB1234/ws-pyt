package pyt.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHelloGet(@RequestParam("name") String name) {
        return "Greeting: test Controller: " + name + "!!!";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public List<Integer> sayHelloPost(@RequestBody List<Integer> values) {
        for (Integer value : values) {
            value += 1;
        }
        return values;
    }
}
