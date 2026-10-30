import java.util.*;

public class DFS {

    static Set<String> visited = new HashSet<>();

    static boolean solve(int a, int b) {

        String state = a + "," + b;

        if (visited.contains(state))
            return false;

        visited.add(state);
        System.out.println("(" + a + ", " + b + ")");

        if (a == 2)
            return true;

        // Fill Jug A
        if (solve(4, b)) return true;

        // Fill Jug B
        if (solve(a, 3)) return true;

        // Empty Jug A
        if (solve(0, b)) return true;

        // Empty Jug B
        if (solve(a, 0)) return true;

        // Pour A into B
        int pour = Math.min(a, 3 - b);
        if (solve(a - pour, b + pour)) return true;

        // Pour B into A
        pour = Math.min(b, 4 - a);
        if (solve(a + pour, b - pour)) return true;

        return false;
    }

    public static void main(String[] args) {

        System.out.println("Water Jug Problem using DFS");

        if (solve(0, 0))
            System.out.println("Goal Reached!");
        else
            System.out.println("Solution Not Found!");
    }
}