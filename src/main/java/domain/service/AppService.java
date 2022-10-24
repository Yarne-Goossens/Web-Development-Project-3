package domain.service;

import domain.model.User;
import org.postgresql.jdbc.PreferQueryMode;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class AppService {
    private UserServiceDBSQL userDB = new UserServiceDBSQL();

    public void addUser(User user) {
        userDB.addUser(user);
    }

    public void deleteUser(int id) {
        userDB.deleteUser(id);
    }

    public void updateUser(int id, User user) {
        userDB.updateUser(id, user);
    }

    public User getUserWithId(int id) {
        return userDB.getUserWithId(id);
    }

    public User checkRealUserAndPassword(String email, String password) {
        return userDB.checkRealUserAndPassword(email, password);
    }


    public ArrayList<User> getAllUsers() {
        return userDB.getAllUsers();
    }
}