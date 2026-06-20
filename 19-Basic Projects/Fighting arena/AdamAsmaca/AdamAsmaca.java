import java.util.Random;
import java.util.Scanner;

public class AdamAsmaca {
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    String kelime;
    int rastgelesayi;
    boolean game = true;

    public AdamAsmaca()
    {
    }

    public void run()
    {
        int i=0;
        print();
        String gizliKelime = RastegeleKelime();
        int harfSayisi = gizliKelime.length();
        
        System.out.println("6 Tahmin hakkiniz vardir !");
        System.out.println("Kelimeniz "+harfSayisi+" harflidir.");
        System.out.println("Ipucu : "+Ipucu());
        System.out.println("---------------------------");
        while(i<6)
        {
            while(game)
        {
            int rastegeleIndex = rand.nextInt(harfSayisi);
            System.out.print("Tahmin icin bir kelime giriniz :");
            kelime = input.next();
            if(kelime.equals(gizliKelime))
            {
                System.out.println("Tebrikler. Dogru tahmin.");
                System.out.println("Kelime : "+gizliKelime);
                i = 10;
                game = false;
                
                
            }
            else
            {
                System.out.println("Yanlis tahmin ! ");
                System.out.println((5-i+" hakkiniz kaldi."));
                if(i == 0)
                {
                    kafa();
                    System.out.println("Kelimenizin "+(rastegeleIndex+1)+". harfi : "+gizliKelime.charAt(rastegeleIndex));
                    System.out.println("---------------------------");
                }
                else if(i == 1)
                {
                    gövde();
                    System.out.println("Kelimenizin "+(rastegeleIndex+1)+". harfi : "+gizliKelime.charAt(rastegeleIndex));
                    System.out.println("---------------------------");
                }
                else if(i == 2)
                 {
                    kol1();
                    System.out.println("Kelimenizin "+(rastegeleIndex+1)+". harfi : "+gizliKelime.charAt(rastegeleIndex));
                    System.out.println("---------------------------");
                }
                else if(i == 3)
                {
                    kol2();
                    System.out.println("Kelimenizin "+(rastegeleIndex+1)+". harfi : "+gizliKelime.charAt(rastegeleIndex));
                    System.out.println("---------------------------");
                }
                else if(i == 4)
                {
                    bacak1();
                    System.out.println("Kelimenizin "+(rastegeleIndex+1)+". harfi : "+gizliKelime.charAt(rastegeleIndex));
                    System.out.println("---------------------------");
                }
                else if(i == 5)
                {
                    bacak2();
                    System.out.println("OYUNU KAYBETTİNİZ !!");
                    System.out.println("Kelime : "+gizliKelime);
                    i =10;
                    break;
                }
                i++;
                break;

            }
        }
        }
    }

    public void print()
    {
        System.out.println("  +---+\r\n" + //
                        "  |   |\r\n" + //
                        "      |\r\n" + //
                        "      |\r\n" + //
                        "      |\r\n" + //
                        "      |\r\n" + //
                        "=========");
        System.out.println();
    }

    public void kafa()
    {
        System.out.println("  +---+\r\n" + //
                        "  |   |\r\n" + //
                        "  O   |\r\n" + //
                        "      |\r\n" + //
                        "      |\r\n" + //
                        "      |\r\n" + //
                        "=========");
        System.out.println();
    }

    public void gövde()
    {
        System.out.println("  +---+\r\n" + //
                        "  |   |\r\n" + //
                        "  O   |\r\n" + //
                        "  |   |\r\n" + //
                        "      |\r\n" + //
                        "      |\r\n" + //
                        "=========");
       System.out.println(); 
    }

    public void kol1()
    {
        System.out.println("  +---+\r\n" + //
                        "  |   |\r\n" + //
                        "  O   |\r\n" + //
                        " /|   |\r\n" + //
                        "      |\r\n" + //
                        "      |\r\n" + //
                        "=========");
        System.out.println();
    }

    public void kol2()
    {
        System.out.println("  +---+\r\n" + //
                        "  |   |\r\n" + //
                        "  O   |\r\n" + //
                        " /|\\  |\r\n" + //
                        "      |\r\n" + //
                        "      |\r\n" + //
                        "=========");
        System.out.println();
    }

