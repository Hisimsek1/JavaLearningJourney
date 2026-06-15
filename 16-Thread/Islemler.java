public class Islemler implements Runnable{
    String name;

    public Islemler(String name)
    {
        this.name = name;
    }

    public void run()
    {
        for(int i=5 ; i>0 ; i--)
        {
            System.out.println(this.name+" : "+i);
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                System.out.println(this.name + "hata ile karsilasildi.");
            }
        }
    }
}
