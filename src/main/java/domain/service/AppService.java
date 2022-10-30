package domain.service;

import domain.model.Project;
import domain.model.User;

import java.util.ArrayList;

public class AppService {
    private UserServiceDBSQL userDB = new UserServiceDBSQL();
    private ProjectServiceDBSQL projectDB = new ProjectServiceDBSQL();
    private WorkorderServiceDBSQL workorderDB = new WorkorderServiceDBSQL();

    //PROJECT
    public void addProject(Project project){
        projectDB.addProject(project);
    }

    public void deleteProject(int id){
        projectDB.deleteProject(id);
    }

    public void updateProject(int id,Project project){
        projectDB.updateProject(id,project);
    }
    public Project getProjectWithId(int id) {
        return projectDB.getProjectWithId(id);
    }

    public ArrayList<Project> getAllProjects(){
       return  projectDB.getAllProjects();
    }

    //WORKORDER




    //USER
    public void addUser(User user) {
        userDB.addUser(user);
    }
    public void deleteUser(int id) {
        userDB.deleteUser(id);
    }
    public void updateUser(int id, User user) {
        userDB.updateUser(id, user);
    }

    public User checkRealUserAndPassword(String email, String password) {
        return userDB.checkRealUserAndPassword(email, password);
    }
    public User getUserWithId(int id) {
        return userDB.getUserWithId(id);
    }
    public ArrayList<User> getAllUsers() {
        return userDB.getAllUsers();
    }
}