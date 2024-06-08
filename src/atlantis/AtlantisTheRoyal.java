package atlantis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class AtlantisTheRoyal extends JFrame {
    AtlantisTheRoyal(){
        setSize(1280, 680);//Frame Size
        setLocation(0,5);//Frame Location
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);//Frame Layout
        setTitle("Atlantis The Royal");


        // Create a panel to hold the images
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(null); // Use null layout to position images manually
        imagePanel.setPreferredSize(new Dimension(1280, 2000)); // Set preferred size to fit all images

        // Load and add first image
        ImageIcon capture1 = new ImageIcon(ClassLoader.getSystemResource("icons/AtlantisTheRoyal1.png"));
        JLabel image1 = new JLabel(capture1);
        image1.setBounds(0, -30, 1280, 680);
        imagePanel.add(image1);

        // Load and add second image
        ImageIcon capture2 = new ImageIcon(ClassLoader.getSystemResource("icons/AtlantisTheRoyal2.png"));
        JLabel image2 = new JLabel(capture2);
        image2.setBounds(0, 650, 1280, 680);
        imagePanel.add(image2);

        // Load and add third image
        ImageIcon capture3 = new ImageIcon(ClassLoader.getSystemResource("icons/AtlantisTheRoyal3.png"));
        JLabel image3 = new JLabel(capture3);
        image3.setBounds(0, 1330, 1280, 680);
        imagePanel.add(image3);

        // Wrap the image panel in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(imagePanel);
        scrollPane.setPreferredSize(new Dimension(1280, 680));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Optional: Increase scroll speed

        // Add the scroll pane to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
    public static void main(String[] args) {
        new AtlantisTheRoyal();
    }
}
