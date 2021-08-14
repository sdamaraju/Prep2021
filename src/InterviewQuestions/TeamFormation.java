package InterviewQuestions;

import java.util.ArrayList;

public class TeamFormation {
    public static void main(String[] args) {
        System.out.println(getNumberOfPossibleTeams(new int[]{4, 8, 5, 6}, 1, 5, 7));
    }

    private static int getNumberOfPossibleTeams(int[] playerLevels, int minPlayers, int minLevel, int maxLevel) {
        ArrayList<Integer> eligiblePlayers = new ArrayList();
        for (int i = 0; i < playerLevels.length; i++) {
            if (playerLevels[i] >= minLevel && playerLevels[i] <= maxLevel) eligiblePlayers.add(playerLevels[i]);
        }
        int numberOfTeams = 0;
        for (int i = minPlayers; i <= playerLevels.length; i++) {
            if (i > eligiblePlayers.size()) return numberOfTeams;
            numberOfTeams = numberOfTeams + ncr(eligiblePlayers.size(), i);
        }
        return numberOfTeams;
    }

    private static int ncr(int n, int r) {
        int answer = 1;
        for (int i = n; i > (n - r); i--) {
            answer = answer * i;
        }
        for (int i = r; i > 0; i--) {
            answer = answer / i;
        }
        return answer;
    }

}
