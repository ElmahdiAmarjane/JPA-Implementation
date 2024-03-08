package estm.dsic.jee.rest.business;

import java.io.Serializable;
import java.util.List;

import estm.dsic.jee.rest.dal.UserDao;
import estm.dsic.jee.rest.models.User;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class ImplUserServices implements IUserServices, Serializable {

    @Inject
    private UserDao userDao;

    @Override
    public User auth(User user) {
       // return userDao.auth(user);
       return userDao.getUserByEmail(user.getEmail());
    }

    @Override
    public boolean create(User user) {
         userDao.create(user);
         return true;
    }

    @Override
    public boolean validateUser(boolean validate,User user) {
       // return userDao.validateUser(validate,user.getEmail());
       return false;
    }

    @Override
    public boolean deleteUser(User user) {
        //  return userDao.delete(user.getId());
        return false;
    }

    @Override
    public boolean updateUser(User user, String email) {
          // return userDao.update(user, email);
          return false;
    }

    @Override
    public List<User> getAllUsers() {
        //return userDao.getAll();
        return null;
    }

    @Override
    public List<User> searchUserByEmail(User user) {
        // return userDao.searchUserByEmail(user.getEmail());
        return null;
    }

    @Override
    public boolean accepteUser(User user) {
        // return userDao.accepteUser(user.getId());
       return false;
    }
}
