package AdminPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;


public class BookingRooms extends JFrame implements ActionListener {
    JButton book, cancel;
    JRadioButton mgenderfield,fgenderfield;
    JComboBox countrycb,idfield,roomnumfield;
    JTextField idnumfield,namefield,checkinfield,depositfield;
    BookingRooms() {
        getContentPane().setBackground(Color.WHITE);
        setBounds(200,5,1000,680);
        setLayout(null);
        setTitle("Booking Rooms");
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/22.jpg"));
        JLabel icon = new JLabel(image);
        icon.setBounds(470,180,464,371);
        add(icon);


        JLabel id = new JLabel("ID");
        id.setBounds(50,50,100,30);
        id.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(id);
        String ids[] = {"Passport", "CNIC", "Student-ID", "Voter-ID"};
        idfield = new JComboBox(ids);
        idfield.setBounds(220,50,200,30);
        idfield.setBackground(Color.WHITE);
        idfield.setFont(new Font("Yu Gothic UI Semibold",Font.PLAIN,20));
        add(idfield);

        JLabel idnumber = new JLabel("ID NUMBER");
        idnumber.setBounds(50,120,200,30);
        idnumber.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(idnumber);
        idnumfield = createIntegerField();
        idnumfield.setBounds(220,120,200,30);
        add(idnumfield);

        JLabel name = new JLabel("NAME");
        name.setBounds(50,190,200,30);
        name.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(name);
        namefield = new JTextField();
        namefield.setBounds(220,190,200,30);
        add(namefield);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(50,260,200,30);
        gender.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(gender);
        mgenderfield = new JRadioButton("Male"); //Male Button
        mgenderfield.setBounds(220,260,100,30);
        mgenderfield.setFont(new Font("Yu Gothic UI Semibold",Font.PLAIN,20));
        mgenderfield.setBackground(Color.WHITE);
        add(mgenderfield);
        fgenderfield = new JRadioButton("Female"); //Female Button
        fgenderfield.setBounds(320,260,150,30);
        fgenderfield.setFont(new Font("Yu Gothic UI Semibold",Font.PLAIN,20));
        fgenderfield.setBackground(Color.WHITE);
        add(fgenderfield);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(mgenderfield);
        genderGroup.add(fgenderfield);


        JLabel country = new JLabel("COUNTRY");
        country.setBounds(50,330,200,30);
        country.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(country);
        String Country[] = {"China","Dubai","England", "Pakistan" , "Saudia Arabia"};
        countrycb = new JComboBox(Country);
        countrycb.setBounds(220,330,200,30);
        countrycb.setBackground(Color.WHITE);
        countrycb.setFont(new Font("Yu Gothic UI Semibold",Font.PLAIN,20));
        add(countrycb);

        JLabel roomnum = new JLabel("ROOM NUM");
        roomnum.setBounds(50,400,200,30);
        roomnum.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(roomnum);
        String roomnums[] = {"101", "102" , "103", "104", "105", "106"};
        roomnumfield = new JComboBox(roomnums);
        roomnumfield.setBounds(220,400,200,30);
        roomnumfield.setBackground(Color.WHITE);
        roomnumfield.setFont(new Font("Yu Gothic UI Semibold",Font.PLAIN,20));
        add(roomnumfield);

        JLabel checkin = new JLabel("CHECK IN");
        checkin.setBounds(50,470,200,30);
        checkin.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(checkin);
        checkinfield = createIntegerField();
        checkinfield.setBounds(220,470,200,30);
        add(checkinfield);

        JLabel deposit = new JLabel("DEPOSIT");
        deposit.setBounds(50,540,200,30);
        deposit.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(deposit);
        depositfield = createIntegerField();
        depositfield.setBounds(220,540,200,30);
        add(depositfield);

        //Button properties
        book = new JButton("Book"); //Add button
        book.setBounds(70,600,120,40);    //Button Position
        //book.setBackground(Color.WHITE);    //Button Background Color
        book.setForeground(Color.black);   //Button Text Color
        book.setFont(new Font("Cambria",Font.BOLD,30));  //Button Font Style
        book.addActionListener(this);
        add(book);

        //Button properties
        cancel = new JButton("Cancel"); //Add button
        cancel.setBounds(250,600,130,40);    //Button Position
        //cancel.setBackground(Color.WHITE);    //Button Background Color
        cancel.setForeground(Color.black);   //Button Text Color
        cancel.setFont(new Font("Cambria",Font.BOLD,30));  //Button Font Style
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == book) {
            try {
                FileWriter write = new FileWriter("C:\\Users\\anasn\\OneDrive\\Desktop\\6th Semester\\Software Construction and Development\\Project\\Atlantis\\src\\AdminPanel\\BookedRoom.txt",true);
                write.write(idfield.getSelectedItem() + "\n" + idnumfield.getText() + "\n" + namefield.getText() + "\n" + mgenderfield.getSelectedIcon() + "\n" + countrycb.getSelectedItem() + "\n" + roomnumfield.getSelectedItem() + "\n" + checkinfield.getText() + "\n" + depositfield.getText() + "\n\n");
                write.close();
                JOptionPane.showMessageDialog(this, "Room Booked Successfully");
            } catch (IOException ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == mgenderfield) {
            System.out.println("Male selected");
        } else if (e.getSource() == fgenderfield) {
            System.out.println("Female selected");
        } else if (e.getSource() == cancel ){
            setVisible(false);
            new Reception();
        }
    }



    public static void main(String[] args) {
        new BookingRooms();
    }
}
