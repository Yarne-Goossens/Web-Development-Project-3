package domain.service;

import domain.model.Role;
import domain.model.Team;
import domain.model.User;
import util.DbConnectionService;

import java.sql.*;
import java.util.ArrayList;

public class UserServiceDBSQL implements UserServiceI {
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
            preparedStatement.setString(5, user.getRole().getStringValue());
            preparedStatement.setString(6,user.getPassword());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    @Override
    public User getUserWithId(int id) {
        return null;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> animals = new ArrayList<>();
        String sql = String.format("SELECT * from %s.animal", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String email = result.getString("email");
                String firstName = result.getString("firstname");
                String lastName = result.getString("lastname");
                Team team = Team.valueOf(result.getString("team"));
                Role role = Role.valueOf(result.getString("role"));
                String password = result.getString("password");


                animals.add(new User(id,email,firstName,lastName,team,role,password));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return animals;
    }

    /**
     * Check the connection and reconnect when necessery
     * @return the connection with the db, if there is one
     */
    private Connection getConnection() {
        return this.connection;
    }





}
