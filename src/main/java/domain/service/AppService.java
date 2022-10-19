package domain.service;

import domain.model.User;

import java.util.ArrayList;

public class AppService {
    private UserServiceI users = new UserServiceDBSQL();

    public void addUser(User user) {
        users.addUser(user);
    }

    //public User findAnimalWithName(String naam) {
    //return users.findUserWithName(naam);
    //}

    public ArrayList<User> getAllUsers() {
        return users.getAllUsers();
    }

}
