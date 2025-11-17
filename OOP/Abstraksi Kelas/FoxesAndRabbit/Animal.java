import java.util.List;

public abstract class Animal {
    private int age;
    private boolean alive;
    private Field field;
    private Location location;

    public Animal(Field field, Location location) {
        this.age = 0;
        this.alive = true;
        this.field = field;
        setLocation(location);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setDead() {
        alive = false;
        if (location != null) {
            field.clear(location);
            location = null;
        }
        field = null;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location newLocation) {
        
        if (location != null) {
            field.clear(location);
        }
        
        location = newLocation;
        if (location != null) {
            field.place(this, location);
        }
    }

    public Field getField() {
        return field;
    }

    public int getAge() {
        return age;
    }

    public void incrementAge() {
        age++;
    }

    public abstract void act(List<Animal> newAnimals);
}
