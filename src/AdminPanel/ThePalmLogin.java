package AdminPanel;

import javax.swing.*;
import java.awt.*;

public class ThePalmLogin extends JFrame {
    ThePalmLogin(){
        setSize(1280, 680);//Frame Size
        setLocation(0,5);//Frame Location
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);//Frame Layout
        setTitle("The Royal Login");

        ImageIcon royalLogin = new ImageIcon(ClassLoader.getSystemResource("icons/AdminLoginForm.png"));
        JLabel image1 = new JLabel(royalLogin);
        image1.setBounds(0,0,1280,680);
        add(image1);

        JTextField username = new JTextField();
        username.setBounds(845,335,370,37);
        add(username);
        JTextField password = new JTextField();
        password.setBounds(845,436,370,37);
        add(password);

        setVisible(true);
    }
    public static void main(String[] args) {
        new ThePalmLogin();
    }
}
