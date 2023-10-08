package hackathon.nasa.unam.spaceapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import hackathon.nasa.unam.spaceapp.models.WaterBody;

public interface WaterBodyRepository /*extends CrudRepository<WaterBody,Integer>*/ {
    

    @Query("SELECT * FROM waterbody WHERE lat <= :userlat+0.12 AND lat > :userlat-0.12 and long <= :userlong+0.12 AND long > :userlong-0.12")
    public List<WaterBody> getCloser(@Param("userlat") float lat, @Param("userlong") float lng);
}
