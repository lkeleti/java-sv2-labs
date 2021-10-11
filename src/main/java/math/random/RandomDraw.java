package math.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDraw {
    public static void main(String[] args) {
        List<String> players = new ArrayList<>();
        players.add("Daniel Craig");
        players.add("Jean-Paul Belmondo");
        players.add("Bruce Willis");
        players.add("Gerard Butler");
        players.add("Jason Statham");
        players.add("Sylvester Stallone");
        players.add("Kevin Costner");
        players.add("Bud Spencer");
        players.add("Adam Sandler");
        players.add("Tom Hanks");

        Random random = new Random();
        int firstWinner = random.nextInt(0,5);
        int secondWinner = random.nextInt(5,10);

        System.out.println("A két nyertes: " + players.get(firstWinner) + " és " +
                players.get(secondWinner));


    }

}
