package domain.service;

import domain.model.User;

import java.util.ArrayList;

public interface UserServiceI {
    void addUser(User user);


    //User checkRealUserAndPassword(String email,String password);

    //void delete(int id);

    User getUserWithId(int id);

    ArrayList<User> getAllUsers();
}
