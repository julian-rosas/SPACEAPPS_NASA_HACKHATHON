package hackathon.nasa.unam.spaceapp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackathon.nasa.unam.spaceapp.models.WaterBody;
import hackathon.nasa.unam.spaceapp.repositories.WaterBodyRepository;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class WaterBodyServices {
   
     @Autowired WaterBodyRepository waterBodyRepository;

     public List<WaterBody> listAll(String lat, String lng) {
         float latf = Float.parseFloat(lat);
         float lngf = Float.parseFloat(lng);
         return waterBodyRepository.getCloser(latf, lngf);
     }
}
