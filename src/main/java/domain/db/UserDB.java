package domain.db;

import domain.model.DomainException;
import domain.model.Team;
import domain.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;

public class UserDB {
    private final ArrayList<User> users = new ArrayList<User>();
    private int sequence = 0;

    public UserDB() {
        this.voegToe(new User(sequence,"bruh@gmail.com","pee","hen","tai",Team.ALPHA));
        this.voegToe(new User(sequence,"bruh@gmail.com","pee","hen","tai",Team.BETA));
        this.voegToe(new User(sequence,"bruh@gmail.com","pee","hen","tai",Team.GAMMA));
    }

    public void voegToe(User user) {
        if (user == null) throw new DomainException("geen geldige user");
        for (User u : users)
        {
            if (user.getEmail().compareTo(u.getEmail()) == 0) {
                throw new DomainException("Geen duplicaat emails mogelijk.");
            }
        }
        this.sequence++;
        users.add(user);
    }
    public ArrayList<User> getAlle() {
        return (ArrayList<User>) this.users;
    }
}
