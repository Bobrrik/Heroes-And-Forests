public abstract class NPS {

    private int HP, Strong, Agility, Gold, EXPERIENCE;
    private int Rebirth = 0;
    private String Name;
    private boolean live = true;
    private int MaxHP;

    public NPS(String name) {
        this.Name = name;

    }

    public void Attack(NPS enemy) {
        if (live==false) {
            System.out.println("Ты мёртв!");
            return;
        }

        if (enemy.HP <= 0) {
            System.out.println(this.Name + " Попытался ударить погибшего " + enemy.Name);
            return;
        }

        int StrongAttack = this.Strong;
        int luck = (int) (Math.random() * 10);
        luck += this.Agility > enemy.Agility ? 1 : -1;

        if (luck > 7) {
            StrongAttack *= 2;
            System.out.println(this.Name + " Совершил критический удар в размере " + StrongAttack * 2 + " По " + enemy.Name);
        } else if (luck < 2) {
            StrongAttack = 0;
            System.out.println(this.Name + " Не попал по " + enemy.Name);
        } else {
            System.out.println(this.Name + " Совершил удар в размере " + StrongAttack + " По " + enemy.Name);
        }

        enemy.HP -= StrongAttack;

        if (enemy.HP <= 0) {
            this.Gold += enemy.Gold;
//            System.out.println(this.Gold);
//            System.out.println(this.EXPERIENCE);
            System.out.println(this.Name + " Погубил " + enemy.Name + " И получил Золото:" + enemy.Gold + " И Опыт:10");
            enemy.Gold = 0;
            enemy.Die();
            LevelPlus();
        }
    }

    public void ShotSelection(NPS enemy) {
    }

    public void Die() {   // механика возраждения
        if (Rebirth == 0) live = false;
        else {
            Rebirth--;
            System.out.println(this.Name + " Востал!");
            this.HP = getMaxHP();
        }
    }

    public void LevelPlus() {
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getStrong() {
        return Strong;
    }

    public void setStrong(int strong) {
        Strong = strong;
    }

    public int getAgility() {
        return Agility;
    }

    public void setAgility(int agility) {
        Agility = agility;
    }

    public int getGold() {
        return Gold;
    }

    public void setGold(int gold) {
        Gold = gold;
    }

    public int getEXPERIENCE() {
        return EXPERIENCE;
    }

    public void setEXPERIENCE(int EXPERIENCE) {
        this.EXPERIENCE = EXPERIENCE;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getRebirth() {
        return Rebirth;
    }

    public void setRebirth(int rebirth) {
        Rebirth = rebirth;
    }

    public boolean getLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public int getMaxHP() {
        return MaxHP;
    }

    public void setMaxHP(int maxHP) {
        MaxHP = maxHP;
    }

    @Override
    public String toString() {
        return "NPS{" +
                "HP=" + HP +
                ", Strong=" + Strong +
                ", Agility=" + Agility +
                ", Gold=" + Gold +
                ", EXPERIENCE=" + EXPERIENCE +
                ", Rebirth=" + Rebirth +
                ", Name='" + Name + '\'' +
                ", live=" + live +
                ", MaxHP=" + MaxHP +
                '}';
    }
}
