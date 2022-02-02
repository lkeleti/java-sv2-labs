package harmadik_reszvizsga_potvizsga.contentsite;

public class User {
    private String userName;
    private int password;
    private boolean premiumMember;
    private boolean logIn;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = (userName + password).hashCode();
    }

    public String getUserName() {
        return userName;
    }

    public int getPassword() {
        return password;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public boolean isLogIn() {
        return logIn;
    }

    public void setLogIn(boolean logIn) {
        this.logIn = logIn;
    }

    public void upgradeForPremium() {
        premiumMember = true;
    }
}
