import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class reportWindow extends JFrame{
    private JPanel reportPanel;
    private JTextField eqptLossField, memberIdField;
    private JLabel eqptLossLabel, memberIdLabel,  damageFeeField;
    private JButton reportButton, calculateButton;
    private Connection connection = DBConnectionManager.getConnection();
    
    public reportWindow(){
        reportPanel = new JPanel();
        setSize(300,300);
        setTitle("Report Damaged/Lost Equipment");
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        
        //equipment panel components initialization
        reportPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        reportPanel.setBackground(Color.WHITE);
        eqptLossField = new JTextField(10); 
        memberIdField = new JTextField(10);
        eqptLossLabel = new JLabel("Equipment ID    ");
        memberIdLabel = new JLabel("Member ID        "); 
        calculateButton = new JButton("calculate");
        calculateButton.setBorderPainted(false);
        calculateButton.setBackground(new Color(145, 17, 245));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            String selectEquipmentQuery = "SELECT market_value FROM maringodatabase.equipments WHERE equipment_id = ?";        
            try {
                int equipmentId = Integer.parseInt(eqptLossField.getText());            
                // Getting the market value of the damaged equipment
                PreparedStatement selectEquipmentStatement = connection.prepareStatement(selectEquipmentQuery);
                selectEquipmentStatement.setInt(1, equipmentId);
                ResultSet equipmentResultSet = selectEquipmentStatement.executeQuery();

                if (equipmentResultSet.next()) {
                    int equipmentValue = equipmentResultSet.getInt("market_value");
                    int damageFee = (int) (equipmentValue * 1.1);
                    JOptionPane.showMessageDialog(null, "Ksh. "+damageFee);
                } else {
                    JOptionPane.showMessageDialog(null,"Equipment not found");
                }

                equipmentResultSet.close();
                selectEquipmentStatement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                damageFeeField.setText("Error occurred");
            }
        }        
        }); 
        damageFeeField = new JLabel("");
        reportButton = new JButton("Report");
        //setting the color of the report button to light red using rgb code scheme
        reportButton.setBackground(new Color(255, 127, 127));
        reportButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            String selectEquipmentQuery = "SELECT market_value FROM maringodatabase.equipments WHERE equipment_id = ?";
            String updateDamagedEquipmentQuery = "INSERT INTO maringodatabase.lostdamaged (equipment_id, member_id) VALUES (?, ?)";
        
            try {
                int equipmentId = Integer.parseInt(eqptLossField.getText());
                int memberId = Integer.parseInt(memberIdField.getText());
            
                // Getting the market value of the damaged equipment
                PreparedStatement selectEquipmentStatement = connection.prepareStatement(selectEquipmentQuery);
                selectEquipmentStatement.setInt(1, equipmentId);
                ResultSet equipmentResultSet = selectEquipmentStatement.executeQuery();

                if (equipmentResultSet.next()) {
                    int equipmentValue = equipmentResultSet.getInt("market_value");
                    int damageFee = (int) (equipmentValue * 1.1);

                    // Inserting the damaged equipment into the damaged_equipment table
                    PreparedStatement updateDamagedEquipmentStatement = connection.prepareStatement(updateDamagedEquipmentQuery);
                    updateDamagedEquipmentStatement.setInt(1, equipmentId);
                    updateDamagedEquipmentStatement.setInt(2, memberId);
                
                    int rowsAffected = updateDamagedEquipmentStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null ,"Record updated in the database successfully. ");
                    } else {
                        JOptionPane.showMessageDialog(null, "Could not update the database.");
                    }

                    updateDamagedEquipmentStatement.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Equipment not found.");
                }

                equipmentResultSet.close();
                selectEquipmentStatement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"An error occurred.");
            }
        }
        
        });
        reportPanel.add(eqptLossLabel); reportPanel.add(eqptLossField); reportPanel.add(memberIdLabel);
        reportPanel.add(memberIdField); reportPanel.add(calculateButton); 
        reportPanel.add(damageFeeField); reportPanel.add(reportButton);
        add(reportPanel);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
}