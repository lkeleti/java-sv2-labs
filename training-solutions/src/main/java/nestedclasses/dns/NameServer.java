package nestedclasses.dns;

import java.util.ArrayList;
import java.util.List;

public class NameServer {
    private List<DnsEntry> entries = new ArrayList<>();

    private static class DnsEntry {
        private String hostName;
        private String hostIp;

        public DnsEntry(String hostName, String hostIp) {
            this.hostName = hostName;
            this.hostIp = hostIp;
        }

        public String getHostName() {
            return hostName;
        }

        public String getHostIp() {
            return hostIp;
        }
    }

    public void addEntry(String hostName, String hostIp) {
        for (DnsEntry de : entries) {
            if (de.getHostName().equals(hostName) || de.getHostIp().equals(hostIp)) {
                throw new IllegalArgumentException("Already exists");
            }
        }
        entries.add(new DnsEntry(hostName, hostIp));
    }

    public void removeEntryByName(String hostName) {
        for (DnsEntry de : entries) {
            if (de.getHostName().equals(hostName)) {
                entries.remove(de);
                return;
            }
        }
    }

    public void removeEntryByIp(String hostIp) {
        for (DnsEntry de : entries) {
            if (de.getHostIp().equals(hostIp)) {
                entries.remove(de);
                return;
            }
        }
    }

    public String getIpByName(String hostName) {
        for (DnsEntry de : entries) {
            if (de.getHostName().equals(hostName)) {
                return de.getHostIp();
            }
        }
        throw new IllegalArgumentException("Element not found");
    }

    public String getNameByIp(String hostIp) {
        for (DnsEntry de : entries) {
            if (de.getHostIp().equals(hostIp)) {
                return de.getHostName();
            }
        }
        throw new IllegalArgumentException("Element not found");
    }
}