    public void bacak1()
    {
        System.out.println("  +---+\r\n" + //
                        "  |   |\r\n" + //
                        "  O   |\r\n" + //
                        " /|\\  |\r\n" + //
                        " /    |\r\n" + //
                        "      |\r\n" + //
                        "=========");
        System.out.println();
    }

    public void bacak2()
    {
        System.out.println("  +---+\r\n" + //
                        "  |   |\r\n" + //
                        "  O   |\r\n" + //
                        " /|\\  |\r\n" + //
                        " / \\  |\r\n" + //
                        "      |\r\n" + //
                        "=========");
        System.out.println();
    }

    public String Ipucu()
    {
        String[] ipucu = {
    "Dalda yetisen kirmizi ya da yesil bir meyvedir.",
    "Tekerlekli ve insanlari tasiyan bir ulasim aracidir.",
    "Yazi yazmak icin kullanilan bir aractir.",
    "Not almak icin kullanilan kagitlardan olusan esyadir.",
    "Esya koymak ya da uzerinde calismak icin kullanilir.",
    "Oturmak icin kullanilan esyadir.",
    "Hesaplama ve islem yapabilen elektronik cihazdir.",
    "Iletisim kurmak icin kullanilan tasinabilir cihazdir.",
    "Kulaga takilarak ses dinlemeyi saglayan aracdir.",
    "Esya tasimak icin kullanilan bir aksesuardir.",

    "Basimizi koyup uyudugumuz yumusak esyadir.",
    "Uyurken ustumuze orttugumuz kalin ortudur.",
    "Disariyi gormemizi saglayan camli yapi parcasidir.",
    "Bir seyin ustunu kapatan parcadir.",
    "Ortamı aydinlatan elektrikli esyadir.",
    "Karanligi gideren aydinliktir.",
    "Dunyayi isitan buyuk gok cismidir.",
    "Parlaklik ve isikla ilgili bir isimdir.",
    "Gece gokyuzunde parlayan gok cismidir.",
    "Gunes etrafinda dolasan buyuk gok cismidir.",

    "Dunya disindaki sonsuz boslugu ifade eder.",
    "Uzaya gitmek icin kullanilan aracdir.",
    "Bir gezegenin etrafinda dolasan arac ya da gok cismidir.",
    "Uzaya giden egitimli kisidir.",
    "Uzerinde yasadigimiz gezegendir.",
    "Yerleri ve bolgeleri gosteren cizimdir.",
    "Tuzlu ve genis su birikintisidir.",
    "Denizlerden daha buyuk su toplulugudur.",
    "Akan tatli su kaynagidir.",
    "Karalar icindeki buyuk su birikintisidir.",

    "Yuksek ve buyuk kara yukseltileridir.",
    "Cok sayida agacin bulundugu dogal alandir.",
    "Govdesi ve dallari olan buyuk bitkidir.",
    "Guzel kokulu ve renkli bitki parcasidir.",
    "Topraktan yetisen canli turudur.",
    "Uzerinde yurudugumuz yer yuzeyidir.",
    "Soludugumuz gaz karisimidir.",
    "Esinti halinde hareket eden havadir.",
    "Cok siddetli ruzgar olayidir.",
    "Bulutlardan yeryuzune dusen su damlacigidir.",

    "Soguk havada gokten yagan beyaz kristallerdir.",
    "Suyun donmus halidir.",
    "Yakan ve isitan alevli olaydir.",
    "Yanan bir seyden cikan gri gazdir.",
    "Yeralti atesinden cikan erimis sicak maddedir.",
    "Patladiginda lav cikaran dagdir.",
    "Yerin sarsilmasi olayidir.",
    "Asiri su birikmesiyle olusan afet durumudur.",
    "Hayat sahibi varliklarin genel adidir.",
    "Insan disindaki yasayan varliklarin genel adidir.",

    "Evde beslenen miyavlayan hayvandir.",
    "Sadikligiyle bilinen havlayan hayvandir.",
    "Kanatlariyla ucabilen hayvandir.",
    "Suda yasayan solungacli canlidir.",
    "Surunerek hareket eden uzun govdeli hayvandir.",
    "Cizgili ve yirtici bir vahsi hayvandir.",
    "Ormanlarin krali olarak bilinen vahsi hayvandir.",
    "Hortumlu ve buyuk govdeli hayvandir.",
    "Siyah beyaz cizgileri olan hayvandir.",
    "Agactan agaca ziplayan hayvandir.",

    "Dusunebilen ve konusabilen canli turudur.",
    "Kucuk yastaki insandir.",
    "Genc yas grubundaki kisidir.",
    "Buyumus ve olgunlasmis kisidir.",
    "Ileri yastaki kisidir.",
    "Hastalari muayene edip tedavi eden kisidir.",
    "Ogrencilere ders anlatan kisidir.",
    "Teknik cozumler ureten meslek sahibidir.",
    "Hukuk alaninda calisan meslek sahibidir.",
    "Guvenligi saglamakla gorevli kisidir.",

    "Ulkesini savunmakla gorevli kisidir.",
    "Mal ya da urun satan kisidir.",
    "Restoranda musterilere hizmet eden kisidir.",
    "Yemek yapan meslek sahibidir.",
    "Ucak kullanan meslek sahibidir.",
    "Arac suren kisidir.",
    "Kitap ya da yazi yazan kisidir.",
    "Sanat ureten kisidir.",
    "Muzik yapan ya da soyleyen kisidir.",
    "Sporla profesyonel olarak ilgilenen kisidir.",

    "Ayakla oynanan populer takim sporudur.",
    "Topla potaya sayi atilan takim sporudur.",
    "File uzerinden oynanan takim sporudur.",
    "Raket ve topla oynanan bireysel spordur.",
    "Suda yapilan bir spor dalidir.",
    "Hizli sekilde ayakta ilerleme eylemidir.",
    "Iki tekerlekli aracla yapilan spor ya da ulasimdir.",
    "Eglence amacli oynanan etkindir.",
    "Okunan yazili eserlerin genel adidir.",
    "Izlenen hareketli goruntu yapimidir.",

    "Bolumlerden olusan televizyon yapimidir.",
    "Seslerin uyumlu bicimde olusturdugu sanattir.",
    "Cizim veya boyamayla ortaya cikan gorsel sanattir.",
    "Tas ya da benzeri maddelerden yapilan uc boyutlu sanattir.",
    "Goruntu cekmeye yarayan cihazdir.",
    "Bir anin cekilmis goruntusudur.",
    "Hareketli goruntulerin kaydidir.",
    "Bilgisayarlar arasindaki buyuk baglanti agidir.",
    "Bilgisayara ne yapacagini soyleyen programlarin genel adidir.",
    "Bilgisayarin fiziksel parcalarinin genel adidir."
     };

    return ipucu[rastgelesayi];
    }


    public String  RastegeleKelime()
    {
        
        rastgelesayi = rand.nextInt(100);
         String[] kelime = {
    "elma","araba","kalem","defter","masa","sandalye","bilgisayar","telefon","kulaklik","canta",
    "yastik","yorgan","pencere","kapak","lamba","isik","gunes","aydin","yildiz","gezegen",
    "uzay","roket","uydu","astronot","dunya","harita","deniz","okyanus","nehir","gol",
    "dag","orman","agac","cicek","bitki","toprak","hava","ruzgar","firtina","yagmur",
    "kar","buz","ates","duman","lav","volkan","deprem","sel","canli","hayvan",
    "kedi","kopek","kus","balik","yilan","kaplan","aslan","fil","zebra","maymun",
    "insan","cocuk","genc","yetiskin","yasli","doktor","ogretmen","muhendis","avukat","polis",
    "asker","satici","garson","asci","pilot","sofor","yazar","sanatci","muzisyen","sporcu",
    "futbol","basket","voleybol","tenis","yuzme","kosu","bisiklet","oyun","kitap","film",
    "dizi","muzik","resim","heykel","kamera","foto","video","internet","yazilim","donanim"
};
         return kelime[rastgelesayi];

    }

    


}
