package ui.view;

import domain.model.Role;
import domain.model.Team;
import domain.model.User;

import java.sql.*;
import java.util.Properties;

public class AnimalView {

    public static void main(String[] args) {

        // constants for your project
        // replace "webontwerp" by your own database, e.g. '2TX34'
        String url = "jdbc:postgresql://databanken.ucll.be:62223/2TX35";
        // replace 'web3' by your own schema name, e.g. groep102
        String schema = "groep214";


        // set properties for db connection
        Properties properties = new Properties();

        // set user and password
        try {
            Class.forName("ui.view.Secret"); // check if Secret does exist
            Secret.setPass(properties);
        } catch (ClassNotFoundException e) {
            System.out.println("Class ui.view.Secret with credentials not found");
        }

        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("sslmode", "prefer");

        //open the db connection
        try (Connection connection = DriverManager.getConnection(url, properties)) {

            // add an animal
            String query = String.format("insert into groep214.user (email,firstname,lastname,team,role,password) values (?,?,?,?,?,?)", schema);

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "casper.olijslagers@gmail.com");
            preparedStatement.setString(2, "firstname");
            preparedStatement.setString(3, "lastname");
            preparedStatement.setString(4, "ALPHA");
            preparedStatement.setString(5, "DIRECTOR");
            preparedStatement.setString(6, "paswoord");


            preparedStatement.execute();

            //get all animals
            query = String.format("SELECT * FROM groep214.user;", schema);
            PreparedStatement statementInsert = connection.prepareStatement(query);
            ResultSet resultSet = statementInsert.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                Team team = Team.valueOf(resultSet.getString("team"));
                Role role = Role.valueOf(resultSet.getString("role"));
                String password = resultSet.getString("password");

                User user = new User(email, password, firstName, lastName, team, role);
                User user1 = new User();
                System.out.println(user.toString());

            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Connection no succes");
        }
    }

}