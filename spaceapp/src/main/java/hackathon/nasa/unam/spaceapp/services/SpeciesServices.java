package hackathon.nasa.unam.spaceapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackathon.nasa.unam.spaceapp.models.Species;
import hackathon.nasa.unam.spaceapp.repositories.SpeciesRepository;

@Service
public class SpeciesServices {
    

    @Autowired
    SpeciesRepository speciesRepository;


    public Species getSpecies(Species species){
        Species sp =  speciesRepository.getSpeciesByName(species.getName());
        return sp;
    }
}
