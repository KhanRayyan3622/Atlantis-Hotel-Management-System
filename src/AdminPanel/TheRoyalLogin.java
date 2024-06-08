package AdminPanel;

import javax.swing.*;
import java.awt.*;

public class TheRoyalLogin extends JFrame {
    TheRoyalLogin(){
        setSize(1280, 680);//Frame Size
        setLocation(0,5);//Frame Location
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);//Frame Layout
        setTitle("The Royal Login");

        ImageIcon royalLogin = new ImageIcon(ClassLoader.getSystemResource("icons/TheRoyalLoginForm.png"));
        JLabel image1 = new JLabel(royalLogin);
        image1.setBounds(0,0,1280,680);
        add(image1);

        setVisible(true);
    }
    public static void main(String[] args) {
        new TheRoyalLogin();
    }
}
