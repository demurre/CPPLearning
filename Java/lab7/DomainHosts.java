import java.util.ArrayList;

public class DomainHosts {
    private ArrayList<Host> hosts = new ArrayList<>();

    public boolean containsHost(Host newHost) {
        for (Host host : hosts) {
            if (host.getHostName().equalsIgnoreCase(newHost.getHostName()) ||
                    host.getHostAddressIPv4().equalsIgnoreCase(newHost.getHostAddressIPv4())) {
                return true;
            }
        }
        return false;
    }

    public boolean addHostToDomain(Host newHost) {
        if (!containsHost(newHost)) {
            hosts.add(newHost);
            return true;
        }
        return false;
    }

    public boolean removeHostFromDomain(Host host) {
        return hosts.remove(host);
    }

    public void displayHosts() {
        if (hosts.isEmpty()) {
            System.out.println("No hosts in domain.");
        } else {
            for (Host host : hosts) {
                host.displayHostInfo();
            }
        }
    }
}
