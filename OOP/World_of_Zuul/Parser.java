// Parser.java
import java.util.Scanner;

public class Parser {
    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        System.out.print("> ");               // prompt
        String inputLine = reader.nextLine();
        String word1 = null;
        String word2 = null;

        String[] words = inputLine.trim().split("\\s+", 2);
        if (words.length >= 1 && !words[0].isEmpty()) {
            word1 = words[0];
            if (words.length == 2) {
                word2 = words[1];
            }
        }

        if (word1 != null && commands.isCommand(word1)) {
            return new Command(word1, word2);
        } else {
            return new Command(null, word2); // unknown command
        }
    }

    public String getCommandsList() {
        return commands.getCommandList();
    }
}
