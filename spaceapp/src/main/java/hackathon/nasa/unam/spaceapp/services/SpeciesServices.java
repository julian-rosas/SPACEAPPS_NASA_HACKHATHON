package hackathon.nasa.unam.spaceapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackathon.nasa.unam.spaceapp.models.Species;
import hackathon.nasa.unam.spaceapp.repositories.SpeciesRepository;

/**
 * Service in charge of giving the Species entity logic behavior
 */
@Service
public class SpeciesServices {

    @Autowired
    SpeciesRepository speciesRepository;

    /**
     * Species getter logic
     * @param species
     * @return Species
     */
    public Species getSpecies(Species species) {
        List<Species> sp = speciesRepository.getSpeciesByName(species.getName());

        if (sp.size() == 0) {
            return null;
        }
        return sp.get(0);
    }
}
