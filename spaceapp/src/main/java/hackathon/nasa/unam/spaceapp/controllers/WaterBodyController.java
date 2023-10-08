package hackathon.nasa.unam.spaceapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import hackathon.nasa.unam.spaceapp.models.WaterBody;
import hackathon.nasa.unam.spaceapp.services.WaterBodyServices;

/**
 * Controller in charge of posting and getting water bodies requests.
 */
@RestController
@RequestMapping("/waterbody")
public class WaterBodyController {
    
    @Autowired
    private WaterBodyServices waterBodyServices;

    /**
     * With the user coordinates, get the closest water bodies
     * @param lat user latitude
     * @param lng user longitude
     * @return list of water of the closest water bodies
     */
    @PostMapping("/listall/{lat}/{lng}")
    public List<WaterBody> listAll(@PathVariable String lat, @PathVariable String lng){
        return waterBodyServices.listAll(lat, lng);
    }
}
