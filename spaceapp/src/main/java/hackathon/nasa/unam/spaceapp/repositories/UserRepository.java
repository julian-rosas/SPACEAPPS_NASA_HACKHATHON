package hackathon.nasa.unam.spaceapp.repositories;

import org.springframework.data.repository.CrudRepository;

import hackathon.nasa.unam.spaceapp.models.User;

public interface UserRepository extends CrudRepository<User,Integer>{

    

}
