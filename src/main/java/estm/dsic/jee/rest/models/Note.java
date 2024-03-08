package estm.dsic.jee.rest.models;


import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Note implements Serializable {
    //  private Long id ; 
    //  private String subject;
    //  private String body;
    //  private int iduser;
    //  private LocalDateTime created_at ;
    //  private LocalDateTime updated_at ; 


    //  public LocalDateTime getCreated_at() {
    //     return created_at;
    // }
    // public void setCreated_at(LocalDateTime created_at) {
    //     this.created_at = created_at;
    // }

    // public LocalDateTime getUpdated_at() {
    //     return updated_at;
    // }
    // public void setUpdated_at(LocalDateTime updated_at) {
    //     this.updated_at = updated_at;
    // }
    // public Long getId() {
    //     return id;
    // }
    // public void setId(Long id) {
    //     this.id = id;
    // }
  
  
    // public String getSubject() {
    //     return subject;
    // }
    // public void setSubject(String subject) {
    //     this.subject = subject;
    // }
    // public String getBody() {
    //     return body;
    // }
    // public void setBody(String body) {
    //     this.body = body;
    // }
    // public int getIduser() {
    //     return iduser;
    // }
    // public void setIduser(int iduser) {
    //     this.iduser = iduser;
    // }

    private static final long serialVersionUID = 1L;

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column

    private String subject;

    @Column

    private String body;


   @ManyToOne
   @JoinColumn(name = "user_id") 
    private User user;


    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }


    
    
     
}
