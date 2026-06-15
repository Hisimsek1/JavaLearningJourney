import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class Main11 {
    public static void main(String[] args) {
        JFrame f  =new JFrame("List Örneği");

        DefaultListModel<String> l = new DefaultListModel<>();
        l.addElement("C++");
        l.addElement("Java");
        l.addElement("python");
        JList<String> list = new JList<>(l);
        list.setBounds(100,100,75,75);

        DefaultListModel<String> l2 = new DefaultListModel<>();
        l2.addElement("Halil");
        l2.addElement("Mehmet");
        l2.addElement("Mahmut");

        JList<String> list2 =new JList<>(l2);
        list2.setBounds(100,200,75,75);

        JButton btn = new JButton("Göster");
        btn.setBounds(200,150,85,45);

        
        f.add(btn);
        f.add(list2);
        f.add(list);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
