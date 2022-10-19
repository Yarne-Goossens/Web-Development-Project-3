package domain.service;

import domain.model.Role;
import domain.model.Team;
import domain.model.User;

import java.util.ArrayList;


public class UserServiceInMemory  {
    private int id = 0;

    private final ArrayList<User> users = new ArrayList<>();

    public UserServiceInMemory() {
        User director = new User("director@ucll.be", "t", "Ad", "Director", Team.ALPHA, Role.DIRECTOR);
        User user = new User("cas.olijslalers@gmaile.com", "t", "AB", "USER", Team.ALPHA,Role.TEAMLEADER);
        //addUser(director);
    }

    /*public void addUser(User user) {
        if (user == null) {
            throw new DbException("No user given");
        }
        if (users.(user.getUserid())) {
            throw new DbException("User already exists");
        }
        for (User u : this.getAll()) {
            if(u.getEmail().compareTo(user.getEmail())==0){
                throw new DbException("No duplicate emails");
            };
        }

        user.setUserid(userid);   // user toevoegen geeft altijd nieuw userid
        users.put(user.getUserid(), user);
        userid++;
    }

    public User getUserWithId(int id) {
        for (User user : users) {
            if (user.getUserid()==id)
                return user;
        }
        return null;
    */

    public ArrayList<User> getAllUsers() {
        return users;
    }


}
