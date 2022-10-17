package domain.service;

import domain.model.Animal;
import domain.model.User;
import util.DbConnectionService;

import java.sql.*;
import java.util.ArrayList;

public class UserServiceDBSQL implements UserService {
    private final Connection connection;
    private final String schema;

    public AnimalServiceDBSQL() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    @Override
    public void addUser(User animal) {
        String query = String.format
                ("insert into groep214.user (email,firstname,lastname,team,role,password) values (?,?,?,?,?,?)", schema);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, "casper.olijslagers@gmail.com");
            preparedStatement.setString(2, "firstname");
            preparedStatement.setString(3, "lastname");
            preparedStatement.setString(4, "ALPHA");
            preparedStatement.setString(5, "DIRECTOR");
            preparedStatement.setString(6, "paswoord");

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    @Override
    public User findUserWithName(String naam) {
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
                String name = result.getString("name");
                String type = result.getString("type");
                int food = result.getInt("food");
                animals.add(new Animal(id, name, type, food));
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
