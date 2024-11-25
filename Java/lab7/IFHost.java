public interface IFHost {
    void setHostName(String name);

    void setHostAddressIPv4(String address);

    void displayHostInfo();

    String getHostName();

    String getHostAddressIPv4();
}
