package domain.model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private int userid;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Team team;
    private Role role;

    public User(String email, String password, String firstName, String lastName, Team team,Role role) {
        setEmail(email);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setTeam(team);
        setRole(role);
    }

    public User(int userid, String email, String firstName, String lastName, Team team,Role role) {
        setUserid(userid);
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setTeam(team);
        setRole(role);
    }

    public User(int userid, String email, String firstName, String lastName, Team team,Role role,String password) {
        setUserid(userid);
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setTeam(team);
        setRole(role);
        setPassword(password);
    }

    public User() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setEmail(String email) {
        if (email.isEmpty()) {
            throw new IllegalArgumentException("No email given");
        }
        String USERID_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(USERID_PATTERN);
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new IllegalArgumentException("Email not valid");
        }
        this.email = email;
    }

    public void setEmailRequest(HttpServletRequest request, ArrayList<String> errors) {
        String name = request.getParameter("email");
        boolean emailHasErrors = false;
        try {
            request.setAttribute("emailPreviousValue", name);
            this.setEmail(name);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            emailHasErrors = true;
        } finally {
            request.setAttribute("emailHasErrors", emailHasErrors);
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isCorrectPassword(String password) {
        if (password.isEmpty()) {
            throw new IllegalArgumentException("No password given");
        }
        return getPassword().equals(password);
    }

    public void setPassword(String password) {
        if (password.isEmpty()) {
            throw new IllegalArgumentException("No password given");
        }
        this.password = password;
    }

    //Wordt gecalled in processing classes.
    public void setPasswordRequest(HttpServletRequest request, ArrayList<String> errors) {
        String name = request.getParameter("password");
        boolean passwordHasErrors = false;
        try {
            request.setAttribute("passwordPreviousValue", name);
            this.setPassword(name);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            passwordHasErrors = true;
        } finally {
            request.setAttribute("passwordHasErrors", passwordHasErrors);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("No firstname given");
        }
        this.firstName = firstName;
    }

    public void setFirstNameRequest(HttpServletRequest request, ArrayList<String> errors) {
        String firstName = request.getParameter("firstName");
        boolean firstnameHasErrors = false;
        try {
            request.setAttribute("firstnamePreviousValue", firstName);
            this.setFirstName(firstName);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            firstnameHasErrors = true;
        } finally {
            request.setAttribute("firstnameHasErrors", firstnameHasErrors);
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("No last name given");
        }
        this.lastName = lastName;
    }

    public void setLastNameRequest(HttpServletRequest request, ArrayList<String> errors) {
        String name = request.getParameter("lastName");
        boolean nameHasErrors = false;
        try {
            request.setAttribute("namePreviousValue", name);
            this.setLastName(name);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            nameHasErrors = true;
        } finally {
            request.setAttribute("nameHasErrors", nameHasErrors);
        }
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setTeam(String team) {
        try {
            this.team = Team.valueOf(team.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new DomainException("There is no team with value " + team);
        }
    }

    public void setTeamRequest(HttpServletRequest request, ArrayList<String> errors) {
        String name = request.getParameter("team");
        boolean teamHasErrors = false;
        try {
            request.setAttribute("teamPreviousValue", name);
            this.setTeam(name);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            teamHasErrors = true;
        } finally {
            request.setAttribute("teamHasErrors", teamHasErrors);
        }
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRoleRequest(HttpServletRequest request, ArrayList<String> errors) {
        String r = request.getParameter("role");

        boolean roleHasErrors = false;
        try {
            request.setAttribute("rolePreviousValue", r);
            this.setRole(r);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            roleHasErrors = true;
        } finally {
            request.setAttribute("roleHasErrors", roleHasErrors);
        }
    }


    public void setRole(String role) {
        try {
            this.role = Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new DomainException("There is no role with value " + role);
        }
    }
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + ": " + getUserid() + ", " + getEmail() + ", " + getRole() + ", " + getTeam();
    }
}
