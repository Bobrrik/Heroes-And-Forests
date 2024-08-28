public class Skeleton extends Monster {

    public Skeleton(String name) {
        super(name);
        setHP(50);
        setGold(20);
        setAgility(10);
        setStrong(10);
        setEXPERIENCE(0);
        setRebirth(1); //умеет перерождаться после смерти
        setMaxHP(getHP());

        System.out.println("появился "+this.getClass()+" по имени "+ this.getName());
    }

    public void ShotSelection(NPS enemy) {
        int random = (int) (Math.random() * 10);
        if (random > 6) HilHit(enemy);
        else Hit(enemy);
    }

    public void HilHit(NPS enemy) {
        System.out.println("Скелет излечил себя");
        this.setHP(getHP()+10);
        Attack(enemy);
    }

    public void Hit(NPS enemy) {
        Attack(enemy);
    }

}
