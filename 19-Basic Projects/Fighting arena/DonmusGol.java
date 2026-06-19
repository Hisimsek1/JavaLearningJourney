import java.util.Random;
import java.util.Scanner;

public class DonmusGol extends Location{
	Random rand = new Random();
	public DonmusGol(Fighter fighter, Scanner input,Enemy enemy)
	{
		super(fighter, input,enemy);
	}

	@Override
	public boolean getLocation()
	{
		
		System.out.println("Ring alanindasiniz. Hava çok soğuk. Dikkat et.");
		System.out.println("Dusmaniniz : " + enemy.getName());
        System.out.println("Savaş basliyor. Hazirlan...");
        System.out.println("===================================");
        System.out.println("|     O                 O        |");
        System.out.println("|    /|\\               /|\\       |");
        System.out.println("|    / \\               / \\       |");
        System.out.println("===================================");
		for(int j=3;j>0;j--)
            {
                System.out.print(j+" ");
                try
                {
                   Thread.sleep(1000);
                }
                   catch (InterruptedException e)
                { 
                   Thread.currentThread().interrupt();
                }
            }
            System.out.println();

        return fight();
		
	}

	public boolean fight()
	{
        System.out.println();
        if(fighter.getcName().equals("Okcu") || fighter.getcName().equals("Sovalye")|| fighter.getcName().equals("Suikastci"))
			{
				System.out.println("Sanslisin. "+fighter.getcName()+" donmuş golden etkilenmez.");
			}
			else 
			{
				System.out.println("Hava çok soğuk. "+fighter.getcName()+" soğuğa dayanmakta güçlük çekiyor.");
				int artis = rand.nextInt(2) + 1;
				System.out.println("Savunma "+artis+" azaldi.");
                fighter.setDefense(Math.max(0, fighter.getDefense()-artis));
			}
		while(fighter.getHealth() > 0 && enemy.getHealth()>0)
		{
			

			System.out.println("<A>tak    <S>avunma");
			String secim = input.next();
            secim = secim.toUpperCase();
            if(secim.equals("A"))
			{
				int indexS = rand.nextInt(saldiriCumleleri.length);
				System.out.println("Siz : "+saldiriCumleleri[indexS]);
                enemy.setHealth(enemy.getHealth()-calculateDamage(fighter.getDamage(), enemy.getDefense()));
                try
                {
                   Thread.sleep(1000);
                }
                   catch (InterruptedException e)
                { 
                   Thread.currentThread().interrupt();
                }
				

				if(enemy.getHealth()<=0)
					{
						System.out.println(enemy.getName() + " yenildi!");
                        fighter.setMoney(fighter.getMoney() + enemy.getMoney());
                        System.out.println("Kazanilan para : " + enemy.getMoney());
                        System.out.println("Guncel Para : " + fighter.getMoney()); 
						return true;
					}
                int index2 = rand.nextInt(saldiriCumleleri.length);
                System.out.println("Dusman : "+saldiriCumleleri[index2]);
                fighter.setHealth(fighter.getHealth() - calculateDamage(enemy.getDamage(), fighter.getDefense()));
                try
                {
                   Thread.sleep(1000);
                }
                   catch (InterruptedException e)
                { 
                   Thread.currentThread().interrupt();
                }
                fighterStats();
                enemyStats();
			}
			else if(secim.equals("S"))
			{
				int indexSavunma = rand.nextInt(savunmaCumleleri.length);
                System.out.println("Siz : "+savunmaCumleleri[indexSavunma]);
                fighter.setHealth(fighter.getHealth() - calculateDamage(enemy.getDamage(), fighter.getDefense()));
                try
                {
                   Thread.sleep(1000);
                }
                   catch (InterruptedException e)
                { 
                   Thread.currentThread().interrupt();
                }
				fighterStats();
                enemyStats();
			}
            else
            {
                System.out.println("Yanlis secim yaptiniz.");
                continue;
            }
			 if (fighter.getHealth() <= 0)
            {
                System.out.println("Oldunuz...");
                return false;
            }
		}
		return true;
	}

    private int calculateDamage(int attack, int defense)
    {
        return Math.max(0, attack - defense);
    }

    public void fighterStats()
    {
        System.out.println("----------");
        System.out.println(fighter.getName()+"'in Saglik  : "+fighter.getHealth());
    }
    public void enemyStats()
    {
        
        System.out.println(enemy.getName()+"in Saglik : "+enemy.getHealth());
        System.out.println("----------");
    }

	String[] saldiriCumleleri = {
    "Buz ustunde sert yumruk!",
    "Kaygan zeminde isabet!",
    "Rakip tutunamadi!",
    "Cok kritik vurus!",
    "Dengeyi bozdu!",
    "Buz gibi darbe!",
    "Rakip kaydi ve vuruldu!",
    "Sert combo geldi!",
    "Kontrol tamamen onda!",
    "Zemin avantaji kullandi!",
    "Rakip savruldu!",
    "Cok hizli atak!",
    "Buzda firtina gibi!",
    "Rakip reaksiyon veremedi!",
    "Bitirici vurus geldi!"
};

String[] savunmaCumleleri = {
    "Kaydi, savunamadi!",
    "Dengeyi koruyamadi!",
    "Savunma cok zayif!",
    "Buz ustunde kontrol zor!",
    "Blok gecikti!",
    "Rakip kolay gecti!",
    "Savunma kirdi!",
    "Ayakta durmakta zor!",
    "Refleks yetmedi!",
    "Kaygan zemin etkiledi!",
    "Savunma acildi!",
    "Rakip bosluk buldu!",
    "Zor durumda kaldi!",
    "Denge kaybi buyuk!",
    "Savunma neredeyse yok!"
};
}
