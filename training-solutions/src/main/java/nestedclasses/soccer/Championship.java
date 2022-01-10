package nestedclasses.soccer;

import java.util.ArrayList;
import java.util.List;

public class Championship {
    private List<TeamStatistics> leagueTable = new ArrayList<>();

    public List<TeamStatistics> getLeagueTable() {
        return leagueTable;
    }

    public void addGame(GameResult result) {
        boolean isHomeExist = false;
        boolean isGuestExist = false;
        for (TeamStatistics teamStatistics : leagueTable) {
            if (result.teamHome.equals(teamStatistics.getTeamName())) {
                teamStatistics.played(result.goalHome, result.goalGuest);
                isHomeExist = true;
            }
            if (result.teamGuest.equals(teamStatistics.getTeamName())) {
                teamStatistics.played(result.goalGuest, result.goalHome);
                isGuestExist = true;
            }
        }
        if (!isHomeExist) {
            TeamStatistics teamStatistics = new TeamStatistics(result.teamHome);
            teamStatistics.played(result.goalHome, result.goalGuest);
            leagueTable.add(teamStatistics);
        }
        if (!isGuestExist) {
            TeamStatistics teamStatistics = new TeamStatistics(result.teamGuest);
            teamStatistics.played(result.goalGuest, result.goalHome);
            leagueTable.add(teamStatistics);
        }
    }

    public static class GameResult {
        private String teamHome;
        private String teamGuest;
        private int goalHome;
        private int goalGuest;

        public GameResult(String teamHome, String teamGuest, int goalHome, int goalGuest) {
            this.teamHome = teamHome;
            this.teamGuest = teamGuest;
            this.goalHome = goalHome;
            this.goalGuest = goalGuest;
        }
    }
}
