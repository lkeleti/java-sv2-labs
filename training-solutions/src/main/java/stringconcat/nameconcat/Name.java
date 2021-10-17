package stringconcat.nameconcat;

public class Name {
    private String familyName;
    private String middleName;
    private String givenName;
    private Title title;

    public Name(String familyName, String middleName, String givenName, Title title) {
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
        this.title = title;
    }

    public Name(String familyName, String middleName, String givenName) {
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public String concatNameWesternStyle() {
        String fullName;
        fullName = title != null ? title.name() + ". " : "";
        fullName += givenName;
        fullName += !middleName.equals("") ? " " + middleName : "";
        fullName += " " + familyName;
        return  fullName;
    }
    public String concatNameHungarianStyle() {
        String fullName;
        fullName = title != null ? title.name() + ". " : "";
        fullName = fullName.concat(familyName);
        fullName = fullName.concat(!middleName.equals("") ? " " + middleName : "");
        fullName = fullName.concat(" " + givenName);
        return fullName;
    }
}
