package introconstructors;

public class TaskMain {
    public static void main(String[] args) {
        Task task = new Task("Bevásárlás", "Az alábbi lista alapján be kell vásárolni: Tej, kennyér, stb.");

        task.setDuration(90);
        System.out.println("A feladat: " + task.getTitle());
        System.out.println("A feladat leírása: " + task.getDescription());
        System.out.println("A feladat kezdése (még nem kezdődhetett el): " + task.getStartDateTime());
        System.out.println("A feladat hossza: " + task.getDuration());

        task.start();

        System.out.println("A feladat: " + task.getTitle());
        System.out.println("A feladat leírása: " + task.getDescription());
        System.out.println("A feladat kezdése (elkezdődött): " + task.getStartDateTime());
        System.out.println("A feladat hossza: " + task.getDuration());

    }
}
