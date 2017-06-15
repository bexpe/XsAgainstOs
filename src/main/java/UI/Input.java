package UI;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
    private final Scanner SCANNER;
    private Message message = new Message();

    public Input(InputStream in) {
        this.SCANNER = new Scanner(in);
    }

    public String menuInput() {
        String option = SCANNER.nextLine();
        while (!Pattern.matches("[1-2]", option)) {
            message.wrongInputMessage();
            option = SCANNER.nextLine();
        }
        return option;
    }

    public String turnInput() {
        String option = SCANNER.nextLine();
        while (!Pattern.matches("([1-3])([ ][1-3])", option)) {
            message.wrongInputMessage();
            option = SCANNER.nextLine();
        }
        return option;
    }
}
