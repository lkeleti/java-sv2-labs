package collectionscomp;

public class Student {
    private String name;
    private int heights;

    public Student(String name, int heights) {
        this.name = name;
        this.heights = heights;
    }

    public String getName() {
        return name;
    }

    public int getHeights() {
        return heights;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", heights=" + heights +
                '}';
    }
}
