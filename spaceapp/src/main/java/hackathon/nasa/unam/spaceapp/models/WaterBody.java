package hackathon.nasa.unam.spaceapp.models;
import jakarta.persistence.*;

/**
 * Water Body entity class
 */
@Entity
@Table(name = "waterbody")
public class WaterBody {

    /**
     * Water body id, which is the primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "waterbodyid")
    private int id;

    /**
     * Water body name
     */
    @Column(name = "namewaterbody")
    private String nameWaterBody;


    /**
     * Water body type
     */
    @Column(name = "typeof")
    private String typeof;

    /**
     * Water body plants
     */
    @Column(name = "plants")
    private String plants;


    /**
     * Water body animals
     */
    @Column(name = "animals")
    private String animals;

    /**
     * Water quality
     */
    @Column(name = "waterquality")
    private String waterQuality;

    /**
     * Water body longitude coordinate
     */
    @Column(name = "long")    
    private float lng;

    /**
     * Water body latitude coordinate
     */
    @Column(name = "lat")
    private float lat;


    /**
     * Water body organization
     */
    @Column(name = "organization")
    private String organization;

    /**
     * ID getter
     * @return
     */
    public int getID(){
        return this.id; 
    }
    
    /**
     * Name getter
     * @return String
     */
    public String getNameWaterBody(){
        return this.nameWaterBody;
    }

    /**
     * Water body type getter
     * @return String
     */
    public String getTypeOf(){
        return this.typeof;
    }

    /**
     * Plants getter
     * @return String
     */
    public String getPlants(){
        return this.plants;
    }

    /**
     * Animals getter
     * @return String
     */
    public String getAnimals(){
        return this.animals;
    }


    /**
     * Water quality getter
     * @return String
     */
    public String getWaterQuality(){
        return this.waterQuality;
    }


    /**
     * Longitude getter
     * @return float
     */
    public float getLong(){
        return this.lng;
    }


    /**
     * Latitude getter
     * @return
     */
    public float getLat(){
        return this.lat;
    }


    /**
     * Organizations getter
     * @return
     */
    public String getOrganization(){
        return this.organization;
    }   

    /**
     * Id setter
     * @param id
     */
    public void setID(int id){
        this.id = id;
    }

    /**
     * Name setter
     * @param name
     */
    public void setName(String name){
        this.nameWaterBody = name;
    }


    /**
     * Type setter
     * @param type
     */
    public void setTypeOf(String type){
        this.typeof = type;
    }

    /**
     * Plants setter
     * @param plants
     */
    public void setPlants(String plants){
        this.plants = plants;
    }


    /**
     * Animals setter
     * @param animals
     */
    public void setAnimals(String animals){
        this.animals = animals;
    }

    /**
     * Water quality setter
     * @param waterquality
     */
    public void setWaterQuality(String waterquality){
        this.waterQuality = waterquality;
    }

    /**
     * Longitude setter
     * @param lng
     */
    public void setLong(float lng){
        this.lng = lng;
    }

    /**
     * Latitude setter
     * @param lat
     */
    public void setLat(float lat){
        this.lat = lat;
    }

    /**
     * Organization setter
     * @param org
     */
    public void setOrganization(String org){
        this.organization = org;
    }
}
