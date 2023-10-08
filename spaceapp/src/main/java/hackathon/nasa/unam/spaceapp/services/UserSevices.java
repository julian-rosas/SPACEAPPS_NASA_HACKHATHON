package hackathon.nasa.unam.spaceapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackathon.nasa.unam.spaceapp.models.User;
import hackathon.nasa.unam.spaceapp.repositories.UserRepository;
import hackathon.nasa.unam.spaceapp.utils.Hash;

/**
 * Service in charge of giving the User entinty logic behavior 
 */
@Service
public class UserSevices {

    @Autowired
    UserRepository userRepository;

    /**
     * Login logic for user received information validation.
     * @param user User to validate login
     * @return true if login validations were succesful, false otherwise.
     */
    public boolean login(User user) {
        List<User> usrlist = userRepository.getUserByEmail(user.getEmail());
        
        if(usrlist.size() > 0){
            String receivedpasswd = user.getPassword();
            String usrpasswd = usrlist.get(0).getEmail();
            
            if(receivedpasswd.equals(usrpasswd) && Hash.verifyHash(receivedpasswd, usrpasswd))
                return true;
                
        }

        return false;
    }

    /**
     * SignUp logic for user received information.
     * @param user User to register
     */

    public boolean createUser(User user) {
        //System.out.println(user.toString());
        List<User> users = (List<User>) userRepository.getUserByEmail(user.getEmail());
        
        if(users.size() > 0)
            return true;

        String psswdHash = Hash.hashing(user.getPassword());
        user.setPassword(psswdHash);

        userRepository.save(user);
        return false;
    }
}
