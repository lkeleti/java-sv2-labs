package meetingrooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        if (meetingRoom != null) {
            meetingRooms.add(meetingRoom);
        }
    }

    public void printNames() {
        for (MeetingRoom meetingRoom: meetingRooms) {
            System.out.println(meetingRoom.getName());
        }
    }

    public void printNamesReverse() {
        for (int i = meetingRooms.size()-1; i >= 0; i--){
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEvenNames() {
        for (int i = 0; i < meetingRooms.size(); i += 2) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printArea() {
        for (MeetingRoom meetingRoom: meetingRooms){
            System.out.println(meetingRoom);
        }
    }

    public void printMeetingRoomsWithName(String name) {
        for (MeetingRoom meetingRoom: meetingRooms) {
            if (meetingRoom.getName().equals(name)) {
                System.out.println(meetingRoom);
            }
        }
    }

    public void printMeetingRoomsContains(String part) {
        for (MeetingRoom meetingRoom: meetingRooms) {
            if (meetingRoom.getName().toUpperCase(Locale.ROOT).contains(part.toUpperCase(Locale.ROOT))) {
                System.out.println(meetingRoom);
            }
        }
    }

    public void printAreasLargerThan(int area) {
        for (MeetingRoom meetingRoom: meetingRooms) {
            if (meetingRoom.getArea() > area) {
                System.out.println(meetingRoom);
            }
        }
    }
}

