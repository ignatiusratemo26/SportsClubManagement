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

        
        searchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                searchID = Integer.parseInt(memberIdField.getText());
                queryString = fetchData();
                resultLabel.setText(queryString);
            }            
        });
        
        deregisterButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainPanel, "<<name>> deregistered successfully");
                frame.dispose();
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
    private String fetchData(){
        try(
            Statement statement = connection.createStatement()) {
            System.out.println("Database connection established.");
            String query = "SELECT " +
                    "member_id, " +
                    "members.member_name " +
                    "FROM maringodatabase.members "+
                    "WHERE member_id = "+ searchID;

            try (ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    String id = resultSet.getString("member_id");
                    String name = resultSet.getString("member_name");
                    queryString = ("ID: "+ id +" \t Name: " + name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queryString;
    }    
}
