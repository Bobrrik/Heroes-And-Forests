public class Confrontation {

    public static NPS RandomMob(){
        int random = (int) (Math.random()*10);
        if (random>4) return new Skeleton("Jon");
        else return new Goblin("Bil");
    }

    public static void Fight(NPS enemy1, NPS enemy2) {
        while (enemy1.getLive() && enemy2.getLive()) {
            enemy1.ShotSelection(enemy2);
            enemy2.ShotSelection(enemy1);
        }
    }

}
