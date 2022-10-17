package domain.service;

import domain.model.User;

import java.util.ArrayList;

public interface UserService {
    void addUser(User user);

    User findUserWithName(String naam);

    User checkRealUserAndPassword(String email,String password);

    void delete(int id);

    User get(int id);

    ArrayList<User> getAllUsers();
}
