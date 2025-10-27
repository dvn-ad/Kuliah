// Room.java
import java.util.Map;
import java.util.HashMap;

public class Room {
    private String description;
    private Map<String, Room> exits; // "north", "east", etc.

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getShortDescription() {
        return description;
    }

    public String getLongDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("You are ").append(description).append(".\n");
        sb.append(getExitString());
        return sb.toString();
    }

    private String getExitString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Exits:");
        for (String dir : exits.keySet()) {
            sb.append(" ").append(dir);
        }
        return sb.toString();
    }
}
