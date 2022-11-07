package domain.service;

import domain.model.Project;
import domain.model.User;
import domain.model.Workorder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public interface UserService {
    void addUser(User user);

    User checkRealUserAndPassword(String email, String password);

    void deleteUser(int id);

    void updateUser(int id,User user);

    User getUserWithId(int id);
    ArrayList<User> getAllUsers();
}
