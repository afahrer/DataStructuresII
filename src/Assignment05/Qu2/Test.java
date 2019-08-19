package Assignment05.Qu2;

public class Test {
    private static int[][] matrix = {
            {0, 2145, 3520, 1540, 2475, 2420, 3355, 2585},
            {2145, 0, 1980, 3795, 1815, 2585, 1375, 2530},
            {3520, 1980, 0, 2475, 3795, 3960, 3410, 2255},
            {1540, 3795, 2475, 0, 3575, 2695, 2475, 2035},
            {2475, 1815, 3795, 3575, 0, 3025, 2035, 1210},
            {2420, 2585, 3960, 2695, 3025, 0, 3685, 2585},
            {3355, 1375, 3410, 2475, 2035, 3685, 0, 3080},
            {2585, 2530, 2255, 2035, 1210, 2585, 3080, 0}
    };

    public static void main(String[] args) {

    }

    public static int cost() {
        int cost = 0;
        int start = 0;
        boolean[] visited = new boolean[matrix.length];
        while(!allVisited(visited)) {
            int tempStart;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                if(min > matrix[start][i]) {

                }
            }
        }
        return cost;
    }

    private static boolean allVisited(boolean[] visited) {
        for (boolean wasVisited : visited) {
            if(!wasVisited) return false;
        }
        return true;
    }
}
