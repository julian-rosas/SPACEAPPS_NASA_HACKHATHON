package hackathon.nasa.unam.spaceapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hackathon.nasa.unam.spaceapp.models.Species;
import hackathon.nasa.unam.spaceapp.services.SpeciesServices;

/**
 * Controller in charge of posting and getting species requests.
 */
@RestController
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
    private SpeciesServices speciesServices;

    /**
     * Get species information  
     * @param species
     * @return requested species
     */
    @PostMapping("/getSpecie/")
    public Species getSpecies(@RequestBody Species species) {
        Species speciesResult = speciesServices.getSpecies(species);
        if (speciesResult == null)
            throw new IllegalArgumentException("There are not species with that name");
        return speciesResult;
    }

    /**
     * Manages the error BAD_REQUEST.
     * 
     * @param illegalArgumentException the error.
     * @return {@link HttpStatus} BAD_REQUEST with a message.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleCustomException(IllegalArgumentException illegalArgumentException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(illegalArgumentException.getMessage());
    }

}
