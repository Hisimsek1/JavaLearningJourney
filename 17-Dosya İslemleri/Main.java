import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        File file = new File("kod.txt");
        if(!file.exists())
        {
            file.createNewFile();
        }

        String val = "\nHalil İbrahim Şimşek";
        FileWriter fwriter = new FileWriter(file , false);
        BufferedWriter bwriter = new BufferedWriter(fwriter);
        bwriter.write("\nTunahan Şimşek");
        bwriter.write(val);
        bwriter.close();

        FileReader fReader = new FileReader(file);
        String line;
        BufferedReader breader = new BufferedReader(fReader);
        while((line=breader.readLine()) != null){
            System.out.println(line);
        }

        breader.close();
    }    
}
