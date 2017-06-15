package UI;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
    private Scanner reader = new Scanner(System.in);
    private Message message = new Message();

    public String menuInput() {
        String option = reader.nextLine();
        while (!Pattern.matches("[1-2]", option)) {
            message.wrongInputMessage();
            option = reader.nextLine();
        }
        return option;
    }

    public String turnInput() {
        String option = reader.nextLine();
        while (!Pattern.matches("([1-3])([ ][1-3])", option)) {
            message.wrongInputMessage();
            option = reader.nextLine();
        }
        return option;
    }
}
