package introexceptioncheckedtrace;

public class Person {
    private String name;
    private String neptunCode;

    public Person(String name, String neptunCode) {
        this.name = name;
        this.neptunCode = neptunCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeptunCode() {
        return neptunCode;
    }

    public void setNeptunCode(String neptunCode) {
        this.neptunCode = neptunCode;
    }
}
