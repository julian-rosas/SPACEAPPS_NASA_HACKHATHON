package hackathon.nasa.unam.spaceapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackathon.nasa.unam.spaceapp.models.User;
import hackathon.nasa.unam.spaceapp.repositories.UserRepository;
import hackathon.nasa.unam.spaceapp.utils.Hash;

/**
 * Service in charge of giving the User entity logic behavior 
 */
@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    /**
     * Login logic for user received information validation.
     * @param user User to validate login
     * @return true if login validations were succesful, false otherwise.
     */
    public boolean login(User user) {
        List<User> usrlist = userRepository.getUserByEmail(user.getEmail());
        if(usrlist.size() == 1){
            String receivedpasswd = user.getPassword();
            String usrpasswd = usrlist.get(0).getPassword();
           return Hash.verifyHash(usrpasswd,receivedpasswd);
        }

        return false;
    }

    /**
     * SignUp logic for user received information.
     * @param user User to register
     */

    public boolean createUser(User user) {
        List<User> users = userRepository.getUserByEmail(user.getEmail());
        
        if(users.size() > 0)
            return false;

        String psswdHash = Hash.hashing(user.getPassword());
        user.setPassword(psswdHash);

        userRepository.save(user);
        return true;
    }
}
