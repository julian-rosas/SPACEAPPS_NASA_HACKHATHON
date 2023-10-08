package hackathon.nasa.unam.spaceapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hackathon.nasa.unam.spaceapp.models.User;
import hackathon.nasa.unam.spaceapp.services.UserServices;

/**
 * User controller in charge of posting and getting user oriented requests.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserServices userServices;

    /**
     * Controller for creating user
     * @param user
     */
    @PostMapping("/create/")
    public boolean createUser(@RequestBody User user){
        return userServices.createUser(user);
    }

    /**
     * Controller for user login.
     * @param user
     * @return true if user was logged successfully, otherwise false.
     */
    @PostMapping("/login/")
    public boolean login(@RequestBody User user){
        return userServices.login(user);
    }
}
