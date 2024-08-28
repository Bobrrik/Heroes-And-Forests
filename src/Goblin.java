public class Goblin extends Monster {
    public Goblin(String name) {
        super(name);
        setHP(30);
        setGold(20);
        setAgility(20);
        setStrong(5);
        setEXPERIENCE(0);

        System.out.println("появился "+this.getClass()+" по имени "+ this.getName());
    }

    public void ShotSelection(NPS enemy){
        int random = (int) (Math.random()*10);
        if (random>7) DablHit(enemy);
        else if (random>4) theftHit(enemy);
        else Hit(enemy);
    }

    public void DablHit(NPS enemy) {
        System.out.println(this.getName() + " совершает двойную атаку");
        Attack(enemy);
        Attack(enemy);
    }

    public void Hit(NPS enemy) {
        Attack(enemy);
    }

    public void theftHit(NPS enemy) {
        System.out.println(this.getName() + " совершает атаку с кражей и крадёт " + this.getStrong() * 3 + "монет");
        Attack(enemy);
        enemy.setGold(getGold() - this.getStrong() * 3);
    }
}
