package defaultconstructor.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChessTournamentTest {
    ChessTournament chessTournament;
    Player p1;
    Player p2;
    Player p3;
    Player p4;
    Player p5;
    Player p6;
    Player p7;

    @BeforeEach
    void init() {
   chessTournament = new ChessTournament();
        p1 = new Player();
        p1.setName("John Doe");
        p2 = new Player();
        p2.setName("Jane Doe");
        p3 = new Player();
        p3.setName("Jack Doe");
        p4 = new Player();
        p4.setName("John Black");
        p5 = new Player();
        p5.setName("Jane Black");
        p6 = new Player();
        p6.setName("Jack Black");
        p7 = new Player();
        p7.setName("Not in List");
    }

    @Test
    void addPlayersToTeamsThree() {
        List<Player> players = new ArrayList<>(Arrays.asList(p1, p2, p3));
        chessTournament.addPlayersToTeams(players);
        assertEquals("John Doe", chessTournament.getTeams().get(0).getPlayerOne().getName());
        assertEquals("Jane Doe", chessTournament.getTeams().get(0).getPlayerTwo().getName());
        assertEquals("Jack Doe", chessTournament.getTeams().get(1).getPlayerOne().getName());

    }

    @Test
    void addPlayersToTeamsSix() {
        List<Player> players = new ArrayList<>(Arrays.asList(p1, p2, p3,p4,p5,p6));
        chessTournament.addPlayersToTeams(players);
        assertEquals("John Doe", chessTournament.getTeams().get(0).getPlayerOne().getName());
        assertEquals("Jane Doe", chessTournament.getTeams().get(0).getPlayerTwo().getName());
        assertEquals("Jack Doe", chessTournament.getTeams().get(1).getPlayerOne().getName());
        assertEquals("John Black", chessTournament.getTeams().get(1).getPlayerTwo().getName());
        assertEquals("Jane Black", chessTournament.getTeams().get(2).getPlayerOne().getName());
        assertEquals("Jack Black", chessTournament.getTeams().get(2).getPlayerTwo().getName());
    }

    @Test
    void addPlayersToTeamsSeven() {
        List<Player> players = new ArrayList<>(Arrays.asList(p1, p2, p3,p4,p5,p6,p7));
        chessTournament.addPlayersToTeams(players);
        assertEquals("John Doe", chessTournament.getTeams().get(0).getPlayerOne().getName());
        assertEquals("Jane Doe", chessTournament.getTeams().get(0).getPlayerTwo().getName());
        assertEquals("Jack Doe", chessTournament.getTeams().get(1).getPlayerOne().getName());
        assertEquals("John Black", chessTournament.getTeams().get(1).getPlayerTwo().getName());
        assertEquals("Jane Black", chessTournament.getTeams().get(2).getPlayerOne().getName());
        assertEquals("Jack Black", chessTournament.getTeams().get(2).getPlayerTwo().getName());
        assertEquals(3, chessTournament.getTeams().size());
    }
}