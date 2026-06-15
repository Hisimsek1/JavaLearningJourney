import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // AncestorListener yerine bunu ekledik

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main4 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JLabel l1,l2,l3;
        JTextField t1,t2,t3;
        JButton btn = new JButton();

        l1 = new JLabel("İlk sayi");
        l1.setBounds(50,10,100,30);

        t1 = new JTextField();
        t1.setBounds(50,40,200,30);


        l2 = new JLabel("İkinci Sayi");
        l2.setBounds(50,70,100,30);

        t2 = new JTextField();
        t2.setBounds(50,100,200,30);

        l3 = new JLabel("Toplam");
        l3.setBounds(50,130,200,30);

        t3 = new JTextField();
        t3.setBounds(50,160,200,30);

        btn = new JButton("Toplam");
        btn.setBounds(50,220,200,30);
btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Metin kutularından alınan String değerleri tam sayıya (int) çeviriyoruz
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                
                int c = a + b;
                
                // Çıkan sonucu tekrar String'e çevirip 3. kutuya yazdırıyoruz
                String toplam = String.valueOf(c);
                t3.setText(toplam);
            }
        });

        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(l3);
        f.add(t3);
        f.add(btn);
        
        f.setSize(400, 400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Çarpıya basınca kapanması için ekledik
        f.setVisible(true);
    }
}