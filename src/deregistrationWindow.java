import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import java.sql.*;

public class deregistrationWindow{
    private JFrame frame = new JFrame();
    private JLabel memberIdLabel, searchLabel, resultLabel;
    private JTextField memberIdField;
    private JButton deregisterButton, searchButton;
    private JPanel mainPanel;
    private JTable resultTable;
    private JScrollPane resultScrollPane;
    private int searchID;
    private String queryString;
    Connection connection = DBConnectionManager.getConnection();

    
    public deregistrationWindow(){
        frame.setBackground(Color.WHITE);
        frame.setSize(300,200);
        
        searchLabel = new JLabel("Search member using a member ID");
        memberIdLabel = new JLabel("Enter Member ID: ");
        memberIdField = new JTextField(15);
        searchButton = new JButton("Search");
        searchButton.setBorderPainted(false);
        searchButton.setBackground(new Color(145, 17, 245));
        searchButton.setForeground(Color.WHITE);
        //the label below will display the name of member you want to deregister
        resultLabel = new JLabel("<<Member ID>> : <<Name>>");
        deregisterButton = new JButton("Deregister");
        deregisterButton.setBorderPainted(false);
        deregisterButton.setBackground(new Color(205, 17, 50));
        deregisterButton.setForeground(Color.WHITE);
        mainPanel = new JPanel(new FlowLayout());

        
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchID = Integer.parseInt(memberIdField.getText());
                fetchData();
            }
        });
        deregisterButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int confirmation = JOptionPane.showConfirmDialog(mainPanel, "Do you want to deregister this member?", "Confirm Deregistration", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                if (deleteMember(searchID)) {
                    JOptionPane.showMessageDialog(mainPanel, "Member deregistered successfully");
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Failed to deregister member");
                }
                frame.dispose();
            }
        }
        });
        mainPanel.add(searchLabel);
        mainPanel.add(memberIdLabel);
        mainPanel.add(memberIdField);
        mainPanel.add(searchButton);
        mainPanel.add(resultLabel);
        mainPanel.add(deregisterButton);

        frame.add(mainPanel);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
    }
    private void fetchData() {
        try (Statement statement = connection.createStatement()) {
            System.out.println("Database connection established.");
            String query = "SELECT " +
                    "member_id, " +
                    "members.member_name " +
                    "FROM maringodatabase.members " +
                    "WHERE member_id = " + searchID;

            try (ResultSet resultSet = statement.executeQuery(query)) {
                if (resultSet.next()) {
                    String id = resultSet.getString("member_id");
                    String name = resultSet.getString("member_name");
                    queryString = ("ID: " + id + " \t Name: " + name);
                    resultLabel.setText(queryString);
                } else {
                    resultLabel.setText("Member not found");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private boolean deleteMember(int memberId) {
        try {
            String deleteQuery = "DELETE FROM Members WHERE member_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, memberId);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } 
}
