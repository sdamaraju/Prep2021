package InterviewQuestions;

public class SprintMaxVisitedProblem {
    public static void main(String[] args) {
        int n = 5;
        int sprints[] = new int[]{2,4,1,3};
        System.out.println(getMostVisited(sprints, n));
    }

    private static int getMostVisited(int[] sprints, int n) {
        int max = -1;
        int min = n + 1;
        for (int i = 0; i < sprints.length; i++) {
            if (sprints[i] > max) max = sprints[i];
            if (sprints[i] < min) min = sprints[i];
        }
        int temp[] = new int[max - min + 1];
        int src = 0;
        int dest = 0;
        for (int i = 0; i < sprints.length - 1; i++) {
            src = sprints[i];
            dest = sprints[i + 1];
            if (src < dest) {
                for (int j = src; j <= dest; j++) {
                    temp[j-min] = temp[j-min] + 1;
                }
            } else if (src > dest) {
                for (int j = src; j >= dest; j--) {
                    temp[j-min] = temp[j-min] + 1;
                }
            }
        }

        int mostVisited = 0;
        for(int i=0;i<temp.length;i++){
            if(temp[i] > temp[mostVisited]) mostVisited = i ;
        }
        return mostVisited + min;
    }
}
