import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main9 {
    public static void main(String[] args) {
        JFrame f =new JFrame("ComboBox Örneği");
        String arr[] = {"C","C#","C++","JAVA","PYTHON"};
        JComboBox cb = new JComboBox<>(arr);
        cb.setBounds(50,100,90,20);
        JButton btn = new JButton("Seç");
        btn.setBounds(50,150,80,20);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String text = "Seçilen programlama dili : "+ cb.getSelectedItem();
                System.out.println(text);
            }
        });


        f.add(cb);
        f.add(btn);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
