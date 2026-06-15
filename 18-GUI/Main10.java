import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.util.*;
import java.awt.event.ActionEvent;
public class Main10 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Table Örneği");
        String[][] veri = {{"1","Mat","85"},{"2","FEN","50"},{"3","TUR","100"}};
        String[] baslik = { "ID", "DERS" , "NOT" };
        JTable jt = new JTable(veri,baslik);
        JScrollPane sp = new JScrollPane(jt);


        
        jt.setBounds(30,40,200,300);
        f.add(sp);
        f.setSize(400,400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
