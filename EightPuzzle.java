
public class EightPuzzle {

    static int[][] goal = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0}
    };
    // Calculate Manhattan Distance
    static int heuristic(int[][] a) {
        int h = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                int n = a[i][j];

                if (n != 0) {
                    int x = (n - 1) / 3;
                    int y = (n - 1) % 3;

                    h += Math.abs(i - x) + Math.abs(j - y);
                }
            }
        }
        return h;
    }
    static void print(int[][] a) {
        for (int[] row : a) {
            for (int n : row)
                System.out.print(n + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[][] a = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 5, 8}
        };

        int g = 0;

        System.out.println("Initial State:");
        print(a);

        while (heuristic(a) != 0) {

            int x = 0, y = 0;

            // Find blank space (0)
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (a[i][j] == 0) {
                        x = i;
                        y = j;
                    }

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            int bestH = Integer.MAX_VALUE;
            int bx = -1, by = -1;

            // Find the best next move
            for (int k = 0; k < 4; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {

                    a[x][y] = a[nx][ny];
                    a[nx][ny] = 0;

                    int h = heuristic(a);

                    if (g + 1 + h < bestH) {
                        bestH = g + 1 + h;
                        bx = nx;
                        by = ny;
                    }

                    // Undo move
                    a[nx][ny] = a[x][y];
                    a[x][y] = 0;
                }
            }

            if (bx == -1) {
                System.out.println("No solution found!");
                return;
            }

            // Perform best move
            a[x][y] = a[bx][by];
            a[bx][by] = 0;

            g++;

            System.out.println("Step " + g + ":");
            print(a);
        }

        System.out.println("Goal State Reached!");
    }
}
