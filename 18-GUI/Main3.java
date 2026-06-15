import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;    // Tıklama olayını temsil eden sınıf
import java.awt.event.ActionListener; 

public class Main3 {
 public static void main(String[] args) {
    
    JFrame f =new JFrame();

    JLabel l1 = new JLabel("Yazı Kısmı ");
    l1.setText("Yazılar");
    l1.setBounds(100,50,150,30);
    
    JButton btn = new JButton("Değiştir");
    btn.setBounds(100,100,100,30);

    btn.addActionListener(new ActionListener() {
        int c = 1;    
        @Override
            public void actionPerformed(ActionEvent e) { // ActionEvent parametresi eklendi
    
                l1.setText("Butona "+  c++  +" kez tıklandı");
            }
        });

    f.add(btn);
    f.add(l1);
    f.setSize(400,400);
    f.setLayout(null);
    f.setVisible(true);

 }   
}
