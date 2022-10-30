package domain.model;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Project {
    private int projectId;
    private String projectName;
    private Team team;
    private Timestamp start,end;

    public Project(){}

    public Project(int projectId, String projectName,String team, Timestamp start, Timestamp end) {
        this.projectName = projectName;
        this.start = start;
        setTeam(team);
        this.projectId=projectId;
        this.end = end;
    }


    //SETTERS
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public void setTeam(String team) {
        try {
            this.team = Team.valueOf(team.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new DomainException("There is no team with value " + team);
        }
    }
    public void setTeam(Team team) {
        this.team = team;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public void setEnd(Timestamp end) {
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

    public Timestamp getStart() {
        return start;
    }

    public Timestamp getEnd() {
        return end;
    }

    //Setter gebruikt in Processing class Register
    public void setProjectNameRequest(HttpServletRequest request, ArrayList<String> errors) {
        String projectName = request.getParameter("projectName");
        boolean firstnameHasErrors = false;
        try {
            
            request.setAttribute("projectNamePreviousValue", projectName);
            this.setProjectName(projectName);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            firstnameHasErrors = true;
        } finally {
            request.setAttribute("firstnameHasErrors", firstnameHasErrors);
        }
    }

    public void setProjectTeamRequest(HttpServletRequest request, ArrayList<String> errors) {
        String team = request.getParameter("team");
        boolean teamHasErrors = false;
        try {
            request.setAttribute("teamPreviousValue", team);
            this.setTeam(team);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            teamHasErrors = true;
        } finally {
            request.setAttribute("teamHasErrors", teamHasErrors);
        }
    }

    public void setProjectStartDate(HttpServletRequest request, ArrayList<String> errors) {
        String start = request.getParameter("start");

        boolean startHasErrors = false;
        try {
            request.setAttribute("startPreviousValue", start);
            this.setStart(Timestamp.valueOf(start));
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            startHasErrors = true;
        } finally {
            request.setAttribute("startHasErrors", startHasErrors);
        }
    }

    public void setProjectEndDate(HttpServletRequest request, ArrayList<String> errors) {
        String end = request.getParameter("end");
        boolean endHasErrors = false;
        try {
            request.setAttribute("endPreviousValue", end);
            this.setEnd(Timestamp.valueOf(end));
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            endHasErrors = true;
        } finally {
            request.setAttribute("endHasErrors", endHasErrors);
        }
    }
}
