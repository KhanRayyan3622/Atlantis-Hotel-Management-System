package AdminPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class ReceptionLogin extends JFrame {
    ReceptionLogin() {
        setSize(1280, 481);//Frame Size
        setLocation(0,70);//Frame Location
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);//Frame Layout
        setTitle("Reception Login");


        setVisible(true);
    }
    public static void main(String[] args) {
        new ReceptionLogin();
    }
}
