package domain.service;

import domain.model.Role;
import domain.model.Team;
import domain.model.User;
import domain.service.DbException;
import domain.service.UserService;
import util.DbConnectionService;

import java.sql.*;
import java.util.ArrayList;

public class UserServiceDBSQL implements UserService {
    private final Connection connection;
    private final String schema;

    public UserServiceDBSQL() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    @Override
    public void addUser(User user) {
        String query = String.format
                ("insert into groep214.user (email,firstname,lastname,team,role,password) values (?,?,?,?,?,?)", schema);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getTeam().getStringValue());
            preparedStatement.setString(5, Role.EMPLOYEE.getStringValue());
            preparedStatement.setString(6, user.getPassword());

            for (User u : this.getAllUsers()) {
                if (u.getEmail().compareTo(user.getEmail()) == 0 && u.getUserid() != user.getUserid()) {
                    throw new DbException("No duplicate emails");
                }
            }
            preparedStatement.execute();


        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(int id) {
        String query = String.format
                ("delete from groep214.user where id=?", schema);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void updateUser(int id, User user) {
        String query = String.format
                ("update groep214.user set email=?,firstname=?,lastname=?,team=?,role=? where id=?", schema);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getTeam().getStringValue());
            preparedStatement.setString(5, user.getRole().getStringValue());
            preparedStatement.setInt(6, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public User getUserWithId(int id) {
        for (User user : this.getAllUsers()) {
            if (user.getUserid() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User checkRealUserAndPassword(String email, String password) {
        for (User u : this.getAllUsers()) {
            if (u.getEmail().compareTo(email)==0){
                if(u.isCorrectPassword(password)){
                    return u;
                }
            }
        }
        throw new DbException("No valid email/password");
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> user = new ArrayList<>();
        String sql = String.format("SELECT * from groep214.user", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {

                int id = result.getInt("id");
                String email = result.getString("email");
                String firstName = result.getString("firstname");
                String lastName = result.getString("lastname");
                Team team = Team.valueOf(result.getString("team").toUpperCase());
                Role role = Role.valueOf(result.getString("role").toUpperCase());
                String password = result.getString("password");

                user.add(new User(id, email, firstName, lastName, team, role, password));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return user;
    }

    /**
     * Check the connection and reconnect when necessary
     *
     * @return the connection with the db, if there is one
     */
    private Connection getConnection() {
        return this.connection;
    }


}
