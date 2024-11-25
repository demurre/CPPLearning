public class Host implements IFHost {
    private String hostName;
    private String hostAddressIPv4;

    public void setHostName(String name) {
        this.hostName = name;
    }

    public void setHostAddressIPv4(String address) {
        this.hostAddressIPv4 = address;
    }

    public void displayHostInfo() {
        System.out.println("Host Name: " + hostName + ", IP Address: " + hostAddressIPv4);
    }

    public String getHostName() {
        return hostName;
    }

    public String getHostAddressIPv4() {
        return hostAddressIPv4;
    }
}
