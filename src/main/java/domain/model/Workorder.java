package domain.model;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;

public class Workorder {
    private int workorderId;
    private String employee, description;
    private Team team;
    private Date date, startTime, endTime;

    public Workorder() {
    }

    public Workorder(int workorderId, String employee, String description, String team, Date date, Date startTime, Date endTime) {
        this.workorderId = workorderId;
        this.employee = employee;
        this.description = description;
        setTeam(team);
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    //SETTERS
    public void setWorkorderId(int workorderId) {
        this.workorderId = workorderId;
    }

    public void setEmployee(String employee) {
        if (employee.isEmpty()) {
            throw new IllegalArgumentException("No employee given");
        }
        this.employee = employee;
    }

    public void setDescription(String description) {
        if (description.isEmpty()) {
            throw new IllegalArgumentException("No description given");
        }
        this.description = description;
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

    public void setDate(Date date) {
        try {
            this.date = date;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }

    }

    public void setStartTime(Date startTime) {
        try {
            this.startTime = startTime;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }

    }

    public void setEndTime(Date endTime) {
        try {
            this.endTime = endTime;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    //GETTERS


    public int getWorkorderId() {
        return workorderId;
    }

    public String getEmployee() {
        return employee;
    }

    public String getDescription() {
        return description;
    }

    public Team getTeam() {
        return team;
    }

    public Date getDate() {
        return date;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    //Setter gebruikt in Processing class Register
    public void setEmployeeRequest(HttpServletRequest request, ArrayList<String> errors) {
        String employee = request.getParameter("projectName");
        boolean employeeHasErrors = false;
        try {
            request.setAttribute("employeePreviousValue", employee);
            this.setEmployee(employee);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            employeeHasErrors = true;
        } finally {
            request.setAttribute("employeeHasErrors", employeeHasErrors);
        }
    }

    public void setDescriptionRequest(HttpServletRequest request, ArrayList<String> errors) {
        String description = request.getParameter("projectName");
        boolean descriptionHasErrors = false;
        try {
            request.setAttribute("descriptionPreviousValue", description);
            this.setDescription(description);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            descriptionHasErrors = true;
        } finally {
            request.setAttribute("descriptionHasErrors", descriptionHasErrors);
        }
    }

    public void setWorkorderTeamRequest(HttpServletRequest request, ArrayList<String> errors) {
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

    public void setWorkorderDateRequest(HttpServletRequest request, ArrayList<String> errors) {
        String date = request.getParameter("date");
        boolean dateHasErrors = false;
        try {
            request.setAttribute("datePreviousValue", date);
            this.setDate(Date.valueOf(date));
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            dateHasErrors = true;
        } finally {
            request.setAttribute("dateHasErrors", dateHasErrors);
        }
    }

    public void setStartTimeRequest(HttpServletRequest request, ArrayList<String> errors) {
        String start = request.getParameter("start");

        boolean startHasErrors = false;
        try {
            request.setAttribute("startPreviousValue", start);
            this.setStartTime(Date.valueOf(start));
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            startHasErrors = true;
        } finally {
            request.setAttribute("startHasErrors", startHasErrors);
        }
    }

    public void setEndTimeRequest(HttpServletRequest request, ArrayList<String> errors) {
        String end = request.getParameter("end");
        boolean endHasErrors = false;
        try {
            request.setAttribute("endPreviousValue", end);
            this.setEndTime(Date.valueOf(end));
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            endHasErrors = true;
        } finally {
            request.setAttribute("endHasErrors", endHasErrors);
        }
    }
}
