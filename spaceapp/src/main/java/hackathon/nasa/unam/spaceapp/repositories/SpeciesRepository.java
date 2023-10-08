package hackathon.nasa.unam.spaceapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import hackathon.nasa.unam.spaceapp.models.Species;

public interface SpeciesRepository extends CrudRepository<Species, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM specie WHERE namespecie = :speciesname")
    public List<Species> getSpeciesByName(@Param("speciesname") String name);
}
