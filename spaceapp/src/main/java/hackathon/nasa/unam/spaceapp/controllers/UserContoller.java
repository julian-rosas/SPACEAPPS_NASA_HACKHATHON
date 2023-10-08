package hackathon.nasa.unam.spaceapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hackathon.nasa.unam.spaceapp.models.User;
import hackathon.nasa.unam.spaceapp.services.UserSevices;

@RestController
@RequestMapping("/user")
public class UserContoller {
    
    @Autowired
    private UserSevices userServices;

    
    @PostMapping("/create/")
    public void createUser(@RequestBody User user){
        userServices.createUser(user);
    }


    @PostMapping("/login/")
    public boolean login(@RequestBody User user){
        return userServices.login(user);
    }
}
