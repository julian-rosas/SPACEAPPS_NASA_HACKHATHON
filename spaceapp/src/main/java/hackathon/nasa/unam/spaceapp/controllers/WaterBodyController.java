package hackathon.nasa.unam.spaceapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hackathon.nasa.unam.spaceapp.models.WaterBody;
import hackathon.nasa.unam.spaceapp.services.WaterBodyServices;

@RestController
@RequestMapping("/waterbody")
public class WaterBodyController {
    
    @Autowired
    private WaterBodyServices waterBodyServices;


    @PostMapping("/listall")
    public List<WaterBody> listAll(@RequestBody WaterBody waterBody){
        return waterBodyServices.listAll(waterBody);
    }
}
