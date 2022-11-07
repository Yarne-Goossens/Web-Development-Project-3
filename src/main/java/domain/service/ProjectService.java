package domain.service;

import domain.model.Project;
import domain.model.User;

import java.util.ArrayList;

public interface ProjectService {
    void addProject(Project project);

    void deleteProject(int id);

    void updateProject(int id,Project project);

    Project getProjectWithId(int id);

    Project getProjectWithName(String name);
    ArrayList<Project> getAllProjects();
}
