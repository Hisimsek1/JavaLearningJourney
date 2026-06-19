import java.util.Random;
import java.util.Scanner;

public class Sokak extends Location {
    private final Random rand = new Random();

    public Sokak(Fighter fighter, Scanner input, Enemy enemy)
    {
        super(fighter, input, enemy);
    }

    @Override
    public boolean getLocation()
    {
        System.out.println("Suan sokaktasiniz");
        System.out.println("Dusmaniniz : " + enemy.getName());
        System.out.println("Kavga basliyor. Hazirlan...");
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
        while (fighter.getHealth() > 0 && enemy.getHealth() > 0)
        {
            System.out.println("<A>tak    <S>avunma");
            String secim = input.next().toUpperCase();

            if (secim.equals("A"))
            {
                int index = rand.nextInt(vurusCumleleri.length);
                int streetBonus = rand.nextInt(4) == 0 ? 2 : 0;

                if (streetBonus > 0)
                {
                    System.out.println("Sokak avantajini yakaladiniz! +" + streetBonus + " hasar");
                }

                System.out.println("Sen : " + vurusCumleleri[index]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                int fighterAttack = fighter.getDamage() + streetBonus;
                int enemyDamageTaken = calculateDamage(fighterAttack, enemy.getDefense());
                enemy.setHealth(enemy.getHealth() - enemyDamageTaken);
                
                

                if (enemy.getHealth() <= 0)
                {
                    System.out.println(enemy.getName() + " yenildi!");
                    fighter.setMoney(fighter.getMoney() + enemy.getMoney());
                    System.out.println("Kazanilan para : " + enemy.getMoney());
                    System.out.println("Guncel Para : " + fighter.getMoney());
                    return true;
                }
                int index2 = rand.nextInt(vurusCumleleri.length);

                System.out.println("Düşman : "+vurusCumleleri[index2]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                int fighterDamageTaken = calculateDamage(enemy.getDamage(), fighter.getDefense());
                fighter.setHealth(fighter.getHealth() - fighterDamageTaken);
                fighterStats();
                enemyStats();
            }
            else if (secim.equals("S"))
            {
                int indexSavunma = rand.nextInt(savunmaCumleleri.length);
                System.out.println("Sen : "+savunmaCumleleri[indexSavunma]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                fighterStats();
                enemyStats();

                if (rand.nextInt(3) == 0)
                {
                    System.out.println("Sokakta bir kontra firsati yakaladiniz.");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    enemy.setHealth(enemy.getHealth() - calculateDamage(1, enemy.getDefense()));
                    fighterStats();
                enemyStats();
                }
            }
            else
            {
                System.out.println("Gecersiz komut!");
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

    String[] vurusCumleleri = {
    "Boom! Saglam vurdu!",
    "Tam isabet!",
    "Rakip sallandi!",
    "Cok sert girdi!",
    "Kafaya indi yumruk!",
    "Fena carpisti!",
    "Sok etkisi!",
    "Direkt iceri girdi!",
    "Savunma delindi!",
    "Rakip duramadi!",
    "Patlatti yumrugu!",
    "Hizli bitirici vurus!",
    "Rakibi sersemletti!",
    "Kontrol onda!",
    "Cok temiz vurdu!",
    "Rakip sarsildi!",
    "Acayip isabet!",
    "Firtina gibi girdi!",
    "Rakip cozuldu!",
    "Sert kombin!",
    "Direkt indirdi!",
    "Cok hizli vurdu!",
    "Rakip geri cekildi!",
    "Yikici darbe!",
    "Savunma yok oldu!",
    "Rakip bozuldu!",
    "Cok net vurdu!",
    "Fena yakaladi!",
    "Rakip kitlendi!",
    "Sok yumruk!",
    "Hedefi buldu!",
    "Rakip savruldu!",
    "Cok agresif!",
    "Bitirici vurus!",
    "Rakip dayanamadı!",
    "Cok sert carpma!",
    "Hizli giris!",
    "Rakip sarsildi!",
    "Kontrolu aldi!",
    "Cok net combo!",
    "Rakip dusmeye yakin!",
    "Acimasiz vurus!",
    "Sok dalga!",
    "Rakip kaybetti dengeyi!",
    "Fena patladi!",
    "Hizli finish!",
    "Rakip zor durumda!",
    "Cok guclu darbe!",
    "Savasin kontrolu onda!"
};

String[] savunmaCumleleri = {
    "Kalkti blokladi!",
    "Saglam kapatti!",
    "Saldiriyi sildi!",
    "Duvar gibi durdu!",
    "Refleks cok hizli!",
    "Darbenin etkisini kesti!",
    "Rakibi durdurdu!",
    "Temiz savunma!",
    "Zamani yakaladi!",
    "Hasar yok denecek kadar az!",
    "Rakip bos vurdu!",
    "Cok iyi okudu!",
    "Savunma mukemmel!",
    "Acimadi!",
    "Sert blok!",
    "Rakibi kilitledi!",
    "Cok saglam durdu!",
    "Kritik engelleme!",
    "Rakip sasirdi!",
    "Hic acik vermedi!",
    "Temiz refleks!",
    "Darbe eridi gitti!",
    "Rakip bosluk bulamadi!",
    "Kontrol onda!",
    "Savunma duvari kurdu!",
    "Rakip yavasladi!",
    "Hic hasar almadi!",
    "Cok profesyonel blok!",
    "Rakip sasirdi!",
    "Tam zamaninda!",
    "Savunma kilitlendi!",
    "Rakip geri cekildi!",
    "Cok iyi pozisyon!",
    "Darbe etkisiz!",
    "Rakip hata yapti!",
    "Hic acik vermedi!",
    "Mukemmel durus!",
    "Rakip yoruldu!",
    "Savunma ust seviyesi!",
    "Cok iyi tahmin!",
    "Rakip bosluk bulamadi!",
    "Sert karsilik!",
    "Darbe karsilandi!",
    "Rakip etkisiz!",
    "Savunma bozmadı!",
    "Cok net blok!",
    "Rakip durakladi!",
    "Kontrol saglam!",
    "Hic zarar yok!",
    "Rakip caresiz!"
};
}
