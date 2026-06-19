import java.util.Random;
import java.util.Scanner;

public class Ring extends Location{
	Random rand = new Random();
	public Ring(Fighter fighter, Scanner input, Enemy enemy)
	{
		super(fighter, input,enemy);
	}

	@Override
	public boolean getLocation()
	{
		System.out.println("Ring alanindasiniz");
		System.out.println("Dusmaniniz : " + enemy.getName());
        System.out.println("Müsabaka basliyor. Hazirlan...");
        System.out.println("===================================");
        System.out.println("|     O                 O         |");
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
		System.out.println("Ringte bazi kurallar vardir ve bu kurallara uymayanlar diskalifiye edilir.");
        if(fighter.getcName().equals("Samuray") || fighter.getcName().equals("Boksor") )
			{
				System.out.println("Iste Bu. Burasi "+fighter.getcName()+"'in yeri.");
				int artis = rand.nextInt(5) + 1;
				System.out.println("Hasarin "+artis+" artti.");
				fighter.setDamage(artis+fighter.getDamage());
			}
			else 
			{
                System.out.println(fighter.getcName()+" burasi onun yeri degil.");
				int artis = rand.nextInt(5) + 1;
				System.out.println("Hasarin "+artis+" azaldi.");
                fighter.setDamage(Math.max(1, fighter.getDamage()-artis));

			}
		while(fighter.getHealth() > 0 && enemy.getHealth()>0)
		{
			

			System.out.println("<A>tak    <S>avunma");
			String secim = input.next();
            secim = secim.toUpperCase();
            if(secim.equals("A"))
			{
				System.out.println("<Y>umruk\t\t<D>irsek\t\t<T>ekme");
				String atakSecim = input.next();
                atakSecim = atakSecim.toUpperCase();
                if(atakSecim.equals("Y"))
				{
					int indexY = rand.nextInt(yumrukCumleleri.length);
                    System.out.println("Sen : "+yumrukCumleleri[indexY]);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    int attackDamage = (int) Math.floor(fighter.getDamage() * 0.75);
                    enemy.setHealth(enemy.getHealth() - calculateDamage(attackDamage, enemy.getDefense()));
					

					if(enemy.getHealth()<=0)
					{
						System.out.println(enemy.getName() + " yenildi!");
                        fighter.setMoney(fighter.getMoney() + enemy.getMoney());
                        System.out.println("Kazanilan para : " + enemy.getMoney());
                        System.out.println("Guncel Para : " + fighter.getMoney()); 
						return true;
						
					}
                    int index2 = rand.nextInt(yumrukCumleleri.length);
                    System.out.println("Düşman : "+yumrukCumleleri[index2]);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    fighter.setHealth(fighter.getHealth() - calculateDamage(enemy.getDamage(), fighter.getDefense()));
                    fighterStats();
                    enemyStats();
				}
				else if(atakSecim.equals("T"))
				{
					int indexT = rand.nextInt(tekmeCumleleri.length);
                    System.out.println("Sen : "+tekmeCumleleri[indexT]);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    int attackDamage = (int) Math.floor(fighter.getDamage() * 0.65);
                    enemy.setHealth(enemy.getHealth() - calculateDamage(attackDamage, enemy.getDefense()));
					

					if(enemy.getHealth()<=0)
					{
						System.out.println(enemy.getName() + " yenildi!");
                        fighter.setMoney(fighter.getMoney() + enemy.getMoney());
                        System.out.println("Kazanilan para : " + enemy.getMoney());
                        System.out.println("Guncel Para : " + fighter.getMoney()); 
						return true;
					}
                    int index2 = rand.nextInt(yumrukCumleleri.length);
                    System.out.println("Düşman : "+yumrukCumleleri[index2]);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    fighter.setHealth(fighter.getHealth() - calculateDamage(enemy.getDamage(), fighter.getDefense()));
                    fighterStats();
                    enemyStats();

				}
				else if(atakSecim.equals("D"))
				{
					System.out.println("Attiginiz dirsek "+enemy.getName()+"'i kötü yaraladi.");
					System.out.println("Diskalifiye edildiniz...");
                    return false;
				}
				else 
				{
					System.out.println("Yanlis secim yaptiniz.");
					continue;
				}

			}
			else if(secim.equals("S"))
			{
				int indexSavunma = rand.nextInt(ringSavunmaCumleleri.length);
                System.out.println("Sen : "+ringSavunmaCumleleri[indexSavunma]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                // Defense doubles your defense value for better protection
                int enhancedDefense = fighter.getDefense() * 2;
                fighter.setHealth(fighter.getHealth() - calculateDamage(enemy.getDamage(), enhancedDefense));
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




	String[] yumrukCumleleri = {
    "Saglam yumruk indi!",
    "Rakip sarsildi!",
    "Cok sert krose!",
    "Direkt isabet!",
    "Fena patladi yumruk!",
    "Rakip geri cekildi!",
    "Hizli jab!",
    "Kafaya tam isabet!",
    "Cok guclu yumruk!",
    "Rakip sendeledi!",
    "Kritik yumruk!",
    "Ceneye oturdu!",
    "Cok temiz vurdu!",
    "Rakip savruldu!",
    "Sok etkili yumruk!",
    "Ringte patlama!",
    "Rakip zor durumda!",
    "Cok hizli combo yumruk!",
    "Savunma delindi!",
    "Rakip duramadi!",
    "Agir yumruk indi!",
    "Cok net isabet!",
    "Rakip sersemledi!",
    "Bitirici yumruk!",
    "Ring sallandi!"
};

String[] tekmeCumleleri = {
    "Sert tekme indi!",
    "Rakip savruldu!",
    "Cok guclu tekme!",
    "Karin bolgesine darbe!",
    "Fena tekme yedi!",
    "Rakip dengesini kaybetti!",
    "Hizli donen tekme!",
    "Kafaya yakin isabet!",
    "Cok aci tekme!",
    "Rakip yere yakin!",
    "Yan tekme patladi!",
    "Sok etkili tekme!",
    "Rakip geri itildi!",
    "Cok net tekme!",
    "Savunma kirildi!",
    "Rakip sendeledi!",
    "Hizli low kick!",
    "Agir darbe!",
    "Cok sert carpma!",
    "Rakip kontrol kaybetti!",
    "Bitirici tekme!",
    "Cok temiz vurdu!",
    "Rakip zorlandi!",
    "Ringte sarsinti!",
    "Cok kritik tekme!"
};

String[] ringSavunmaCumleleri = {
    "Mukemmel blok!",
    "Rakip gecemedi!",
    "Duvar gibi savundu!",
    "Cok saglam durdu!",
    "Savunma ust seviye!",
    "Rakip bos vurdu!",
    "Refleksler harika!",
    "Darbeyi eritti!",
    "Cok temiz karsilik!",
    "Savunma kilitlendi!",
    "Rakip sasirdi!",
    "Hic acik yok!",
    "Zamani mukemmel!",
    "Cok iyi okudu!",
    "Rakip durdu!",
    "Savunma saglam!",
    "Cok iyi kapatti!",
    "Rakip bosluk bulamadi!",
    "Kritik blok!",
    "Cok profesyonel!",
    "Rakip zorlandi!",
    "Temiz savunma!",
    "Hic zarar yok!",
    "Rakip geri cekildi!",
    "Savunma duvari!",
    "Cok net refleks!",
    "Rakip etkisiz!",
    "Kontrol onda!",
    "Cok iyi pozisyon!",
    "Rakip sasirdi!",
    "Savunma kirilmaz!",
    "Cok saglam blok!",
    "Rakip bos denedi!",
    "Hic acik vermedi!",
    "Cok hizli refleks!",
    "Rakip yoruldu!",
    "Savunma ustu!",
    "Cok temiz durus!",
    "Rakip hata yapti!",
    "Darbe etkisiz!",
    "Cok iyi tahmin!",
    "Rakip durakladi!",
    "Savunma mukemmel!",
    "Hic hasar yok!",
    "Rakip caresiz!",
    "Cok saglam!",
    "Rakip kaybetti momentum!",
    "Savunma kazandi!",
    "Cok net karsilik!",
    "Rakip durdu!"
};
}
