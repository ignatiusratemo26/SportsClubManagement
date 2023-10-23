import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckStatusFrame extends JFrame {
    private JTextField memberIdField;
    private JTextArea resultArea;
    Connection connection = DBConnectionManager.getConnection();
    public CheckStatusFrame() {
        super("Member Status Checker");

        // Initialize GUI components
        memberIdField = new JTextField(10);
        resultArea = new JTextArea(15, 40);
        resultArea.setEditable(false);
        JButton searchButton = new JButton("Search");
        

        // Create a panel for the input and search button
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Member ID: "));
        inputPanel.add(memberIdField);
        inputPanel.add(searchButton);

        // Set up the layout
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        // Add an ActionListener to the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchMember();
            }
        });

        // Set JFrame properties
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void searchMember() {
        String memberId = memberIdField.getText();
        if (memberId.isEmpty()) {
            resultArea.setText("Please enter a Member ID.");
            return;
        }

        try (Connection connection = DBConnectionManager.getConnection();) {
            String query = "SELECT * FROM Members WHERE member_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, memberId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                resultArea.setText(""); // Clear the text area
                resultArea.append("Member ID: " + resultSet.getInt("member_id") + "\n");
                resultArea.append("Member Name: " + resultSet.getString("member_name") + "\n");
                resultArea.append("Date of Birth: " + resultSet.getDate("dob") + "\n");
                resultArea.append("Gender: " + resultSet.getString("gender") + "\n");
                // Add more fields as needed
            } else {
                resultArea.setText("Member not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error: " + e.getMessage());
        }
    }

    // You can display this frame by calling setVisible(true) from your main method or another part of your application.
}
