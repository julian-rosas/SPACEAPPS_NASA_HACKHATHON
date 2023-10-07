package hackathon.nasa.unam.spaceapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String hola(){
        return "Hola hakatones :)";
    }
}
