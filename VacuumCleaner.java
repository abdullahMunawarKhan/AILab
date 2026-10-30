
public class VacuumCleaner {
    public static void main(String[] args) {

        String A = "Dirty";
        String B = "Dirty";
        char location = 'A';

        while (A.equals("Dirty") || B.equals("Dirty")) {

            if (location == 'A') {

                if (A.equals("Dirty")) {
                    System.out.println("Room A is Dirty - Suck");
                    A = "Clean";
                } else {
                    System.out.println("Room A is Clean - Move Right");
                    location = 'B';
                }

            } else {

                if (B.equals("Dirty")) {
                    System.out.println("Room B is Dirty - Suck");
                    B = "Clean";
                } else {
                    System.out.println("Room B is Clean - Move Left");
                    location = 'A';
                }
            }
        }

        System.out.println("\nBoth rooms are Clean!");
    }
}
