package hackathon.nasa.unam.spaceapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import hackathon.nasa.unam.spaceapp.models.User;

public interface UserRepository extends CrudRepository<User,Integer>{

    @Query("SELECT * FROM userapp WHERE email = :emailparam")
    public List<User> getUserByEmail(@Param("emailparam") String email);


}
