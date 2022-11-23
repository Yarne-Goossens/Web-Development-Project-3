package domain.service;

import domain.model.Workorder;
import util.DbConnectionService;

import java.sql.*;
import java.util.ArrayList;

public class WorkorderServiceDBSQL implements WorkorderService{
    private final Connection connection;
    private final String schema;
    public WorkorderServiceDBSQL() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    public void addWorkorder(Workorder workorder){
        String query = String.format
                ("insert into groep214.workorder (employee,description,date,starttime,endtime) values (?,?,CAST(? AS date),CAST(? AS time),CAST(? AS time))", schema);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, workorder.getEmployee());
            preparedStatement.setString(2, workorder.getDescription());
            preparedStatement.setString(3, workorder.getDate().toString());
            preparedStatement.setString(4, workorder.getStartTime().toString());
            preparedStatement.setString(5, workorder.getEndTime().toString());

            if(workorder.getStartTime().after(workorder.getEndTime())){
                throw new DbException("starttime should be before the endtime.");
            }
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void deleteWorkorder(int id){
        String query = String.format
                ("delete from groep214.workorder where id=?", schema);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void updateWorkorder(int id,Workorder workorder){
        String query = String.format
                ("update groep214.workorder set employee=?,description=?,date=CAST(? AS date),starttime=CAST(? AS time),endtime=CAST(? AS time) where id=?", schema);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, workorder.getEmployee());
            preparedStatement.setString(2, workorder.getDescription());
            preparedStatement.setString(3, workorder.getDate().toString());
            preparedStatement.setString(4, workorder.getStartTime().toString());
            preparedStatement.setString(5, workorder.getEndTime().toString());
            preparedStatement.setInt(6, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Workorder getWorkorderWithId(int id) {
        for (Workorder w : this.getAllWorkorders()) {
            if (w.getWorkorderId() == id) {
                return w;
            }
        }
        return null;
    }

    public ArrayList<Workorder> getAllWorkorders(){
        ArrayList<Workorder> workorders = new ArrayList<>();
        String sql="";
            sql = String.format("SELECT * from groep214.workorder", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String employee = result.getString("employee");
                String description = result.getString("description");
                Date date = Date.valueOf(result.getString("date"));
                Time starttime = Time.valueOf(result.getString("starttime"));
                Time endtime = Time.valueOf(result.getString("endtime"));

                workorders.add(new Workorder(id,employee,description,date,starttime,endtime));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return workorders;
    }

    public ArrayList<Workorder> getAllWorkordersOrderedByEmployee(){
        ArrayList<Workorder> workorders = new ArrayList<>();
        String sql="";
        sql = String.format("SELECT * from groep214.workorder order by employee", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String employee = result.getString("employee");
                String description = result.getString("description");
                Date date = Date.valueOf(result.getString("date"));
                Time starttime = Time.valueOf(result.getString("starttime"));
                Time endtime = Time.valueOf(result.getString("endtime"));

                workorders.add(new Workorder(id,employee,description,date,starttime,endtime));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return workorders;
    }

    private Connection getConnection() {
        return this.connection;
    }
}
