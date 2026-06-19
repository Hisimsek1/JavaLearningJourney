import java.util.Random;
import java.util.Scanner;

public class Enemy{
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    private String name;
    private int health , damage , money , defense;
    private Envanter env;

    public void enemyCha()
    {
        boolean durum = false;
        while(durum == false)
        {
            System.out.println("===Dusmanlar===");
            System.out.println("1- Haydut\t\tHasar : 4\tSaglik : 16\tDefans : 2\tOdul : 10");
            System.out.println("2- Vahsi Kurt\t\tHasar : 6\tSaglik : 20\tDefans : 1\tOdul : 15");
            System.out.println("3- Kara Sovalye\t\tHasar : 8\tSaglik : 28\tDefans : 6\tOdul : 25");
            System.out.println("4- Suikastci Dusman\tHasar : 10\tSaglik : 14\tDefans : 2\tOdul : 30");
            System.out.println("5- Dev Gladyator\tHasar : 12\tSaglik : 35\tDefans : 8\tOdul : 40");
            int secim;
            System.out.println("Rastegele dusman seciliyor...");
            try
            {
                Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            secim = rand.nextInt(5) + 1;
            
                switch(secim)
                {
                    case 1: 
                        this.name = "Haydut";
                        this.damage = 4;
                        this.health = 16;
                        this.defense = 2;
                        this.money = 10;
                        break;
                    case 2: 
                        this.name = "Vahsi Kurt";
                        this.damage = 6;
                        this.health = 20;
                        this.defense = 1;
                        this.money = 15;
                        break;
                    case 3: 
                        this.name = "Kara Sovalye";
                        this.damage = 8;
                        this.health = 28;
                        this.defense = 6;
                        this.money = 25;
                        break;
                    case 4: 
                        this.name = "Suikastci Dusman";
                        this.damage = 10;
                        this.health = 14;
                        this.defense = 2;
                        this.money = 30;
                        break;
                    case 5: 
                        this.name = "Dev Gladyator";
                        this.damage = 12;
                        this.health = 35;
                        this.defense = 8;
                        this.money = 40;
                        break;
                }
                durum = true;
                System.out.println("Dusman secildi!");
                
        }
        showStats();
    }


    

    public void showStats()
    {
        System.out.println("\n========== Dusman Özellikleri ==========");
        System.out.println("Isim     : " + getName());
        System.out.println("Hasar    : " + getDamage());
        System.out.println("Saglik   : " + getHealth());
        System.out.println("Defans   : " + getDefense());
        System.out.println("Para     : " + getMoney());
        System.out.println("==========================================\n");
    }







    

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public Envanter getEnv() {
        return env;
    }
    
    public int getMoney()
    {
        return money;
    }
    // SETTERLAR
    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setEnv(Envanter env) {
        this.env = env;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }
}
    