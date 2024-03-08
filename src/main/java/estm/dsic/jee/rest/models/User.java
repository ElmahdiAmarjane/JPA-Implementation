package estm.dsic.jee.rest.models;

import java.io.Serializable;
import java.util.List;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.mail.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class User implements Serializable{
    
    // private int id ; 
    // private String email;
    // private String password;
    // private Boolean isAdmin;
    // @JsonbProperty("isverify")
    // private boolean isVerify;

    // public boolean getVerify() {
    //     return isVerify;
    // }
    // public void setVerify(boolean isverify) {
    //     this.isVerify = isverify;
    // }
    // public int getId() {
    //     return id;
    // }
    // public void setId(int id) {
    //     this.id = id;
    // }
    // public String getEmail() {
    //     return email;
    // }
    // public void setEmail(String email) {
    //     this.email = email;
    // }
    // public String getPassword() {
    //     return password;
    // }
    // public void setPassword(String password) {
    //     this.password = password;
    // }
    // public boolean isAdmin() {
    //     return isAdmin;
    // }
    // public void setAdmin(boolean isAdmin) {
    //     this.isAdmin = isAdmin;
    // } 

    private static final long serialVersionUID = 1L;

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column

    private String email;

    @Column

    private String password;
    @Column

    private String isAdmin;
    @Column

    private String isVerify;

      @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
         private List<Note> notes;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getIsVerify() {
        return isVerify;
    }

    public void setIsVerify(String isVerify) {
        this.isVerify = isVerify;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    
}
