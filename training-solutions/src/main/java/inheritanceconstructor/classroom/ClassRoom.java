package inheritanceconstructor.classroom;

public class ClassRoom extends Room {
    Facility facility;

    public ClassRoom(String location, int capacity, Facility facility) {
        super(location, capacity);
        this.facility = facility;
    }

    public Facility getFacility() {
        return facility;
    }

    public boolean isSuitable(Course course) {
        return (course.getFacilityNeeded() == facility && course.getParticipants() <= super.getCapacity());
    }
}
