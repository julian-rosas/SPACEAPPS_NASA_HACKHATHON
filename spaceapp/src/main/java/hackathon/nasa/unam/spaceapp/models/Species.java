package hackathon.nasa.unam.spaceapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

/**
 * Species entity class 
 */
@Entity
@Table(name = "specie")
public class Species {
    /**
     * Species ID, which is the primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specieid")
    private int id;

    /**
     * Species associated water body id 
     */
    @Column(name = "waterbodyid")
    private int waterbodyid;

    /**
     * Species name
     */
    @Column(name = "namespecie")
    private String name;

    /**
     * ID getter
     * @return int 
     */
    public int getID() {
        return this.id;
    }

    /**
     * Water body id getter
     * @return int
     */
    public int getWaterBodyID() {
        return this.waterbodyid;
    }

    /**
     * Name getter
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * ID setter
     * @param id 
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Water body id setter
     * @param id
     */
    public void setWaterBody(int id) {
        this.waterbodyid = id;
    }

    /**
     * Name setter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}
