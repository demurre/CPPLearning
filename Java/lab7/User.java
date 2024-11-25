import java.util.Date;

public class User implements IFUser {
    private String username;
    private String fullName;
    private String password;
    private Date lastLoginTime;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastLoginTime(Date loginTime) {
        this.lastLoginTime = loginTime;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
