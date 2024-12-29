import java.util.ArrayList;
import java.util.List;

public class OrganismFactory {
    public List<Plant> createPlants(int count) {
        List<Plant> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Plant plant = new Plant();
            list.add(plant);
        }
        return list;
    }

    public List<Wolf> createWolfs(int count) {
        List<Wolf> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Wolf wolf = new Wolf();
            list.add(wolf);
        }
        return list;
    }
}
