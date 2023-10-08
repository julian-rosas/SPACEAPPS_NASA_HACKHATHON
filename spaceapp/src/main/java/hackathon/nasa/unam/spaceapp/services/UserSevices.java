package hackathon.nasa.unam.spaceapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackathon.nasa.unam.spaceapp.models.User;
import hackathon.nasa.unam.spaceapp.repositories.UserRepository;

@Service
public class UserSevices {

    @Autowired
    UserRepository userRepository;

    public boolean login(User user) {
        System.out.println(user.toString());
        return true;
    }

    public void createUser(User user) {
        System.out.println(user.toString());
        userRepository.save(user);
    }
}
