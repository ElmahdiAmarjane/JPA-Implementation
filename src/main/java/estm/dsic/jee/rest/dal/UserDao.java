package estm.dsic.jee.rest.dal;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import estm.dsic.jee.rest.models.User;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

// @ApplicationScoped
// public class UserDao implements Repository<User,String> {
    
//      @Resource(lookup ="jdbc/db_notes")
//         private DataSource dataSource;

//     // private  Connection connection;
//     //   public UserDao(){
//     //     try {
//     //         connection = dataSource.getConnection();
//     //     } catch (SQLException e) {
//     //         e.printStackTrace();
//     //     }
//     //   }

//     @Override
//     public boolean create(User entity) {

//         String query = "INSERT INTO users (email , password ,isAdmin ) VALUES (?,?,?)";
//           try(Connection connection = dataSource.getConnection()) {
//                PreparedStatement preparedStatement= connection.prepareStatement(query);
//                preparedStatement.setString(1, entity.getEmail());
//                preparedStatement.setString(2, entity.getPassword());
//                preparedStatement.setBoolean(3, false);
//                 preparedStatement.executeUpdate();
//                   return true;
//           } catch (Exception e) {
//             // TODO: handle exception
//           }
//          return false;
//     }
  
    
//     public User auth(User entity) {
//           String query = "SELECT * FROM users where email = ? AND password = ? ;";
//         try (Connection connection = dataSource.getConnection()){
//             PreparedStatement preparedStatement= connection.prepareStatement(query);
//               preparedStatement.setString(1, entity.getEmail());
//               preparedStatement.setString(2, entity.getPassword());
//               ResultSet result = preparedStatement.executeQuery();
//               if(result.next()){
//                 User user = new User();
//                  user.setEmail(result.getString("email"));
//                  user.setVerify(result.getBoolean("isverify"));
//                  user.setAdmin(result.getBoolean("isAdmin"));
//                  user.setId(result.getInt("id"));
//                  return user;
//               } 
//         } catch (SQLException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         }

   
//     return null;
//  }

//     @Override
//     public User find(String index) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'find'");
//     }

    
//     public boolean delete(int index) {
//           String query="DELETE FROM users WHERE id=?";
//           try (Connection connection = dataSource.getConnection()){
//               PreparedStatement preparedStatement =connection.prepareStatement(query);
//               preparedStatement.setInt(1, index);
//               preparedStatement.executeUpdate();
//               return true;
//           } catch (Exception e) {
//             System.out.println(e);
//           }
//           return false;
//     }

//     @Override
//     public boolean update(User entity, String index) {
//       String query = "UPDATE USERS SET  email = ? , password=? WHERE email=?";
       
//          try (Connection connection = dataSource.getConnection()) {
//            PreparedStatement preparedStatement=  connection.prepareStatement(query);
//           preparedStatement.setString(1, entity.getEmail());
//           preparedStatement.setString(2, entity.getPassword());
//           preparedStatement.setString(3, index);
//           preparedStatement.executeUpdate();
//           return true;
//           } catch (Exception e) {
//            System.out.println(e);
//          }
//          return false ; 
//     }

    
//     public boolean validateUser(boolean validate,String email) {
//           String query = "UPDATE USERS SET isverify=? where email=?";
//         try(Connection connection = dataSource.getConnection()) {
//             PreparedStatement preparedStatement=connection.prepareStatement(query);
//           preparedStatement.setBoolean(1, validate);
//           preparedStatement.setString(2, email);
//           preparedStatement.executeUpdate();
//           return true;
//         } catch (Exception e) {
//             System.out.println(e);
//         }

//         return false;
//     }

//     @Override
//     public List<User> getAll() {
//            String query = "SELECT * FROM users";
//           try(Connection connection = dataSource.getConnection()) {
//            PreparedStatement preparedStatement= connection.prepareStatement(query);
//           ResultSet rs = preparedStatement.executeQuery();
//             List<User> users = new ArrayList<>();
//             while(rs.next()){
//               User user = new User();
//                 user.setEmail(rs.getString("email"));
//                 user.setPassword(rs.getString("password"));
//                 user.setVerify(rs.getBoolean("isverify"));
//                 user.setAdmin(rs.getBoolean("isAdmin"));
//                 user.setId(rs.getInt("id"));
//                 users.add(user);
//             }
//             return users;
//           } catch (Exception e) {
//              System.out.println(e);
//           }
//           return null;
//     }


//     @Override
//     public boolean delete(String index) {
//       // TODO Auto-generated method stub
//       throw new UnsupportedOperationException("Unimplemented method 'delete'");
//     }
    
//     public List<User> searchUserByEmail(String email){
//           String query = "SELECT * FROM USERS WHERE email LIKE ? ";     
//           try (Connection connection = dataSource.getConnection()){
//              PreparedStatement preparedStatement= connection.prepareStatement(query);
//              preparedStatement.setString(1, "%" + email + "%");
//              ResultSet rs = preparedStatement.executeQuery();
//              List<User> users = new ArrayList<>();
//              while(rs.next()){
//                User user = new User();
//                  user.setEmail(rs.getString("email"));
//                  user.setPassword(rs.getString("password"));
//                  user.setVerify(rs.getBoolean("isverify"));
//                  user.setAdmin(rs.getBoolean("isAdmin"));
//                  user.setId(rs.getInt("id"));
//                  users.add(user);
//              }
//              return users;
//             } catch (Exception e) {
//             // TODO: handle exception
//           }
//           return null;

//     }
        
//     public boolean accepteUser(int iduser){
//            String query = "UPDATE USERS SET isverify = true WHERE id = ?"  ;
//            try(Connection connection = dataSource.getConnection()) {
//                PreparedStatement preparedStatement = connection.prepareStatement(query);
//                 preparedStatement.setInt(1, iduser);
//                 preparedStatement.executeUpdate();
//                 return true;
//               } catch (Exception e) {
//                 System.out.println(e);
//            }
//            return false;
//     }
          
// }
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
@Named
@RequestScoped

@Transactional
public class UserDao {

    @PersistenceContext(name = "db_notes")
    private EntityManager em;

    // Insert
    public void create(User u) {
        em.persist(u);
    }

    // Search and update
    public void updateUser() {
        User u = em.find(User.class, 1);
        if (u != null) {
            //u.setName("new Name");
            em.merge(u);
        }
    }

    // Remove
    public void removeUser() {
        User u = em.find(User.class, 1);
        if (u != null) {
            em.remove(u);
        }
    }

    // Select
    public List<User> getAllUsers() {
        Query q = em.createQuery("SELECT u FROM User u");
        return q.getResultList();
    }

    // Find user by email
    public User getUserByEmail(String email) {
      String queryString = "SELECT u FROM User u WHERE u.email = :email";
      Query query = em.createQuery(queryString, User.class);
      query.setParameter("email", email);

      List<User> userList = query.getResultList();

      if (!userList.isEmpty()) {
          return userList.get(0); // Return the first user with the specified email
      }

      return null; // Return null if no user is found
  }
}
