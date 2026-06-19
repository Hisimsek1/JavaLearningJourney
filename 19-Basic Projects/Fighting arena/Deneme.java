public class Deneme {
    public static void main(String[] args) {
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
    }
}
