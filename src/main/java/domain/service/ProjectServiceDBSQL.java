package domain.service;

import domain.model.Project;
import domain.model.Team;
import util.DbConnectionService;

import java.sql.*;
import java.util.ArrayList;


public class ProjectServiceDBSQL implements ProjectService {
    private final Connection connection;
    private final String schema;

    public ProjectServiceDBSQL() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    public void addProject(Project project) {
        String query = String.format
                ("insert into groep214.project (name,team,startdate,enddate) values (?,?,CAST(? AS date),CAST(? AS date))", schema);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getTeam().getStringValue());
            preparedStatement.setString(3, project.getStart().toString());
            preparedStatement.setString(4, project.getEnd().toString());

            if (project.getStart().after(project.getEnd())) {
                throw new DbException("startdate should be before the enddate.");
            }
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void deleteProject(int id) {
        String query = String.format
                ("delete from groep214.project where id=?", schema);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void updateProject(int id, Project project) {
        String query = String.format
                ("update groep214.project set name=?,team=?,startdate=CAST(? AS date),enddate=CAST(? AS date) where id=?", schema);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getTeam().getStringValue());
            preparedStatement.setString(3, project.getStart().toString());
            preparedStatement.setString(4, project.getEnd().toString());
            preparedStatement.setInt(5, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Project getProjectWithId(int id) {
        for (Project p : this.getAllProjects()) {
            if (p.getProjectId() == id) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Project> getAllProjectsTemplate(String sql) {
        ArrayList<Project> projects = new ArrayList<>();

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {

                int id = result.getInt("id");
                String name = result.getString("name");
                String team = result.getString("team");
                Date startdate = Date.valueOf(result.getString("startdate"));
                Date enddate = Date.valueOf(result.getString("enddate"));

                projects.add(new Project(id, name, team, startdate, enddate));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return projects;
    }


    public ArrayList<Project> getAllProjects() {
        String sql = String.format("SELECT * from groep214.project", schema);

        return getAllProjectsTemplate(sql);
    }

    public ArrayList<Project> getAllProjectsOrderedByName() {
        String sql = String.format("SELECT * from groep214.project order by name", schema);

        return getAllProjectsTemplate(sql);
    }

    public ArrayList<Project> getAllProjectsRestrictedByTeam(Team team) {
        String sql = String.format("SELECT * from groep214.project where team=" + "'" + team.getStringValue().toLowerCase() + "'", schema);

        return getAllProjectsTemplate(sql);
    }

    public Project getProjectWithName(String name) {
        for (Project p : getAllProjects()) {
            if (p.getProjectName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    private Connection getConnection() {
        return this.connection;
    }


}
