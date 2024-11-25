public class ServerDomain extends Host {
    private String domainName;
    private DomainHosts domainHosts = new DomainHosts();
    private DomainUsers domainUsers = new DomainUsers();

    public ServerDomain(String domainName) {
        this.domainName = domainName;
    }

    public void addHost(Host host) {
        if (domainHosts.addHostToDomain(host)) {
            System.out.println("Host added: " + host.getHostName());
        } else {
            System.out.println("Host already exists.");
        }
    }

    public void removeHost(Host host) {
        if (domainHosts.removeHostFromDomain(host)) {
            System.out.println("Host removed: " + host.getHostName());
        } else {
            System.out.println("Host not found.");
        }
    }

    public void addUser(User user) {
        if (domainUsers.addUserToDomain(user)) {
            System.out.println("User added: " + user.getUsername());
        } else {
            System.out.println("User already exists.");
        }
    }

    public void removeUser(User user) {
        if (domainUsers.removeUserFromDomain(user)) {
            System.out.println("User removed: " + user.getUsername());
        } else {
            System.out.println("User not found.");
        }
    }

    public void displayDomainName() {
        System.out.println("Domain Name: " + domainName);
    }

    public void displayHosts() {
        System.out.println("List of Hosts in Domain:");
        domainHosts.displayHosts();
    }

    public void displayUsers() {
        System.out.println("List of Users in Domain:");
        domainUsers.displayUsers();
    }

    public void displayHostInfo(Host host) {
        if (domainHosts.containsHost(host)) {
            host.displayHostInfo();
        } else {
            System.out.println("Host not found in domain.");
        }
    }

    public void displayUserInfo(User user) {
        if (domainUsers.containsUser(user)) {
            System.out.println("User Info:");
            System.out.println("Username: " + user.getUsername());
            System.out.println("Full Name: " + user.getFullName());
            System.out.println("Last Login: " + user.getLastLoginTime());
        } else {
            System.out.println("User not found in domain.");
        }
    }
}
