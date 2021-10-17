package stringmethods;

import java.util.*;

public class UrlManager {
    private String protocol;
    private int port;
    private String host;
    private String path;
    private String query;
    private Dictionary<String,String> queryDict = new Hashtable<>();

    public UrlManager(String url) {
        protocol = findProtocol(url);
        port = findPort(url);
        host = findHost(url);
        path = findPath(url);
        query = findQuery(url);
        if (query != null) {
            createQueryDict(query);
        }
    }

    private void createQueryDict(String query) {
        for (String item: query.split(  "&")) {
            String[] keyValue = item.split("=");
            queryDict.put(keyValue[0],keyValue[1]);
        }
    }

    private String findQuery(String url) {
        String query = null;
        int queryStart = url.indexOf("?");
        if (queryStart != -1) {
            query = url.substring(queryStart+1,url.length());
        }
        return query;
    }

    private String findPath(String url) {
        String path = null;
        int positionOfHost = url.indexOf(host);
        int pathStart = url.indexOf("/",positionOfHost+1);
        int pathEnd = url.indexOf("?");
        pathEnd = pathEnd == -1 ? url.length() : pathEnd;
        path = url.substring(pathStart+1,pathEnd);
        return path;
    }

    private String findHost(String url) {
        int positionOfProtocol = url.indexOf("://");
        int positionOfColon = url.indexOf(":" ,positionOfProtocol+1);
        String host = null;
        if (positionOfColon == -1) {
            // It use default port
            int positionEndOfHost = url.indexOf("/", positionOfProtocol+3);
            host = url.substring(positionOfProtocol+3, positionEndOfHost);
            host = host.toLowerCase();
        }
        else {
            host = url.substring(positionOfProtocol+3, positionOfColon);
            host = host.toLowerCase();
        }
        return host;
    }

    private int findPort(String url) {
        int positionOfProtocol = url.indexOf("://");
        int positionOfColon = url.indexOf(":" ,positionOfProtocol+1);
        Integer port = null;
        if (positionOfColon == -1) {
            // It use default port
            for (DefaultPorts dP: DefaultPorts.values()) {
                if (dP.name().toLowerCase().equals(this.protocol)) {
                    port = dP.getPort();
                    break;
                }
            }
        }
        else {
            int positionOfSlash = url.indexOf("/",positionOfColon);
            port = Integer.parseInt(url.substring(positionOfColon+1,positionOfSlash));
        }
        return port;
    }

    private String findProtocol(String url) {
        return url.substring(0,url.indexOf("://")).toLowerCase();
    }

    public String getProtocol() {
        return protocol;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public boolean hasProperty(String key) {
        /* String value = queryDict.get(key);
        return value == null ? false : true;*/
        boolean result = false;
        for (String item: query.split(  "&")) {
            String[] keyValue = item.split("=");
             if (keyValue[0].equals(key)) {
                 result = true;
                 break;
             }
        }
        return result;
    }

    public String getProperty(String key) {
        /* String value = queryDict.get(key);
        return value;*/
        String result = null;
        for (String item: query.split(  "&")) {
            String[] keyValue = item.split("=");
            if (keyValue[0].equals(key)) {
                result = keyValue[1];
                break;
            }
        }
        return result;
    }

    public String[] getAllPropertyKey() {
        List<String> propertyKeys= new ArrayList<>();
        for (String item: query.split(  "&")) {
            String[] keyValue = item.split("=");
            propertyKeys.add(keyValue[0]);
        }
        String[] allPropertyKeys = new String[propertyKeys.size()];
        for (int i = 0; i < propertyKeys.size(); i++) {
            allPropertyKeys[i] = propertyKeys.get(i);
        }
        return allPropertyKeys;
    }

    public static void main(String[] args) {
        UrlManager urlManager = new UrlManager("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02");
        System.out.println("Protocol: " + urlManager.getProtocol());
        System.out.println("Port    : " + urlManager.getPort());
        System.out.println("Host    : " + urlManager.getHost());
        System.out.println("Path    : " + urlManager.getPath());
        System.out.println("Property: " + urlManager.hasProperty("format"));
        System.out.println("Property: " + urlManager.hasProperty("number"));
        System.out.println("Property: " + urlManager.getProperty("format"));
        System.out.println("Property: " + urlManager.getProperty("number"));

        System.out.println(System.lineSeparator());

        urlManager = new UrlManager("https://www.google.com/search?q=java+dictionary&oq=java+dict&aqs=chrome.0.0i512j69i57j0i512l8.3465j0j15&sourceid=chrome&ie=UTF-8");
        System.out.println("Protocol: " + urlManager.getProtocol());
        System.out.println("Port    : " + urlManager.getPort());
        System.out.println("Host    : " + urlManager.getHost());
        System.out.println("Path    : " + urlManager.getPath());
        System.out.println("Property: " + urlManager.hasProperty("format"));
        System.out.println("Property: " + urlManager.hasProperty("number"));
        System.out.println("Property: " + Arrays.toString(urlManager.getAllPropertyKey()));
        System.out.println("Property: " + urlManager.getProperty("format"));
        System.out.println("Property: " + urlManager.getProperty("q"));
        System.out.println("Property: " + urlManager.getProperty("oq"));
        System.out.println("Property: " + urlManager.getProperty("aqs"));
        System.out.println("Property: " + urlManager.getProperty("sourceid"));
        System.out.println("Property: " + urlManager.getProperty("ie"));

    }
}
