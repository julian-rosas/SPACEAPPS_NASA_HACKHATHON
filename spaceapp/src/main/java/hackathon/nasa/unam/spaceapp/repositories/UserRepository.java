package hackathon.nasa.unam.spaceapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import hackathon.nasa.unam.spaceapp.models.User;
/**
 * Repository in charge of doing queries to the User table in the database.
 */
public interface UserRepository extends CrudRepository<User,Integer>{

    /**
     * User getter query
     * @param email
     * @return List<User>
     */
    @Query(nativeQuery = true , value = "SELECT * FROM userapp WHERE mail = :emailparam")
    public List<User> getUserByEmail(@Param("emailparam") String email);


}
