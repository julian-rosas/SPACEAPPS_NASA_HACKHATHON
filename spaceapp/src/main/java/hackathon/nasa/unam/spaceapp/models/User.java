package hackathon.nasa.unam.spaceapp.models;

import jakarta.persistence.*;

/**
 * User Entity class
 */
@Entity
@Table(name = "userapp")
    public class User {

    /**
     * User ID, which is the primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int id;


    /**
     * User name
     */
    @Column(name = "nameuserapp")
    private String name;

    /**
     * User email
     */
    @Column(name = "mail")
    private String email;

    /**
     * User password
     */
    @Column(name = "userpassword")
    private String password;

    /**
     * Name getter
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * ID getter
     * @return int
     */
    public int getID() {
        return this.id;
    }

    /**
     * Email getter
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Password getter
     * @return String
     */
    public String getPassword() {
        return this.password;
    }


    /**
     * Name setter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ID setter
     * @param id
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Email setter
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Password setter
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
