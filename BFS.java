
import java.util.*;

public class BFS {

    static int[][] grid = {
        {0, 0, 0, 1},
        {1, 0, 0, 1},
        {0, 0, 0, 0},
        {1, 1, 0, 0}
    };

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void solve() {

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];

        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {

            int[] p = q.poll();
            int x = p[0];
            int y = p[1];

            System.out.println("Robot at: " + x + ", " + y);

            // Check goal
            if (x == 3 && y == 3) {
                System.out.println("Goal Reached!");
                return;
            }

            // Explore four directions
            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < 4 &&
                    ny >= 0 && ny < 4 &&
                    grid[nx][ny] == 0 &&
                    !visited[nx][ny]) {

                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        System.out.println("Goal not reachable!");
    }

    public static void main(String[] args) {

        System.out.println("Robot Path Planning using BFS");

        solve();
    }
}
