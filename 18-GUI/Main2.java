import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;    // Tıklama olayını temsil eden sınıf
import java.awt.event.ActionListener; // Tıklamayı dinleyecek arayüz

public class Main2 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JButton btn = new JButton("Gönder");
        btn.setBounds(100, 0, 100, 30);

        // DOĞRU KULLANIM: Buton tıklamaları için ActionListener ekliyoruz
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // ActionEvent parametresi eklendi
                System.out.println("Butona tiklandi");
            }
        });

        f.add(btn);
        f.setSize(400, 400);
        f.setLayout(null);
        
        // Bir önceki sorunuzda öğrendiğimiz, çarpıya basınca programı kapatma kodu (İyi bir pratiktir)
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        f.setVisible(true);
    }
}