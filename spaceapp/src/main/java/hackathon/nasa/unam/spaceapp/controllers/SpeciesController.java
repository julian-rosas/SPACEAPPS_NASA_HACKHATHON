package hackathon.nasa.unam.spaceapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hackathon.nasa.unam.spaceapp.models.Species;
import hackathon.nasa.unam.spaceapp.services.SpeciesServices;

@RestController
@RequestMapping("/species")
public class SpeciesController {
    

    @Autowired
    private SpeciesServices speciesServices;


    @GetMapping("/getSpecie/")
    public Species getSpecies(@RequestBody Species species){
        return speciesServices.getSpecies(species);
    }

    

}
