package co.davidguimaraes.basicsecuritydemo.resources;

import co.davidguimaraes.basicsecuritydemo.models.Hello;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainResource {

    @GetMapping(value = "/hello/json", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Hello hello(){
        return new Hello(1L, "Hello!");
    }

    @GetMapping(value = "/hello/xml", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public Hello hello2(){
        return new Hello(1L, "Hello!");
    }
}
