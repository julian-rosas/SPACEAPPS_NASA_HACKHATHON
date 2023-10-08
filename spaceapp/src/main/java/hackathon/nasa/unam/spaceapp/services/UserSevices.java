package hackathon.nasa.unam.spaceapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackathon.nasa.unam.spaceapp.models.User;
import hackathon.nasa.unam.spaceapp.repositories.UserRepository;

@Service
public class UserSevices {

    @Autowired
    UserRepository userRepository;

    public boolean login(User user) {
        List<User> usrlist = userRepository.getUserByEmail(user.getEmail());
        
        if(usrlist.size() > 0){
            String receivedpasswd = user.getPassword();
            String usrpasswd = usrlist.get(0).getEmail();
            
            return (usrpasswd.equals(receivedpasswd));
        }

        return false;
    }

    public void createUser(User user) {
        System.out.println(user.toString());
        userRepository.save(user);
    }
}
