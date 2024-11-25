import java.util.ArrayList;

public class DomainUsers {
    private ArrayList<User> users = new ArrayList<>();

    public boolean containsUser(User newUser) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(newUser.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public boolean addUserToDomain(User newUser) {
        if (!containsUser(newUser)) {

            users.add(newUser);
            return true;
        }
        return false;
    }

    public boolean removeUserFromDomain(User user) {
        return users.remove(user);
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users in domain.");
        } else {
            for (User user : users) {
                System.out.println("Username: " + user.getUsername() +
                        ", Full Name: " + user.getFullName());
            }
        }
    }
}
