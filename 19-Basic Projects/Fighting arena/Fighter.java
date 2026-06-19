import java.util.Scanner;

public class Fighter {
    Scanner input = new Scanner(System.in);
    private String name , cName;
    private int health , maxHealth , damage , money , defense;
    private Envanter env;



    public void selectCha()
    {
        boolean durum = false;
        while(durum == false)
        {
            System.out.println("===Karakterler===");
            System.out.println("1- Samuray\t\tHasar : 6\tSaglik : 22\tDefans : 4\tPara : 15");
            System.out.println("2- Okcu\t\t\tHasar : 8\tSaglik : 18\tDefans : 2\tPara : 20");
            System.out.println("3- Sovalye\t\tHasar : 5\tSaglik : 30\tDefans : 8\tPara : 10");
            System.out.println("4- Suikastci\t\tHasar : 10\tSaglik : 15\tDefans : 1\tPara : 25");
            System.out.println("5- Boksor\t\tHasar : 7\tSaglik : 24\tDefans : 5\tPara : 18");
            
            int secim;
            System.out.print("Seciminizi yapin : ");
            secim = input.nextInt();
            
            if(secim<1 || secim >6 )
               durum = false;
            else
               durum = true;
            
            if(durum)
            {
                switch(secim)
                {
                    case 1: // Samuray
                        this.cName = "Samuray";
                        this.damage = 6;
                        this.health = 22;
                        this.maxHealth = 22;
                        this.defense = 4;
                        this.money = 15;
                        break;
                    case 2: // Okcu
                        this.cName = "Okcu";
                        this.damage = 8;
                        this.health = 18;
                        this.maxHealth = 18;
                        this.defense = 2;
                        this.money = 20;
                        break;
                    case 3: // Sovalye
                        this.cName = "Sovalye";
                        this.damage = 5;
                        this.health = 30;
                        this.maxHealth = 30;
                        this.defense = 8;
                        this.money = 10;
                        break;
                    case 4: // Suikastci
                        this.damage = 10;
                        this.cName = "Suikastci";
                        this.health = 15;
                        this.maxHealth = 15;
                        this.defense = 1;
                        this.money = 25;
                        break;
                    case 5: // Boksor
                        this.damage = 7;
                        this.health = 24;
                        this.cName = "Boksor";
                        this.maxHealth = 24;
                        this.defense = 5;
                        this.money = 18;
                        break;
                    
                }
                System.out.println("Karakter secildi!");
                showStats();
            }
        }


    }

    public void showStats()
    {
        System.out.println("\n========== Karakter Özellikleri ==========");
        System.out.println("Isim          : " + getName());
        System.out.println("Karakter ismi : "+getcName());
        System.out.println("Hasar         : " + getDamage());
        System.out.println("Saglik        : " + getHealth());
        System.out.println("Defans        : " + getDefense());
        System.out.println("Para          : " + getMoney());
        System.out.println("==========================================\n");
    }

    





    public String getcName()
    {
        return cName;
    }
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
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

    public void setcName(String cName)
    {
        this.cName = cName;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
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
