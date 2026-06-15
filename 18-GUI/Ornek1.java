import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ornek1 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JPanel p = new JPanel();
        JTextArea area = new JTextArea();
        JButton btn = new JButton("Gönder");
        p.setBounds(400,500,100,30);
        JTextField t1,t2;
        JLabel l1,l2,l3;

        l1 = new JLabel("Kullanıcı ismi : ");
        l1.setBounds(100,100,100,30);

        t1 = new JTextField();
        t1.setBounds(200,100,100,30);

        l2 = new JLabel("Şifre : ");
        l2.setBounds(100,200,100,30);


        JPasswordField pass = new JPasswordField();
        pass.setBounds(200,200,100,30);

        l3 = new JLabel("Kendinizden bahsedin : ");
        l3.setBounds(100,300,200,30);


        area.setBounds(250,300,200,200);

        btn.setBounds(300,600,100,30);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                System.out.println("İsim : "+t1.getText());
                System.out.println("Hakkında : "+area.getText());
            }
        });


    
        f.add(p);
        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(pass);
        f.add(l3);
        f.add(area);
        f.add(btn);
        f.setSize(1000,1000);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
