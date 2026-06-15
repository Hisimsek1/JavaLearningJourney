import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(200, 200);

        // 1. Paneli oluştur
        JPanel panel = new JPanel();
        
        // 2. Butonu oluştur
        JButton btn = new JButton("Button");
        
        // 3. DOĞRU KULLANIM: Butonu panele ekle
        panel.add(btn); 
        
        // 4. İçinde buton olan paneli pencereye (frame) ekle
        frame.add(panel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}