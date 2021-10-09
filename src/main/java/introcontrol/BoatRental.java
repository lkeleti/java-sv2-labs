package introcontrol;

import java.util.Scanner;

public class BoatRental {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int freeSeat = 10;

        System.out.println("Kérem írja be a csoport létszámát: ");
        int person = scanner.nextInt();

        if (person >= 5 ) {
            System.out.println("Elvitték az ötös csónakot.");
            person -= 5;
            freeSeat -=5;
        }

        if (person >= 3) {
            System.out.println("Elvitték a hármas csónakot.");
            person -= 3;
            freeSeat -=3;
        }

        if (person > 0) {
            System.out.println("Elvitték a kettes csónakot.");
            person -= 2;
            freeSeat -=2;
        }

        if (person > 0) {
            System.out.println(person + " fő maradt a parton.");
        }
        else {
            System.out.println(freeSeat +" szabad hely maradt");
        }
    }
}
