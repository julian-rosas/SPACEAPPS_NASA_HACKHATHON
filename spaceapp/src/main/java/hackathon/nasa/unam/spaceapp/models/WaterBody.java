package hackathon.nasa.unam.spaceapp.models;
import jakarta.persistence.*;

@Entity
@Table(name = "waterbody")
public class WaterBody {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "waterbodyid")
    private int id;

    @Column(name = "namewaterbody")
    private String nameWaterBody;

    @Column(name = "typeof")
    private String typeof;

    @Column(name = "plants")
    private String plants;

    @Column(name = "animals")
    private String animals;

    @Column(name = "waterquality")
    private String waterQuality;

    @Column(name = "long")    
    private float lng;

    @Column(name = "lat")
    private float lat;

    @Column(name = "organization")
    private String organization;

    public int getID(){
        return this.id; 
    }

    public String getNameWaterBody(){
        return this.nameWaterBody;
    }

    public String getTypeOf(){
        return this.typeof;
    }


    public String getPlants(){
        return this.plants;
    }


    public String getAnimals(){
        return this.animals;
    }


    public String getWaterQuality(){
        return this.waterQuality;
    }


    public float getLong(){
        return this.lng;
    }


    public float getLat(){
        return this.lat;
    }

    public String getOrganization(){
        return this.organization;
    }   

    public void setID(int id){
        this.id = id;
    }

    public void setName(String name){
        this.nameWaterBody = name;
    }

    public void setTypeOf(String type){
        this.typeof = type;
    }

    public void setPlants(String plants){
        this.plants = plants;
    }

    public void setAnimals(String animals){
        this.animals = animals;
    }

    public void setWaterQuality(String waterquality){
        this.waterQuality = waterquality;
    }

    public void setLong(float lng){
        this.lng = lng;
    }

    public void setLat(float lat){
        this.lat = lat;
    }

    public void setOrganization(String org){
        this.organization = org;
    }
}
