public class TestDomain {
    public static void main(String[] args) {
        ServerDomain serverDomain = new ServerDomain("MyDomain");

        Host host1 = new Host();
        host1.setHostName("Host1");
        host1.setHostAddressIPv4("192.168.1.1");

        Host host2 = new Host();
        host2.setHostName("Host2");
        host2.setHostAddressIPv4("192.168.1.2");

        serverDomain.addHost(host1);
        serverDomain.addHost(host2);
        serverDomain.displayHosts();

        serverDomain.removeHost(host1);
        serverDomain.displayHosts();

        User user1 = new User();
        user1.setUsername("admin");
        user1.setFullName("Admin User");

        serverDomain.addUser(user1);
        serverDomain.displayUsers();

        serverDomain.displayDomainName();
    }
}
