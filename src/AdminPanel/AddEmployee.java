package AdminPanel;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField nameField, ageField, salaryField, phoneField, emailField;
    JButton add, cancel;
    JRadioButton rbmale, rbfemale;
    JComboBox jobcb,date,month,year;
    AddEmployee() {
        setBounds(0,0,1280,680);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Add Employee Form");

        //Image View
        ImageIcon image3 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.png"));
        JLabel image = new JLabel(image3);
        image.setBounds(300, -70, 1100, 680);
        add(image);

        //Name properties
        JLabel name = new JLabel("NAME");
        name.setBounds(50,50,100,30);
        name.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(name);
        nameField = new JTextField();
        nameField.setBounds(230,50,200,30);
        add(nameField);

        //Age properties
        JLabel age = new JLabel("AGE");
        age.setBounds(50,100,100,30);
        age.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(age);
        ageField = createIntegerField();
        ageField.setBounds(230,100,200,30);
        add(ageField);
        //String Date[] = { "1", "2", "3", "4", "5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31",};
        //date = new JComboBox(Date);
        //date.setBounds(230, 150, 50, 30);
        //date.setBackground(Color.WHITE);
        //date.setFont(new Font("Yu Gothic UI Semibold",Font.PLAIN,20));
        //add(date);
        //String Month[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        //month = new JComboBox(Month);
        //month.setBounds(300, 150, 130, 30);
        //month.setBackground(Color.WHITE);
        //month.setFont(new Font("Yu Gothic UI Semibold",Font.PLAIN,20));
        //add(month);


        //Gender properties
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(50,150,200,30);
        gender.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(gender);
        rbmale = new JRadioButton("Male"); //Male Button
        rbmale.setBounds(230,150,100,30);
        rbmale.setFont(new Font("Yu Gothic UI Semibold",Font.PLAIN,20));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        rbfemale = new JRadioButton("Female"); //Female Button
        rbfemale.setBounds(330,150,100,30);
        rbfemale.setFont(new Font("Yu Gothic UI Semibold",Font.PLAIN,20));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbmale);
        genderGroup.add(rbfemale);

        //Job properties
        JLabel job = new JLabel("JOBS");
        job.setBounds(50,200,100,30);
        job.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(job);
        String jobs[] = { "Receptinate", "Kitchen Staff", "Accountient", "Room Servies", "Cheif"};
        jobcb = new JComboBox(jobs);
        jobcb.setBounds(230, 200, 200, 30);
        jobcb.setBackground(Color.WHITE);
        jobcb.setFont(new Font("Yu Gothic UI Semibold",Font.PLAIN,20));
        add(jobcb);

        //salary properties
        JLabel salary = new JLabel("SALARY");
        salary.setBounds(50,250,200,30);
        salary.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(salary);
        salaryField = createIntegerField();
        salaryField.setBounds(230,250,200,30);
        add(salaryField);

        //PHONE properties
        JLabel phone = new JLabel("PHONE");
        phone.setBounds(50,300,200,30);
        phone.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(phone);
        phoneField = createIntegerField();
        phoneField.setBounds(230,300,200,30);
        add(phoneField);

        //email properties
        JLabel email = new JLabel("EMAIL");
        email.setBounds(50,350,100,30);
        email.setFont(new Font("Britannic Bold",Font.PLAIN,30));
        add(email);
        emailField = new JTextField();
        emailField.setBounds(230,350,200,30);
        add(emailField);

        //Button Properties
        add = new JButton("ADD");
        add.setBounds(50,450,100,30);    //Button Position
        add.setBackground(Color.LIGHT_GRAY);    //Button Background Color
        add.setForeground(Color.BLACK);   //Button Text Color
        add.setFont(new Font("Cambria",Font.BOLD,20));  //Button Font Style
        add.addActionListener(this);
        add(add);

        cancel = new JButton("CANCEL");
        cancel.setBounds(250,450,150,30);    //Button Position
        cancel.setBackground(Color.LIGHT_GRAY);    //Button Background Color
        cancel.setForeground(Color.BLACK);   //Button Text Color
        cancel.setFont(new Font("Cambria",Font.BOLD,20));  //Button Font Style
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
        if (e.getSource() == add) {
            try {
                FileWriter write = new FileWriter("C:\\Users\\anasn\\OneDrive\\Desktop\\6th Semester\\Software Construction and Development\\Project\\Atlantis\\src\\AdminPanel\\Employee.txt",true);
                write.write(nameField.getText() + "\n" + ageField.getText() + "\n" + rbmale.getSelectedIcon() + "\n" + jobcb.getSelectedItem() + "\n" + salaryField.getText() + "\n" + phoneField.getText() + "\n" + emailField.getText() + "\n\n");
                write.close();
                JOptionPane.showMessageDialog(this, "Employee Added Successfully");
            } catch (IOException ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == rbmale) {
            System.out.println("Male selected");
        } else if (e.getSource() == rbfemale) {
            System.out.println("Female selected");
        } else if (e.getSource() == cancel) {
            setVisible(false);
            new Admin();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}