package domain.model;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Workorder {
    private int workorderId, userId;

    private String description, employee;
    private Team team;
    private Date date;

    private Time startTime, endTime;

    public Workorder() {
    }

    public Workorder(int workorderId, String employee, String description, Date date, Time startTime, Time endTime, int userId, Team team) {
        this.workorderId = workorderId;
        this.employee = employee;
        this.description = description;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.userId = userId;
        this.team = team;
    }


    //SETTERS
    public void setWorkorderId(int workorderId) {
        this.workorderId = workorderId;
    }

    public void setEmployee(String employee) {
        if (employee == null) {
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

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {

        this.endTime = endTime;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    //GETTERS


    public int getUserId() {
        return userId;
    }

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

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public Time getDuration() {
        Long duration = endTime.getTime() - startTime.getTime();
        return new Time(duration - 3600000);
    }

    //Setter gebruikt in Processing class Register
    public void setEmployeeRequest(HttpServletRequest request, ArrayList<String> errors) {
        User user = (User) request.getSession().getAttribute("user");
        String name = user.getFirstName();
        boolean employeeHasErrors = false;
        try {
            request.setAttribute("employeePreviousValue", name);
            this.setEmployee(name);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            employeeHasErrors = true;
        } finally {
            request.setAttribute("employeeHasErrors", employeeHasErrors);
        }
    }

    public void setDescriptionRequest(HttpServletRequest request, ArrayList<String> errors) {
        String description = request.getParameter("description");
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
        String start = request.getParameter("startTime");
        start += ":00";
        boolean startHasErrors = false;
        try {
            request.setAttribute("startPreviousValue", start);
            this.setStartTime(Time.valueOf(start));
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            startHasErrors = true;
        } finally {
            request.setAttribute("startHasErrors", startHasErrors);
        }
    }

    public void setEndTimeRequest(HttpServletRequest request, ArrayList<String> errors) {
        String endTime = request.getParameter("endTime");
        boolean endHasErrors = false;
        endTime += ":00";
        try {
            request.setAttribute("endPreviousValue", endTime);
            this.setEndTime(Time.valueOf(endTime));
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            endHasErrors = true;
        } finally {
            request.setAttribute("endHasErrors", endHasErrors);
        }
    }

    public void setUserIdRequest(HttpServletRequest request, ArrayList<String> errors) {
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getUserid();
        boolean userIdHasErrors = false;
        try {
            request.setAttribute("userIdPreviousValue", userId);
            this.setUserId(userId);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            userIdHasErrors = true;
        } finally {
            request.setAttribute("userIdHasErrors", userIdHasErrors);
        }
    }

    public void setTeamRequest(HttpServletRequest request, ArrayList<String> errors) {
        User user = (User) request.getSession().getAttribute("user");
        Team team = user.getTeam();
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
}
