
public class TowerOfHanoi {

    static void solve(int n, char source, char auxiliary, char destination) {

        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Move n-1 disks to auxiliary rod
        solve(n - 1, source, destination, auxiliary);

        // Move largest disk to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Move n-1 disks to destination rod
        solve(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {

        int n = 3;

        System.out.println("Tower of Hanoi Solution:");

        solve(n, 'A', 'B', 'C');

    }
}
