public class Hero extends NPS {

    //  int Potion = 0;

    public Hero(String name) {
        super(name);
        setHP(100);
        setGold(50);
        setAgility(10);
        setStrong(10);
        setEXPERIENCE(0);
        setMaxHP(getHP());
    }

    public void ShotSelection(NPS enemy) {
        Attack(enemy);
    }

    public void UsePotion() {
//        if (Potion==0) {                          Задумка инвенторя
//            System.out.println("зелий нет");
//            return;
//        }
//
//        Potion -= 1;
        if ((getHP() + 50) > getMaxHP()) {
            setHP(getHP() + (getMaxHP() - getHP()));
            System.out.printf("герой вылечил себя теперь его здоровье равно %d \n", this.getHP());
        } else {
            setHP(getHP() + 50);
            System.out.printf("герой вылечил себя на хп %d теперь его здоровье равно %d \n", 50, this.getHP());
        }
    }

    public void LevelPlus() {
        setEXPERIENCE(getEXPERIENCE() + 20);
        if (getEXPERIENCE() >= 100) {
            LevelUp();
            setEXPERIENCE(0);
        } else System.out.println("До следующего уровня " + (100 - getEXPERIENCE()));
    }

    public void LevelUp() {
        System.out.println("LevelUp");
        System.out.println("Ваши статы возросли!");

        System.out.println(getName());
        System.out.println("Текущее здоровье:" + getHP() + " -> " + (getHP() + 30));
        System.out.println("Максимальное здоровье:" + getMaxHP() + " -> " + (getMaxHP() + 30));
        System.out.println("Сила:" + getStrong() + " -> " + (getStrong() + 4));
        System.out.println("Ловкость:" + getAgility() + " -> " + (getAgility() + 3));

        setHP(getHP() + 30);
        setStrong(getStrong() + 4);
        setAgility(getAgility() + 3);
        setMaxHP(getMaxHP() + 30);
    }

}
