package domain.service;

import domain.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceOld {
    private final Map<Integer, User> users = new HashMap<Integer, User>();
    private int userid = 1;    // als je later werkt jmet externe databank, wordt dit userid automatisch gegenereerd

    public UserServiceOld() {

    }

    public User get(int userid) {
        return users.get(userid);
    }

    public List<User> getAll() {
        return new ArrayList<User>(users.values());
    }

    public void add(User user) {
        if (user == null) {
            throw new DbException("No user given");
        }
        if (users.containsKey(user.getUserid())) {
            throw new DbException("User already exists");
        }
        for (User u : this.getAll()) {
            if (u.getEmail().compareTo(user.getEmail()) == 0) {
                throw new DbException("No duplicate emails");
            }
        }

        user.setUserid(userid);   // user toevoegen geeft altijd nieuw userid
        users.put(user.getUserid(), user);
        userid++;
    }

    public void update(User user, int id) {
        if (user == null) {
            throw new DbException("No user given");
        }
        if (!users.containsKey(user.getUserid())) {
            throw new DbException("No user found");
        }
        for (User u : this.getAll()) {
            if (u.getEmail().compareTo(user.getEmail()) == 0 && u.getUserid() != user.getUserid()) {
                throw new DbException("No duplicate emails");
            }
        }
        users.put(id, user); // user updaten: userid blijft behouden
    }

    public void delete(int userid) {
        users.remove(userid);   // userid gaat verloren, maar wordt niet ingenomen door eventuele nieuwe user
    }

    public User checkRealUserAndPassword(String email, String password) {
        for (User u : this.getAll()) {
            if (u.getEmail().compareTo(email) == 0) {
                if (u.isCorrectPassword(password)) {
                    return u;
                }
            }
        }
        throw new DbException("No valid email/password");
    }

    public int getNumberOfUsers() {
        return users.size();
    }
}
