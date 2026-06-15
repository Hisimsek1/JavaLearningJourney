import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import  java.util.*;
public class Main7 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Seçim Paneli");
        JLabel lb = new JLabel("as");
        lb.setBounds(150,50,300,50);

        
        JCheckBox ch = new JCheckBox("C++");
        JCheckBox ch2 = new JCheckBox("Java");
        ch.setBounds(150, 100, 100, 50);
        ch2.setBounds(150, 150, 100, 50);
        
        ch.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e)
            {
                lb.setText("C++ Secim kutusu " + (e.getStateChange() == 1 ? "secildi" : "secilmedi"));
            }
        });
        

        ch2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e)
            {
                lb.setText("Java Secim kutusu " + (e.getStateChange() == 1 ? "secildi" : "secilmedi"));
            }
        });
        
        
        f.add(ch2);
        f.add(ch);
        f.add(lb);
        f.setSize(400, 400);
        f.setLayout(null); // Elemanların görünmesi için setVisible'dan önce olmalı
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}