package hackathon.nasa.unam.spaceapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
@Table(name = "specie")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "waterbody")
    private int waterbodyid;

    @Column(name= "namespecie")
    private String name;


    public int getID(){
        return this.id;
    }

    public int getWaterBodyID(){
        return this.waterbodyid;
    }

    public String getName(){
        return this.name;
    }


    public void setID(int id){
        this.id = id;
    }

    public void setWaterBody(int id){
        this.waterbodyid = id;
    }

    public void setName(String name){
        this.name = name;
    }


}
