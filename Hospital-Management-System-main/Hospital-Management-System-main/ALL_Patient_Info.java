package hospital.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ALL_Patient_Info extends JFrame {

    ALL_Patient_Info() {
        // Create main panel with border and title
        JPanel panel = new JPanel();
        panel.setBounds(20, 20, 860, 550);
        panel.setBackground(new Color(255, 255, 255)); // White background for a clean look
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2), "Patient Information",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Serif", Font.BOLD, 20), Color.BLACK));

        add(panel);

        // Create a scrollable table
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 70, 820, 370);
        panel.add(scrollPane);

        // Load data from the database into the table
        try {
            conn c = new conn();
            String q = "select * from Patient_Info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set up table appearance
        table.setBackground(Color.WHITE);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setRowHeight(25); // Make rows slightly taller for better visibility
        table.setGridColor(Color.GRAY); // Grid color between cells

        // Create header labels
        String[] labels = {"ID", "Number", "Name", "Gender", "Disease", "Room", "Time", "Deposit"};
        int[] labelPositions = {31, 150, 270, 360, 480, 600, 700, 800};

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setBounds(labelPositions[i], 40, 100, 20);
            label.setFont(new Font("Tahoma", Font.BOLD, 14));
            label.setForeground(Color.BLACK);
            panel.add(label);
        }

        // "BACK" Button design
        JButton backButton = new JButton("BACK");
        backButton.setBounds(370, 460, 120, 40); // Centered button at the bottom
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Tahoma", Font.BOLD, 16)); // Larger and bold font for buttons
        backButton.setFocusPainted(false); // Remove focus border
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Hand cursor for better UX
        backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Button border
        backButton.setOpaque(true); // Make button solid color
        backButton.setBorderPainted(true);

        // Hover effect for button
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButton.setBackground(new Color(64, 64, 64)); // Darker hover effect
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButton.setBackground(Color.BLACK); // Back to original color
            }
        });

        panel.add(backButton);

        // Action listener for the "BACK" button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Close the window
            }
        });

        // Set frame properties
        setUndecorated(true); // Remove window borders
        setSize(900, 600);
        setLocation(300, 200);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ALL_Patient_Info();
    }
}
