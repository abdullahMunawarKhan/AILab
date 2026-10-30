
import java.util.Scanner;

public class Chatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Chatbot: Hello! How can I help you?");
        System.out.println("Type 'bye' to exit.");

        while (true) {

            System.out.print("You: ");
            String input = sc.nextLine().toLowerCase();

            if (input.contains("hello") || input.contains("hi")) {
                System.out.println("Bot: Hello! Nice to meet you.");
            }
            else if (input.contains("name")) {
                System.out.println("Bot: My name is Chatbot.");
            }
            else if (input.contains("how are you")) {
                System.out.println("Bot: I am fine. How are you?");
            }
            else if (input.contains("help")) {
                System.out.println("Bot: Sure! How can I help you?");
            }
            else if (input.contains("bye")) {
                System.out.println("Bot: Goodbye! Have a nice day.");
                break;
            }
            else {
                System.out.println("Bot: Sorry, I don't understand.");
            }
        }

        sc.close();
    }
}
