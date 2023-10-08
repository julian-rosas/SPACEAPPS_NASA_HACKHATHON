package hackathon.nasa.unam.spaceapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import hackathon.nasa.unam.spaceapp.models.WaterBody;
import hackathon.nasa.unam.spaceapp.services.WaterBodyServices;

@RestController
@RequestMapping("/waterbody")
public class WaterBodyController {
    
    @Autowired
    private WaterBodyServices waterBodyServices;

    @PostMapping("/listall/{lat}/{lng}")
    public List<WaterBody> listAll(@PathVariable String lat, @PathVariable String lng){
        return waterBodyServices.listAll(lat, lng);
    }
}
