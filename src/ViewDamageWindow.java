import javax.swing.*;
import java.awt.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class ViewDamageWindow extends JFrame {
    private String[] column = {"Member ID", "Member Name", "Equipment ID", "Equipment Name"};
    private Object[][] data;
    private JScrollPane resultScrollPane;
    private JTable lostAndDamagedTable;
    Connection connection = DBConnectionManager.getConnection();
    
    public ViewDamageWindow() {
        setSize(600, 300);
        setTitle("Damaged & Lost Equipment");
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        // Fetch data from the database and populate the JTable
        data = new Object[100][100];
        data = fetchDataFromDatabase();
        lostAndDamagedTable = new JTable(data, column);
        lostAndDamagedTable.setBackground(Color.WHITE);
        lostAndDamagedTable.setForeground(Color.blue);
        resultScrollPane = new JScrollPane(lostAndDamagedTable);
        resultScrollPane.setBounds(200, 100, 100, 150);
        add(resultScrollPane);

        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }

    private Object[][] fetchDataFromDatabase() {
        try (
            
            Statement statement = connection.createStatement()) {
            System.out.println("Database connection established.");
            String query = "SELECT " +
                    "lostdamaged.member_id, " +
                    "members.member_name, " +
                    "equipments.equipment_id, " +
                    "equipments.equipment_name " +
                    "FROM lostdamaged " +
                    "INNER JOIN equipments ON lostdamaged.equipment_id = equipments.equipment_id " +
                    "INNER JOIN members ON lostdamaged.member_id = members.member_id;";

            try (ResultSet resultSet = statement.executeQuery(query)) {
                // Determine the number of rows in the ResultSet
                //resultSet.last();
                int rowCount = resultSet.getRow();
                //resultSet.beforeFirst();

                int row = 0;
                while (resultSet.next()) {
                    data[row][0] = resultSet.getObject("member_id");
                    data[row][1] = resultSet.getObject("member_name");
                    data[row][2] = resultSet.getObject("equipment_id");
                    data[row][3] = resultSet.getObject("equipment_name");
                    row++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }    
}
