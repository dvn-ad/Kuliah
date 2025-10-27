// CommandWords.java
import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

public class CommandWords {
    private Set<String> validCommands;

    public CommandWords() {
        validCommands = new HashSet<>();
        // daftar perintah yang valid
        validCommands.add("go");
        validCommands.add("quit");
        validCommands.add("help");
        validCommands.add("look");
    }

    public boolean isCommand(String aString) {
        return validCommands.contains(aString);
    }

    public String getCommandList() {
        StringJoiner sj = new StringJoiner(" ");
        for (String s : validCommands) sj.add(s);
        return sj.toString();
    }
}
