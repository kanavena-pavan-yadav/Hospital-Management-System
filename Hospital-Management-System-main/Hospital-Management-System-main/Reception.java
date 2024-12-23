package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    Reception() {
        // Set up the main frame
        setTitle("Hospital Management System - Reception");
        setSize(1950, 1090);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(109, 164, 170));
        headerPanel.setBounds(5, 5, 1525, 220); // Increased height for the header panel
        add(headerPanel);

        // Title Label
        JLabel titleLabel = new JLabel("Reception", JLabel.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel, BorderLayout.NORTH);

        // Add an image to the header
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        JLabel doctorImage = new JLabel(new ImageIcon(image));
        doctorImage.setAlignmentX(JLabel.RIGHT_ALIGNMENT); // Align image to the right
        headerPanel.add(doctorImage, BorderLayout.EAST);

        // Set up the main panel for the buttons
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 3, 20, 20)); // 4 rows, 3 columns with gaps
        mainPanel.setBounds(200, 250, 1100, 300); // Adjusted position
        mainPanel.setBackground(new Color(109, 164, 170));
        add(mainPanel);

        // Button array with labels and actions
        String[] buttonLabels = {
                "Add New Patient", "Room", "Department",
                "All Employee Info", "Patient Info", "Patient Discharge",
                "Update Patient Details", "Hospital Ambulance", "Search Room"
        };

        ActionListener[] buttonActions = {
                e -> new NEW_PATIENT(),
                e -> new Room(),
                e -> new Department(),
                e -> new Employee_info(),
                e -> new ALL_Patient_Info(),
                e -> new patient_discharge(),
                e -> new update_patient_details(),
                e -> new Ambulance(),
                e -> new SearchRoom()
        };

        // Create buttons
        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.setBackground(new Color(246, 215, 118));
            button.setFont(new Font("Tahoma", Font.BOLD, 16));
            button.setPreferredSize(new Dimension(200, 50)); // Button size
            button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button.addActionListener(buttonActions[i]);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Add a border

            // Button hover effect
            button.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button.setBackground(new Color(255, 204, 0)); // Change to a lighter color
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button.setBackground(new Color(246, 215, 118)); // Revert to original color
                }
            });

            mainPanel.add(button);
        }

        // Add an ambulance image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image1 = i11.getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT);
        JLabel ambulanceImage = new JLabel(new ImageIcon(image1));
        ambulanceImage.setBounds(1000, 80, 300, 100); // Adjusted position
        headerPanel.add(ambulanceImage, BorderLayout.WEST);

        // Centered Logout button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(new Color(246, 215, 118));
        logoutButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        logoutButton.setPreferredSize(new Dimension(200, 50));
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutButton.addActionListener(e -> {
            setVisible(false);
            new Login();
        });
        logoutButton.setFocusPainted(false);
        logoutButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Adding Logout button to the main panel at the bottom
        logoutButton.setBounds(650, 570, 200, 50); // Adjusted position
        mainPanel.add(logoutButton);

        // Set visibility and properties
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
