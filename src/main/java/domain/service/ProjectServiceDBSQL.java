package domain.service;

import domain.model.Project;
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

    public void addProject(Project project){
        String query = String.format
                ("insert into groep214.user (name,team,startdate,enddate) values (?,?,?,?)", schema);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getTeam().getStringValue());
            preparedStatement.setString(3, project.getStart().toString());
            preparedStatement.setString(4, project.getEnd().toString());

            if(project.getStart().after(project.getEnd())){
                throw new IllegalArgumentException("startdate should be before the enddate.");
            }
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void deleteProject(int id){
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

    public void updateProject(int id,Project project){
        String query = String.format
                ("update groep214.user set name=?,team=?,startdate=?,enddate=? where id=?", schema);
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

    public ArrayList<Project> getAllProjects(){
        ArrayList<Project> projects = new ArrayList<>();
        String sql = String.format("SELECT * from groep214.project", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {

                int id = result.getInt("id");
                String name = result.getString("name");
                String team = result.getString("team");
                Timestamp startdate = Timestamp.valueOf(result.getString("startdate"));
                Timestamp enddate = Timestamp.valueOf(result.getString("enddate"));

            projects.add(new Project(id,name,team,startdate,enddate));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return projects;
    }
    private Connection getConnection() {
        return this.connection;
    }


}
