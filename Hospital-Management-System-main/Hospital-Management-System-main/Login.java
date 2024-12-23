package hospital.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2;

    Login() {
        // Setting up full screen
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen

        // Main Panel to hold the form and its border
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(109, 164, 170)); // Background for main panel

        // Add the outer title "Hospital Management System" at the top
        JLabel outerTitleLabel = new JLabel("Hospital Management System");
        outerTitleLabel.setFont(new Font("Serif", Font.BOLD, 40)); // Large and bold font for the main title
        outerTitleLabel.setForeground(new Color(0, 102, 204)); // Blue color for the title
        outerTitleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align the title
        outerTitleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Padding around the title

        // Create a panel for the login form and set a border
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(255, 255, 255)); // White background for form panel
        Border paddingBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20); // Padding inside the panel
        Border blackline = BorderFactory.createLineBorder(Color.BLACK, 2); // Black border
        formPanel.setBorder(BorderFactory.createCompoundBorder(blackline, paddingBorder)); // Combine padding + border

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding between elements

        // Add the inner title "Login Page" inside the form
        JLabel innerTitleLabel = new JLabel("Login Page");
        innerTitleLabel.setFont(new Font("Serif", Font.BOLD, 30)); // Bold font for the inner title
        innerTitleLabel.setForeground(new Color(0, 102, 204)); // Blue color for the inner title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across both columns
        gbc.anchor = GridBagConstraints.CENTER; // Center the inner title
        formPanel.add(innerTitleLabel, gbc);

        // Add spacing after inner title
        gbc.insets = new Insets(20, 10, 10, 10);

        JLabel namelabel = new JLabel("Username");
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        namelabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END; // Align labels to the right
        formPanel.add(namelabel, gbc);

        textField = new JTextField(20); // Increased the width of the text field
        textField.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Slightly larger font
        textField.setBackground(new Color(255, 179, 0));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START; // Align text fields to the left
        formPanel.add(textField, gbc);

        JLabel password = new JLabel("Password");
        password.setFont(new Font("Tahoma", Font.BOLD, 16));
        password.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(password, gbc);

        jPasswordField = new JPasswordField(20); // Increased the width of the password field
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Slightly larger font
        jPasswordField.setBackground(new Color(255, 179, 0));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(jPasswordField, gbc);

        // Buttons Panel to add login and cancel buttons side by side
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 10, 0)); // 1 row, 2 columns, 10px gap
        buttonsPanel.setBackground(Color.WHITE); // Same background as form

        b1 = new JButton("Login");
        b1.setFont(new Font("serif", Font.BOLD, 18)); // Larger and bold font for buttons
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        buttonsPanel.add(b1);

        b2 = new JButton("Cancel");
        b2.setFont(new Font("serif", Font.BOLD, 18)); // Larger and bold font for buttons
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        buttonsPanel.add(b2);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(buttonsPanel, gbc);

        // Use BorderLayout to place the main title on top and the form below
        setLayout(new BorderLayout());
        add(outerTitleLabel, BorderLayout.NORTH); // Add the "Hospital Management System" title at the top
        add(mainPanel, BorderLayout.CENTER); // Center the form in the window

        mainPanel.add(formPanel); // Adding formPanel to mainPanel

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                conn c = new conn();
                String user = textField.getText();
                String Pass = jPasswordField.getText();
                String q = "select * from login where ID = '" + user + "' and PW = '" + Pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()) {
                    new Reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            System.exit(10);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
