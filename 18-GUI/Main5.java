import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Main5 {
    public static void main(String[] args) {
        
        JFrame f = new JFrame();
        JTextArea area = new JTextArea();
        JLabel l1,l2;
        JButton btn;

        l1 = new JLabel();
        l1.setBounds(50,25,100,30);

        l2 = new JLabel();
        l2.setBounds(160,25,100,30);

        area.setBounds(20,75,250,200);
        btn = new JButton("Hesapla");
        btn.setBounds(100,300,120,30);


        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                String text = area.getText();
                String word[] = text.split("\\s");
                l1.setText("Kelime : "+ word.length);
                l2.setText("Karakter : "+text.length());
            }
        });

        f.add(l1);
        f.add(l2);
        f.add(btn);
        f.add(area);
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}
