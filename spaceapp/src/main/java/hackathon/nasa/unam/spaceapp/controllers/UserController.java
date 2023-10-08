package hackathon.nasa.unam.spaceapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    public void createUser(@RequestBody User user){
        if(!userServices.createUser(user))
            throw new IllegalArgumentException("Email Already exists");
        
    }

    /**
     * Controller for user login.
     * @param user
     * @return true if user was logged successfully, otherwise false.
     */
    @PostMapping("/login/")
    public void login(@RequestBody User user){
        if(!userServices.login(user))
            throw new IllegalArgumentException("The email or password aren't correct");
    }
        

    /**
     * Manges the error BAD_REQUEST.
     * @param illegalArgumentException the error.
     * @return {@link HttpStatus} BAD_REQUEST with a message.
     * */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleCustomException(IllegalArgumentException illegalArgumentException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(illegalArgumentException.getMessage());
    }
}
