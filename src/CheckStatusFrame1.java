import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class CheckStatusFrame1 extends JFrame{
    private String column [] = {"member_name", "next_of_kin", "gender", "dob", "contact", "subcounty",
            "institution", "sport_id", "weight", "height", "registration_fee"};
    private JScrollPane resultScrollPane;
    private JPanel resultPanel;
    private JLabel searchLabel;
    private JTextField searchText;
    private JButton searchButton;
    private Object[][] data;
    DefaultTableModel model = new DefaultTableModel();
    
    public CheckStatusFrame1(){
        searchLabel = new JLabel("Enter Member ID");
        searchText = new JTextField(20);
        searchButton = new JButton("search");
        setBackground(Color.WHITE);
        setTitle("Damaged & Lost Equipment");
        setSize(1200,400);
        setLayout(new FlowLayout());
        resultPanel = new JPanel();
        data = new Object[100][11];
        data = populateTable();
        JTable membersTable = new JTable(data, column);
                
        resultScrollPane = new JScrollPane(membersTable);
        resultScrollPane.setPreferredSize(new Dimension(1100,250));        

        searchButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String memberID = searchText.getText().trim();
            if (memberID.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String memberRecord = findMemberRecord(memberID);
            JOptionPane.showMessageDialog(null, memberRecord);

        }
        });

        add(searchLabel);
        add(searchText);
        add(searchButton);
        add(resultScrollPane);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }    
    
    
    private Object[][] populateTable() {
        Connection connection = DBConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM members;");
            ResultSet rs = preparedStatement.executeQuery();
            int row = 0;
            while (rs.next()) {
                data [row][0] = rs.getString("member_name");
                data [row][1] = rs.getString("next_of_kin");
                data [row][2] = rs.getString("gender");
                data [row][3] = rs.getString("dob");
                data [row][4] = rs.getString("contact");
                data [row][5] = rs.getString("subcounty");
                data [row][6] = rs.getString("institution");
                data [row][7] = rs.getString("sport_id");
                data [row][8] = rs.getString("weight");
                data [row][9] = rs.getString("height");
                data [row][10] = rs.getString("registration_fee");
                row++;
            }
        } catch (SQLException er) {
            JOptionPane.showMessageDialog(null, er.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }
    
        private String findMemberRecord(String memberId) {
        Connection connection = DBConnectionManager.getConnection();
        if (connection == null) {
            return null;
        }

        try {
            String query = "SELECT * FROM Members WHERE member_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, memberId);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String memberName = rs.getString("member_name");
                String nextOfKin = rs.getString("next_of_kin"); 
                String gender = rs.getString("gender");
                String dob = rs.getString("dob");
                String contact = rs.getString("contact"); 
                String subcounty = rs.getString("subcounty");
                String institution = rs.getString("institution");
                String sportId = rs.getString("sport_id");
                String weight = rs.getString("weight");
                String height = rs.getString("height");
                String registrationFee = rs.getString("registration_fee"); 

                String memberRecord = "Member Name: " + memberName + "\n"
                        + "Next of Kin: " + nextOfKin + "\n"
                        + "Gender: " + gender + "\n"
                        + "DOB: " + dob + "\n"
                        + "Contact: " + contact + "\n"
                        + "Subcounty: " + subcounty + "\n"
                        + "Institution: " + institution + "\n"
                        + "Sport ID: " + sportId + "\n"
                        + "Weight: " + weight + "\n"
                        + "Height: " + height + "\n"
                        + "Registration Fee: " + registrationFee;
                return memberRecord;
            } else {
                JOptionPane.showMessageDialog(null, "Member not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error finding member record: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        
        }
    }

}
