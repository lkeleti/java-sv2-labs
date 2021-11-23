package defaultconstructor.chess;

import java.util.Arrays;
import java.util.List;

public class ChessTournament {
    private List<Team> teams;

    public ChessTournament() {
        teams = Arrays.asList(new Team(), new Team(), new Team());
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void addPlayersToTeams(List<Player> playersRegistrated){
        int maxNumberfPlayers = Math.min(6,playersRegistrated.size());
        for (int i=0; i < maxNumberfPlayers; i++) {
            int teamNumber = i /2;
            if (i % 2 ==0) {
                teams.get(teamNumber).setPlayerOne(playersRegistrated.get(i));
            }
            else {
                teams.get(teamNumber).setPlayerTwo(playersRegistrated.get(i));
            }
        }
    }
}
