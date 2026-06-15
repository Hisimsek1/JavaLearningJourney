
public class Main {
    public static void main(String[] args) {

        
        Islemler i = new Islemler("ilk");
        Thread t1 = new Thread(i);

        Islemler i2 = new Islemler("Son");
        Thread t2 = new Thread(i2);
        t1.start();
        t2.start();
    }    
}
