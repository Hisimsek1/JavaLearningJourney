import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main8 {
    public static void main(String[] args) {
        JFrame f = new JFrame("RadioButton Örneği");
        JRadioButton r = new JRadioButton("Kadın");
        JRadioButton r1 = new JRadioButton("Erkek");
        r.setBounds(100,50,100,30);
        r1.setBounds(100,100,100,30);
        JRadioButton r2 = new JRadioButton("Katılmıyorum.");
        r2.setBounds(100,150,200,30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r);
        bg.add(r1);
        bg.add(r2);
        JButton btn = new JButton("Gonder");
        btn.setBounds(100,200,100,30);
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                if (r.isSelected()) {
                    System.out.println(r.getText() + " secildi.");
                } else if (r1.isSelected()) { // else if kullanmak daha profesyoneldir
                    System.out.println(r1.getText() + " secildi.");
                } else if (r2.isSelected()) {
                    System.out.println(r2.getText() + " secildi.");
                }
            }
        }); 
        
        f.add(r);
        f.add(r1);
        f.add(r2);
        f.add(btn);
        f.setSize(400,400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
