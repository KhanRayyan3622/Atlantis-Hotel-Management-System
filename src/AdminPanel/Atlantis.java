package AdminPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Atlantis extends JFrame implements ActionListener{
    JButton ThePalmEnter, TheRoyalEnter;
    Atlantis(){
        setSize(1280, 680);//Frame Size
        setLocation(0,5);//Frame Location
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);//Frame Layout
        setTitle("Atlantis Resort");

        ImageIcon atlantis = new ImageIcon(ClassLoader.getSystemResource("icons/AtlantisHotelMain.png"));
        JLabel image1 = new JLabel(atlantis);
        image1.setBounds(-10,-30,1280,680);
        add(image1);

        ThePalmEnter = new JButton("ENTER");
        ThePalmEnter.setBounds(235,588,190,50);
        ThePalmEnter.setForeground(Color.BLUE);
        ThePalmEnter.setBackground(Color.WHITE);
        ThePalmEnter.setFont(new Font("Cambria",Font.BOLD,25));
        ThePalmEnter.addActionListener(this::actionPerformed);
        image1.add(ThePalmEnter);

        TheRoyalEnter = new JButton("ENTER");
        TheRoyalEnter.setBounds(865,588,190,50);
        TheRoyalEnter.setForeground(Color.BLUE);
        TheRoyalEnter.setBackground(Color.WHITE);
        TheRoyalEnter.setFont(new Font("Cambria",Font.BOLD,25));
        TheRoyalEnter.addActionListener(this::actionPerformed);
        image1.add(TheRoyalEnter);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == ThePalmEnter){
            setVisible(false);
            new ThePalmLogin();
        } else if (e.getSource() == TheRoyalEnter) {
            setVisible(false);
            new TheRoyalLogin();
        }
    }
    public static void main(String[] args) {
        new Atlantis();
    }
}
