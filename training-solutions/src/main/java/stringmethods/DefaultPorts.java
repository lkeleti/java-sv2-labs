package stringmethods;

public enum DefaultPorts {
    HTTP(80) , HTTPS(443), FTP(21), FTPS(990), SFTP(22);

    private final int port;

    DefaultPorts(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }
}
