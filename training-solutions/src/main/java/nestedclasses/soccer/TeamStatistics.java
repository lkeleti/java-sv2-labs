package nestedclasses.soccer;

import java.util.ArrayList;
import java.util.Objects;

public class TeamStatistics {
    private String teamName;
    private GameData gameData;

    public TeamStatistics(String teamName) {
        this.teamName = teamName;
        gameData = new GameData();
    }

    private class GameData {
        private int played;
        private int won;
        private int tied;
        private int lost;
        private int goalsfor;
        private int goalsAgainst;
        private int points;
    }

    public String getTeamName() {
        return teamName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamStatistics that = (TeamStatistics) o;
        return teamName.equals(that.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName);
    }

    public void played(int plusGoalsFor, int plusGoalsAgainst) {
        gameData.played += 1;
        gameData.goalsAgainst += plusGoalsAgainst;
        gameData.goalsfor += plusGoalsFor;
        if (plusGoalsFor > plusGoalsAgainst) {
            gameData.won += 1;
            gameData.points += 3;
        }
        else if (plusGoalsFor == plusGoalsAgainst) {
            gameData.tied += 1;
            gameData.points += 1;
        }
        else {
            gameData.lost += 1;
        }
    }

    public int getPlayed() {
        return gameData.played;
    }

    public int getWon() {
        return gameData.won;
    }

    public int getTied() {
        return gameData.tied;
    }

    public int getLost() {
        return gameData.lost;
    }

    public int getGoalsfor() {
        return gameData.goalsfor;
    }

    public int getGoalsAgainst() {
        return gameData.goalsAgainst;
    }

    public int getPoints() {
        return gameData.points;
    }
}
