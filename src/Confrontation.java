import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Confrontation {

    public static NPS RandomMob() {
        int random = (int) (Math.random() * 10);
        if (random > 4) return new Skeleton(RandomName());
        else return new Goblin(RandomName());
    }

    public static void Fight(NPS enemy1, NPS enemy2) {
        while (enemy1.getLive() && enemy2.getLive()) {
            if (enemy1.getLive()) enemy1.ShotSelection(enemy2);
            if (enemy2.getLive()) enemy2.ShotSelection(enemy1);
        }
    }

    public static String RandomName() {
        Random random = new Random();
        List<String> list = new ArrayList<>();

        list.add("Jon");
        list.add("Bil");
        list.add("Jana");
        list.add("Jesika");
        list.add("Aleks");
        list.add("Bob");
        list.add("Steisy");
        list.add("Mariarty");

        return list.get(random.nextInt(list.size()));
    }
}
