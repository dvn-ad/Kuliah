 
import java.util.ArrayList;
import java.util.List;

public class Field {
    private Object[][] field;

    public Field(int depth, int width) {
        field = new Object[depth][width];
    }

    public void clear(Location location) {
        if (location != null && inBounds(location)) {
            field[location.getRow()][location.getCol()] = null;
        }
    }

    public void place(Object object, Location location) {
        if (location != null && inBounds(location)) {
            field[location.getRow()][location.getCol()] = object;
        }
    }

    public Object getObjectAt(Location location) {
        if (location == null || !inBounds(location)) return null;
        return field[location.getRow()][location.getCol()];
    }

    public Location freeAdjacentLocation(Location location) {
        List<Location> free = new ArrayList<>();
        List<Location> adjacent = adjacentLocations(location);
        for (Location loc : adjacent) {
            if (getObjectAt(loc) == null) {
                free.add(loc);
            }
        }
        return free.isEmpty() ? null : free.get(0);
    }

    public List<Location> adjacentLocations(Location location) {
        List<Location> locations = new ArrayList<>();
        if (location == null) return locations;

        int row = location.getRow();
        int col = location.getCol();

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                
                if (dr == 0 && dc == 0) continue;
                int newRow = row + dr;
                int newCol = col + dc;
                Location loc = new Location(newRow, newCol);
                if (inBounds(loc)) {
                    locations.add(loc);
                }
            }
        }
        return locations;
    }

    public int getDepth() {
        return field.length;
    }

    public int getWidth() {
        return field[0].length;
    }

    private boolean inBounds(Location location) {
        if (location == null) return false;
        int r = location.getRow();
        int c = location.getCol();
        return r >= 0 && r < getDepth() && c >= 0 && c < getWidth();
    }
}
