import java.util.Date;

public interface IFUser {
    void setUsername(String username);

    void setFullName(String fullName);

    void setPassword(String password);

    void setLastLoginTime(Date loginTime);

    String getUsername();

    String getFullName();

    Date getLastLoginTime();

    boolean checkPassword(String password);
}
