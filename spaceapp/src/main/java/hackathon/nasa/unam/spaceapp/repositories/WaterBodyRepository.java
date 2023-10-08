package hackathon.nasa.unam.spaceapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import hackathon.nasa.unam.spaceapp.models.WaterBody;

/**
 * Repository in charge of doing queries regarding Water body database table
 */
public interface WaterBodyRepository extends CrudRepository<WaterBody,Integer> {

    /**
     * Water body getter query
     * @param lat
     * @param lng
     * @return List<Waterbody>
     */
    @Query(nativeQuery = true , value = "SELECT * FROM waterbody WHERE (lat <= (:userlat + 0.12)) AND (lat > :userlat - 0.12) AND (long <= (:userlong + 0.12)) AND (long > :userlong - 0.12)")
    List<WaterBody> getCloser(@Param("userlat") float lat, @Param("userlong") float lng);
}
