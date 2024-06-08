package AdminPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class TheRoyal extends JFrame {
    JButton reception, admin;
    TheRoyal(){
        setSize(1280, 481);//Frame Size
        setLocation(0,70);//Frame Location
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);//Frame Layout
        setTitle("Atlantis");

        ImageIcon atlantis = new ImageIcon(ClassLoader.getSystemResource("icons/Atlantis.jpg"));
        JLabel image1 = new JLabel(atlantis);
        image1.setBounds(0,0,1280,481);
        add(image1);

        reception = new JButton("RECEPTION");
        reception.setBounds(1120,330,120,30);
        reception.setForeground(Color.WHITE);
        reception.setBackground(Color.BLUE);
        reception.setFont(new Font("Yu Gothic UI Semibold",Font.BOLD,15));
        //reception.addActionListener(this::actionPerformed);
        image1.add(reception);

        admin = new JButton("ADMIN");
        admin.setBounds(1120,380,120,30);
        admin.setForeground(Color.WHITE);
        admin.setBackground(Color.BLUE);
        admin.setFont(new Font("Yu Gothic UI Semibold",Font.BOLD,15));
        //admin.addActionListener(this::actionPerformed);
        image1.add(admin);

        setVisible(true);
    }
    public static void main(String[] args) {
        new TheRoyal();
    }
}
