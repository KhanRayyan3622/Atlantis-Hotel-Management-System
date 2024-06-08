package AdminPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AddRoom extends JFrame implements ActionListener {
    JButton add, cancel;
    JComboBox btcb, availablecb, statuscb;
    JTextField pricetf, addRoomtf;
    AddRoom() {
        setBounds(0,0,1280,680);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Add Room Form");


        //Room no properties
        JLabel addRoom = new JLabel("ROOM NO.");
        addRoom.setBounds(50,50,200,30);
        addRoom.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(addRoom);
        addRoomtf = createIntegerField();
        addRoomtf.setBounds(250,50,150,30);
        add(addRoomtf);

        //checking availablty no properties
        JLabel available = new JLabel("AVAILABLE");
        available.setBounds(50,150,200,30);
        available.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(available);
        String ca[] = { "Available", "Occupaied"};
        availablecb = new JComboBox(ca);
        availablecb.setBounds(250,150,150,30);
        availablecb.setBackground(Color.WHITE);
        availablecb.setFont(new Font("Yu Gothic UI Semibold",Font.PLAIN,15));
        add(availablecb);

        //checking status properties
        JLabel cs = new JLabel("STATUS");
        cs.setBounds(50,250,250,30);
        cs.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(cs);
        String Cs[] = { "Cleaned", "Dirty"};
        statuscb = new JComboBox(Cs);
        statuscb.setBounds(250,250,150,30);
        statuscb.setBackground(Color.WHITE);
        statuscb.setFont(new Font("Yu Gothic UI Semibold",Font.PLAIN,15));
        add(statuscb);

        //Price properties
        JLabel price = new JLabel("PRICE");
        price.setBounds(50,350,300,30);
        price.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(price);
        pricetf = createIntegerField();
        pricetf.setBounds(250,350,150,30);
        add(pricetf);

        //TYPE properties
        JLabel type = new JLabel("BED TYPE");
        type.setBounds(50,450,300,30);
        type.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(type);
        String bt[] = { "Single BED", "Double BED"};
        btcb = new JComboBox(bt);
        btcb.setBounds(250,450,150,30);
        btcb.setBackground(Color.WHITE);
        btcb.setFont(new Font("Yu Gothic UI Semibold",Font.PLAIN,15));
        add(btcb);


        add = new JButton("Add");
        add.setBounds(50,550,150,50);
        //add.setBackground(Color.WHITE);
        add.setForeground(Color.black);
        add.setFont(new Font("Cambria",Font.PLAIN,30));
        add.addActionListener(this);
        add(add);


        cancel = new JButton("Cancel");
        cancel.setBounds(250,550,150,50);
        //cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.black);   //Button Text Color
        cancel.setFont(new Font("Cambria",Font.PLAIN,30));  //Button Font Style
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    private JTextField createIntegerField() {
        JTextField intField = new JTextField();
        intField.setColumns(10); // Set the desired width of the text field

        // Add key listener to allow only numeric characters and backspace
        intField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char character = e.getKeyChar();
                if (!Character.isDigit(character) && character != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Ignore input if not a digit or backspace
                }
            }
        });

        return intField;
    }

    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == add) {
            try {
                FileWriter writer = new FileWriter("C:\\Users\\anasn\\OneDrive\\Desktop\\6th Semester\\Software Construction and Development\\Project\\Atlantis\\src\\AdminPanel\\Rooms.txt",true);
                writer.write(addRoomtf.getText() + "\n" + availablecb.getSelectedItem() + "\n" + statuscb.getSelectedItem() + "\n" + pricetf.getText() + "\n" + btcb.getSelectedItem() + "\n\n");
                writer.close();
                JOptionPane.showMessageDialog(this, "Room Added Successfully");
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
            Admin newGUIclass = new Admin();
            newGUIclass.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
