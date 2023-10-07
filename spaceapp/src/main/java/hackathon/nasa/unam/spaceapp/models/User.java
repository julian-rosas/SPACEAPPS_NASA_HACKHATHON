package hackathon.nasa.unam.spaceapp.models;
import jakarta.persistence.*;

@Entity
@Table(name = "userApp")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int id;
    
    @Column(name = "nameUserApp")
    private String name;
    
    @Column(name = "mail")
    private String email;
    
    
    @Column(name = "userPassword")
    private String  password;


    public String getName(){
        return this.name;
    }


    public int getID(){
        return this.id;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }


    public void setName(String name){
        this.name = name;
    }


    public void setID(int id){
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }


    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString(){
        return (this.name + " es el nombre " + this.id + " es el id " + this.email + " es el email " + this.password + " es el pswd ");
    }


}
