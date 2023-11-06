import com.sun.jdi.connect.spi.Connection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

public class searchDamage extends JFrame{
    private String column [] = {"Loss ID", "Equipment ID", "Member ID", "Damage Fee"};
    private String data [] [] = {{"","","","","","",""}};
    private JTable lostAndDamagedTable;
    private JScrollPane resultScrollPane;
    private JPanel resultPanel;
    private JLabel searchLabel;
    private JTextField searchText;
    private JButton searchButton;
    ResultSet rs;
    PreparedStatement post;
    Connection con;
    DefaultTableModel model = new DefaultTableModel();
    
    public searchDamage(){
        searchLabel = new JLabel("search by Member ID");
        searchText = new JTextField(20);
        searchButton = new JButton("search");
        setBackground(Color.WHITE);
        setTitle("Damaged & Lost Equipment");
        setSize(680,300);
        setLayout(new MigLayout());
        resultPanel = new JPanel();
        JTable lostAndDamagedTable = new JTable(data, column);
        resultScrollPane = new JScrollPane(lostAndDamagedTable);
        
        searchButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            java.sql.Connection connection = DBConnectionManager.getConnection();
            try {
                // Use the connection to execute SQL queries
                PreparedStatement preparedStatement; 
                preparedStatement = connection.prepareStatement("SELECT ,lostdamaged.member_id, members.member_name,equipments.equipment_id," + 
                    "equipments.equipment_name FROM lostdamaged" +
                    "INNER JOIN equipments ON lostdamaged.equipment_id = equipments.equipment_id" +
                    "INNER JOIN members ON lostdamaged.member_id = members.member_id;");
                ResultSet rs = preparedStatement.executeQuery();
                // Process the result set
                int i =0;
                while (rs.next()){
                    String member_id = rs.getString("member_id");
                    String member_name = rs.getString("member_name");
                    String equipment_id = rs.getString("equipment_id");
                    String equipment_name = rs.getString("equipment_name");
                    model.addRow(new Object[] {member_id, member_name, equipment_id, equipment_name});
                    i++;
                }
                if(i<1){
                    JOptionPane.showMessageDialog(null, 
                        "No record Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                rs.close();
                preparedStatement.close();
            } catch (SQLException er) {
                JOptionPane.showMessageDialog(null, er.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);}
        }
        });
        add(searchLabel);
        add(searchText);
        add(searchButton, "wrap");
        add(resultScrollPane, "span");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
    }
}
