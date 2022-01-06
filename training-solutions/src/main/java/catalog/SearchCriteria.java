package catalog;

public class SearchCriteria {
    private final String title;
    private final String contributor;

    public SearchCriteria(String title, String contributor) {
        this.title = title;
        this.contributor = contributor;
    }

    public String getTitle() {
        return title;
    }

    public String getContributor() {
        return contributor;
    }

    public static SearchCriteria createByBoth (String title, String contributor){
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Title must be not empty!");
        }
        return new SearchCriteria(title,contributor);
    }

    public static SearchCriteria createByContributor(String contributor) {
        if (Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("Contributor must be not empty!");
        }
        return new SearchCriteria("",contributor);
    }

    public static SearchCriteria createByTitle(String title){
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Title must be not empty!");
        }
        return new SearchCriteria(title, "");
    }

    public boolean hasContributor() {
        return !contributor.isEmpty();
    }

    public boolean hasTitle() {
        return !title.isEmpty();
    }
}
