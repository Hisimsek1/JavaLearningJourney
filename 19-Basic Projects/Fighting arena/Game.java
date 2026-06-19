import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);
    Fighter fighter;
    Enemy enemy;
    Location location;

    public Game()
    {
        fighter = new Fighter();
        enemy = new Enemy();
        
    }

    public void login()
    {
        String name;
        System.out.print("Lutfen karakterinizin ismini giriniz : ");
        name = input.nextLine();
        fighter.setName(name);
        start();

    }

    public void start()
    {
        fighter.selectCha();
        while(true)
        {
            System.out.println();
        System.out.println("-------------");
        System.out.println();
        System.out.println("Lutfen bir mekan seciniz : ");
        System.out.println("1. Hospital --> Caniniz yenilenir.");
        System.out.println("2. Sokak --> Sokakta kural yoktur. Biri ölür , biri cikar.");
        System.out.println("3. Ring --> Bazi karakterlerin damage'i artar. Bazilarinin azalir.");
        System.out.println("4. Donmuş Göl --> Bazi karakterlerin defansi azalir. Bazilarinin artar.");
        System.out.println("5. Spor Salonu --> Karakterini gelistirebilirsin.");
        int selloc = input.nextInt();
        while(selloc<0 || selloc>5)
        {
            System.out.println("Lutfen gecerli bir yer seciniz : ");
            selloc = input.nextInt();
        }
        switch(selloc)
        {
            case 1 :
                location = new Hospital(fighter, input);
                break;
            case 2:
                enemy.enemyCha();
                location = new Sokak(fighter, input, enemy);
                break;
            case 3:
                enemy.enemyCha();
                location = new Ring(fighter, input,enemy);
                break;
            case 4:
                enemy.enemyCha();
                location = new DonmusGol(fighter, input,enemy);
                break;

            case 5:
                location = new SporSalonu(fighter, input);
                break;
            
        }
        boolean locationResult = location.getLocation();
        if(!locationResult)
        {
            System.out.println("Mekan sonucu negatif. Oyun sonlandi.");
            break;
        }
        }
    }
}
