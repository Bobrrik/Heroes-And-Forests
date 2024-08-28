import java.util.Scanner;

public class Start {
//    public static void main(String[] args) throws InterruptedException { //для тестов
//
//    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("введите имя героя");
        Hero hero = new Hero(scanner.nextLine());

        System.out.println("был создан герой " + hero.getName());

        Panel();

        while (true) {
            int s = scanner.nextInt();
            if (s == 4) {//завершение
                Exit(hero);
                break;
            }
            else if (s == 1) Torg(hero); // к торговцу
            else if (s == 2) {// в лес
                Forest(hero);
                if (!hero.getLive()){
                    break;
                }
            }
            else if (s == 3) LookYourSelf(hero); //посмотреть статы
            else System.out.println("что-то ввели не так");
        }
    }

    public static void Exit(NPS hero) {
        System.out.println("Игра закончена с такими показателями");
        LookYourSelf(hero);
    }

    public static void Panel() {
        System.out.println();
        System.out.println("""
                Выберете далнейший путь.
                1. К торговцу.
                2. В тёмный леc.
                3. Посмотреть на себя
                4. Закончить.
                """);
        System.out.println();
    }

    public static void Torg(Hero hero) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вот его товары");
        Dealer.assortment();
        System.out.println("""
                 покупаешь?
                 1. Да
                 2. В следующий раз
                """);
        int s = scanner.nextInt();
        if (s == 1) {
            if (hero.getGold() >= 50) {
                hero.setGold(hero.getGold() - 50);
                System.out.println("поздравляю с покупкой");
                hero.UsePotion();
            } else System.out.println("денег не хватило :(");
        } else System.out.println("ok, идём дальше");
        Panel();
    }

    public static void Forest(NPS hero) {
        Confrontation.Fight(hero, Confrontation.RandomMob());
        if (hero.getLive()) Panel() ;
        else {
            System.out.println("Герой умер :(");
            Exit(hero);
        }
    }

    public static void LookYourSelf(NPS nps) {
        System.out.println(nps.toString());
        if (nps.getLive()) Panel();
    }
}