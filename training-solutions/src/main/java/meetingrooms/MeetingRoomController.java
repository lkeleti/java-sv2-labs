package meetingrooms;

import java.util.Scanner;

public class MeetingRoomController {

    private final Office office = new Office();

    private void printMenu() {
        System.out.println("1. Tárgyaló rögzítése");
        System.out.println("2. Tárgyalók sorrendben");
        System.out.println("3. Tárgyalók visszafele sorrendben");
        System.out.println("4. Minden második tárgyaló");
        System.out.println("5. Területek");
        System.out.println("6. Keresés pontos név alapján");
        System.out.println("7. Keresés névtöredék alapján");
        System.out.println("8. Keresés terület alapján");
        System.out.println("9. Kilépés");
    }

    private MeetingRoom readOffice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Új tárgyaló rögzítése.");
        System.out.print("Kérem a tárgyaló nevét: ");
        String name = scanner.nextLine();
        System.out.print("Kérem a tárgyaló hosszúságát: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Kérem a tárgyaló szélességét: ");
        int width = scanner.nextInt();
        scanner.nextLine();
        return new MeetingRoom(name,length,width);
    }

    private int readMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem válasszon a fenti menüből: ");
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    private String readMeeteingRoomName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem a keresett tárgyaló nevét: ");
        return scanner.nextLine();
    }

    private String readMeeteingRoomPart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem a keresett tárgyaló nevében szereplő töredéket: ");
        return scanner.nextLine();
    }

    private int readMeeteingRoomArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem adja meg a minimum területet: ");
        return scanner.nextInt();
    }

    public void runMenu() {
        int menu = 0;
        while (menu != 9) {
            printMenu();
            menu = readMenu();
            switch(menu) {
                case 1:
                    office.addMeetingRoom(readOffice());
                    break;
                case 2:
                    office.printNames();
                    break;
                case 3:
                    office.printNamesReverse();
                    break;
                case 4:
                    office.printEvenNames();
                    break;
                case 5:
                    office.printArea();
                    break;
                case 6:
                    office.printMeetingRoomsWithName(readMeeteingRoomName());
                    break;
                case 7:
                    office.printMeetingRoomsContains(readMeeteingRoomPart());
                    break;
                case 8:
                    office.printAreasLargerThan(readMeeteingRoomArea());
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        MeetingRoomController meetingRoomController = new MeetingRoomController();
        meetingRoomController.runMenu();
    }
}
