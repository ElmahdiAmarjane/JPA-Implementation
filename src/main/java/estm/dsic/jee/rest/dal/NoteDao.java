package estm.dsic.jee.rest.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import estm.dsic.jee.rest.models.Note;
import estm.dsic.jee.rest.models.User;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Named
@RequestScoped

@Transactional
public class NoteDao  {
  //      @Resource(lookup = "jdbc/db_notes")
  //         private DataSource dataSource ;
  //   @Override
  //   public boolean create(Note entity) {
  //            String query = "INSERT INTO notes (subject , body ,iduser) VALUES (?,?,?)";
  //         try(Connection connection = dataSource.getConnection()) {
  //              PreparedStatement preparedStatement= connection.prepareStatement(query);
  //              preparedStatement.setString(1, entity.getSubject());
  //              preparedStatement.setString(2, entity.getBody());
  //               preparedStatement.setInt(3,entity.getIduser());
  //               preparedStatement.executeUpdate();
  //                 return true;
  //         } catch (Exception e) {
  //           System.out.println(e);
  //         }
  //        return false;
  //   }

  //   @Override
  //   public Note find(Long index) {
  //  return null;

  //   }

  //   @Override
  //   public boolean delete(Long index) {
  //      String query = "DELETE FROM notes where id = ?";
  //        try(Connection connection = dataSource.getConnection()) {
  //             PreparedStatement preparedStatement=connection.prepareStatement(query);
  //              preparedStatement.setLong(1, index);
  //              preparedStatement.executeUpdate();
  //              return true;
  //        } catch (Exception e) {
  //         System.out.println(e);
  //        }
  //       return false;
  //   }

    
  //   public boolean updateNote(Note entity) {
  //        String query = "UPDATE notes SET body = ? , subject = ? where id = ?";
  //        try (Connection connection = dataSource.getConnection()){
  //            PreparedStatement preparedStatement= connection.prepareStatement(query);
  //                preparedStatement.setString(1, entity.getBody());
  //                preparedStatement.setString(2, entity.getSubject());
  //                preparedStatement.setLong(3, entity.getId());
  //               preparedStatement.executeUpdate();
  //               return true;
  //           } catch (Exception e) {
  //         System.out.println(e);
  //        }
  //      return true;
  //   }

  //   public List<Note> getAll(int iduser) { 
  //     String query = "SELECT * FROM notes where iduser= ?";
  //        try (Connection connection = dataSource.getConnection()){
  //          PreparedStatement preparedStatement = connection.prepareStatement(query);
  //          preparedStatement.setInt(1, iduser);
  //          ResultSet rs = preparedStatement.executeQuery();
  //          List<Note> notes= new ArrayList<>();
  //          while(rs.next()){
  //              Note note = new Note();
  //              note.setId(rs.getLong("id"));
  //              note.setSubject(rs.getString("subject"));
  //              note.setBody(rs.getString("body"));
  //              note.setIduser(rs.getInt("iduser"));
  //              notes.add(note);
              
  //          }
  //          return notes;
  //        } catch (Exception e) {
  //         System.out.println(e);
  //        }
  //        return null;
  //   }

  //   @Override
  //   public boolean update(Note entity, Long index) {
  //     // TODO Auto-generated method stub
  //     throw new UnsupportedOperationException("Unimplemented method 'update'");
  //   }

  //   @Override
  //   public List<Note> getAll() {
  //     // TODO Auto-generated method stub
  //     throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  //   }


 @PersistenceContext(name = "db_notes")
    private EntityManager note;

    // Insert
    public void create(Note n) {
        
        note.persist(n);
    }

    // Search and update
    public void updateNote() {
        Note n = note.find(Note.class, 1);
        if (n != null) {
            //u.setName("new Name");
            note.merge(n);
        }
    }

    // Remove
    public void removeNote() {
        Note n = note.find(Note.class, 1);
        if (n != null) {
          note.remove(n);
        }
    }

    // Select
    public List<Note> getAllNotes() {
        Query q = note.createQuery("SELECT n FROM Note n");
        return q.getResultList();
    }

    
}
