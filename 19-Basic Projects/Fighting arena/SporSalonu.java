public class SporSalonu extends Location{
    public SporSalonu(Fighter fighter, java.util.Scanner input)
	{
        super(fighter, input);
	}

	@Override
	public boolean getLocation()
	{
		boolean inGym = true;
        while (inGym)
        {
            System.out.println("\nParaniz : " + fighter.getMoney());
            System.out.println("1. Atak");
            System.out.println("2. Savunma");
            System.out.println("3. Cikis");
            System.out.print("Seciminiz : ");
            System.out.println();
            int secim = input.nextInt();
            int selItemID;

            switch(secim)
            {
                case 1:
                    selItemID = AtakMenu();
                    buyAtak(selItemID);
                    break;
                case 2:
                    selItemID = SavunmaMenu();
                    buySavunma(selItemID);
                    break;
                case 3:
                    System.out.println("Spor salonundan cikis yapiliyor...");
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    }
                    inGym = false;
                    break;
                default:
                    System.out.println("Gecersiz islem!");
            }
        }

        return true;
	}

    public int AtakMenu()
    {
        System.out.println("1. Acemi Koc             - Para : 15 - Hasar : 2");
        System.out.println("2. Tecrubeli Koc         - Para : 25 - Hasar : 4");
        System.out.println("3. Profesyonel Koc       - Para : 35 - Hasar : 7");
        System.out.print("Seciminiz : ");
        System.out.println();
        int secim = input.nextInt();
        return secim;
    }

    public void buyAtak(int secim)
    {
        int damage=0,price=0;
        switch(secim)
        {
            case 1:
                damage = 2;
                price = 15;
                break;
            case 2:
                damage = 4;
                price = 25;
                break;
            case 3:
                damage = 7;
                price = 35;
                break;
            default:
                System.out.println("Gecersiz islem!");
                return;
        }

       
        if(fighter.getMoney() >= price)
        {
            fighter.setDamage(fighter.getDamage()+damage);
            fighter.setMoney(fighter.getMoney()-price);
            System.out.println("Gelisim tamamlandi...");
            System.out.println("Yeni hasariniz : " + fighter.getDamage());
            System.out.println("Kalan paraniz : " + fighter.getMoney());
        }
        else 
            System.out.println("Yeterli paraniz yok.");
    }

    public int SavunmaMenu()
    {
        System.out.println("1. Acemi Koc              - Para : 12 - Defans : 1");
        System.out.println("2. Tecrubeli Koc         - Para : 20 - Defans : 3");
        System.out.println("3. Profesyonel Koc       - Para : 25 - Defans : 5");
        System.out.print("Seciminiz : ");
        int secim = input.nextInt();
        return secim;
    }

    public void buySavunma(int secim)
    {
        int savunma=0,price=0;
        switch(secim)
        {
            case 1:
                savunma = 1;
                price = 12;
                break;
            case 2:
                savunma = 3;
                price = 20;
                break;
            case 3:
                savunma = 5;
                price = 25;
                break;
            default:
                System.out.println("Gecersiz islem!");
                return;
        }

       
        if(fighter.getMoney() >= price)
        {
            fighter.setDefense(fighter.getDefense()+savunma);
            fighter.setMoney(fighter.getMoney()-price);
            System.out.println("Gelisim tamamlandi...");
            System.out.println("===============");
            System.out.println("Yeni defansiniz : " + fighter.getDefense());
            System.out.println("Kalan paraniz : " + fighter.getMoney());
            System.out.println("===============");
        }
        else 
            System.out.println("Yeterli paraniz yok.");
    }
}
