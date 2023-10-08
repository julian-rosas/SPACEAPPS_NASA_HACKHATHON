package hackathon.nasa.unam.spaceapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hackathon.nasa.unam.spaceapp.models.WaterBody;

public interface WaterBodyRepository /*extends CrudRepository<WaterBody,Integer>*/ {
    

   // @Query("SELECT * FROM waterbody WHERE ()")
    public List<WaterBody> getCloser();
}
