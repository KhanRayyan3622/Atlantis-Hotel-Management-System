package AdminPanel;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class BookedRooms extends JFrame {
    BookedRooms() {
        getContentPane().setBackground(Color.WHITE);
        setBounds(200,5,1000,700);
        setLayout(null);
        setTitle("Booked Rooms");

        File file = new File("C:\\Users\\anasn\\OneDrive\\Desktop\\6th Semester\\Software Construction and Development\\Project\\Atlantis\\src\\AdminPanel\\BookedRooms.txt");
        try {
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                read.nextLine();
                //add(read);
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setVisible(true);
    }


    public static void main(String[] args) {
        new BookedRooms();
    }
}
