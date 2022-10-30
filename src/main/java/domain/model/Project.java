package domain.model;

import java.time.LocalDate;
import java.util.Locale;

public class Project {
    private int projectId;
    private String projectName;
    private Team team;
    private Role role;
    private LocalDate start,end;

    public Project(){}

    public Project( String projectName, LocalDate start, LocalDate end) {
        this.projectName = projectName;
        this.start = start;
        this.end = end;
    }


    //SETTERS
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    //GETTERS
    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public Team getTeam() {
        return team;
    }

    public Role getRole() {
        return role;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }
}
