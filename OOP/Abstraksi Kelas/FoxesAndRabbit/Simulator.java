import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulator {
    private Field field;
    private List<Animal> animals;
    private Random rand = new Random();

    public Simulator(int depth, int width) {
        field = new Field(depth, width);
        animals = new ArrayList<>();
        populate();
    }

    public void simulate(int steps) {
        for (int step = 0; step < steps; step++) {
            List<Animal> newAnimals = new ArrayList<>();
            List<Animal> current = new ArrayList<>(animals);
            for (Animal animal : current) {
                animal.act(newAnimals);
            }
            animals.addAll(newAnimals);

            
            animals.removeIf(a -> !a.isAlive());

            
            System.out.println("Step " + step + " - animals: " + animals.size());
        }
    }

    private void populate() {
        int depth = field.getDepth();
        int width = field.getWidth();

        
        
        for (int r = 0; r < depth; r++) {
            for (int c = 0; c < width; c++) {
                double p = rand.nextDouble();
                Location loc = new Location(r, c);
                if (p < 0.10) { 
                    Fox fox = new Fox(field, loc);
                    animals.add(fox);
                } else if (p < 0.35) { 
                    Rabbit rabbit = new Rabbit(field, loc);
                    animals.add(rabbit);
                } 
            }
        }
    }

    public static void main(String[] args) {
        Simulator sim = new Simulator(20, 20);
        sim.simulate(50);
    }
}
