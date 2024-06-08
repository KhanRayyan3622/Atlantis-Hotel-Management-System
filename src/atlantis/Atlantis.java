package atlantis;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Atlantis extends JFrame{
    JButton PalmButton, RoyalButton;
    //Object Contructor
    Atlantis(){
        setSize(1280, 680);//Frame Size
        setLocation(0,5);//Frame Location
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);//Frame Layout
        setTitle("Atlantis Resort");

        ImageIcon capture = new ImageIcon(ClassLoader.getSystemResource("icons/AtlantisMain.jpg"));
        JLabel image = new JLabel(capture);
        image.setBounds(0, -30, 1280, 680 );
        add(image);

        //Button
        PalmButton = new JButton("EXPLORE");
        PalmButton.setBounds(78,610,260,45);
        PalmButton.setForeground(Color.WHITE);
        PalmButton.setBackground(Color.BLUE);
        PalmButton.setFont(new Font("Yu Gothic UI Semibold",Font.BOLD,15));
        PalmButton.addActionListener(this::actionPerformed);
        image.add(PalmButton);

        //Button
        RoyalButton = new JButton("EXPLORE");
        RoyalButton.setBounds(655,610,260,46);
        RoyalButton.setForeground(Color.WHITE);
        RoyalButton.setBackground(Color.BLUE);
        RoyalButton.setFont(new Font("Yu Gothic UI Semibold",Font.BOLD,15));
        RoyalButton.addActionListener(this::actionPerformed);
        image.add(RoyalButton);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == PalmButton){
            setVisible(false);
            new AtlantisThePalm();
        } else if (e.getSource() == RoyalButton) {
            setVisible(false);
            new AtlantisTheRoyal();
        }
    }

    public static void main(String[] args) {
        new Atlantis();//Object
    }
}