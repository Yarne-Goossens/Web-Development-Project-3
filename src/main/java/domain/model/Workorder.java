package domain.model;

import net.bytebuddy.asm.Advice;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.time.Duration;
import java.time.Instant;
public class Workorder {
    private int workorderId;

    private String description,employee;
    private Team team;
    private Date date;

    private Time startTime,endTime;

    public Workorder() {
    }

    public Workorder(int workorderId, String employee, String description, Date date, Time startTime, Time endTime) {
        this.workorderId = workorderId;
        this.employee = employee;
        this.description = description;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    //SETTERS
    public void setWorkorderId(int workorderId) {
        this.workorderId = workorderId;
    }

    public void setEmployee(String employee) {
        if (employee==null) {
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
        if(startTime==null){
            throw new IllegalArgumentException("start time is empty");
        }
        this.startTime=startTime;

    }

    public void setEndTime(Time endTime) {
        if(endTime==null|| endTime.before(startTime)){
            throw new IllegalArgumentException("end time is empty");
        }
        this.endTime=endTime;
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

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public Time getDuration() {
        Long duration=endTime.getTime()-startTime.getTime();
        return new Time(duration);
    }

    //Setter gebruikt in Processing class Register
    public void setEmployeeRequest(HttpServletRequest request, ArrayList<String> errors) {
        String employee = request.getParameter("user");
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

        boolean startHasErrors = false;
        try {
            request.setAttribute("startPreviousValue", start);
            this.setStartTime(Time.valueOf(start));
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            startHasErrors = true;
        }catch (NullPointerException nul) {
            errors.add(nul.getMessage());
            startHasErrors = true;
        }
        finally {
            request.setAttribute("startHasErrors", startHasErrors);
        }
    }

    public void setEndTimeRequest(HttpServletRequest request, ArrayList<String> errors) {
        String endTime = request.getParameter("endTime");
        boolean endHasErrors = false;
        try {
            request.setAttribute("endPreviousValue", endTime);
            this.setEndTime(Time.valueOf(endTime));
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            endHasErrors = true;
        }
        catch (NullPointerException nul) {
            errors.add(nul.getMessage());
            endHasErrors = true;
        }
        finally {
            request.setAttribute("endHasErrors", endHasErrors);
        }
    }
}
