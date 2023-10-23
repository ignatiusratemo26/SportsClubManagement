import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.miginfocom.swing.MigLayout;

public class updateStockWindow extends JFrame {
    private JLabel item, currentLevel, addItem;
    private JLabel shorts, bloomer, tracksuit, shoes, wrapper, socks, hockey, tshirt;
    private JLabel shortsvalue, bloomervalue, tracksuitvalue, shoesvalue, wrappervalue, socksvalue, hockeyvalue, tshirtvalue;
    private JTextField shortsfield, bloomerfield, tracksuitfield, shoesfield, wrapperfield, socksfield, hockeyfield, tshirtfield;
    private JButton addShort, addBloomer, addTracksuit, addShoe, addWrapper, addSocks, addHockey, addTshirt;
    Connection connection = DBConnectionManager.getConnection();
    
    public updateStockWindow() {
        setLayout(new MigLayout("wrap", "[]30[]30[]30[]", ""));
        setSize(500,400);
        getContentPane().setBackground(Color.WHITE);
        item = new JLabel("Item");
        item.setForeground(new Color(145, 17, 245));
        item.setFont(new Font("helvetica", Font.BOLD, 15));
        currentLevel = new JLabel("Current level");
        addItem = new JLabel("Add");
        addItem.setForeground(new Color(145, 17, 245));
        currentLevel.setForeground(new Color(145, 17, 245));
        currentLevel.setFont(new Font("helvetica", Font.BOLD, 15));
        addItem.setForeground(new Color(145, 17, 245));
        addItem.setFont(new Font("helvetica", Font.BOLD, 15));
        
        shorts = new JLabel("Shorts"); 
        bloomer = new JLabel("Bloomer");
        tracksuit = new JLabel("Tracksuit"); 
        shoes = new JLabel("Sports shoes"); 
        wrapper = new JLabel("Wrapper");
        socks = new JLabel("Socks"); 
        hockey = new JLabel("Hockey sticks"); 
        tshirt = new JLabel("T-shirt");
        shortsvalue = new JLabel("-----"); 
        bloomervalue = new JLabel("-----");
        tracksuitvalue = new JLabel("-----");
        shoesvalue = new JLabel("-----");
        wrappervalue = new JLabel("-----"); 
        socksvalue = new JLabel("-----");
        hockeyvalue = new JLabel("-----");
        tshirtvalue = new JLabel("-----");
        shortsfield = new JTextField(5); bloomerfield= new JTextField(5); 
        tracksuitfield = new JTextField(5); shoesfield = new JTextField(5); 
        wrapperfield = new JTextField(5); socksfield = new JTextField(5);
        hockeyfield = new JTextField(5); tshirtfield = new JTextField(5);
        addShort = new JButton("update"); 
        addShort.setBackground(new Color(145, 17, 245));
        addShort.setForeground(Color.WHITE);
        addShort.setBorderPainted(false);
        addBloomer = new JButton("update"); 
        addBloomer.setBackground(new Color(145, 17, 245));
        addBloomer.setForeground(Color.WHITE);
        addBloomer.setBorderPainted(false);
        addTracksuit = new JButton("update");
        addTracksuit.setBackground(new Color(145, 17, 245));
        addTracksuit.setForeground(Color.WHITE);
        addTracksuit.setBorderPainted(false);
        addShoe = new JButton("update");
        addShoe.setBackground(new Color(145, 17, 245));
        addShoe.setForeground(Color.WHITE);
        addShoe.setBorderPainted(false);
        addWrapper = new JButton("update");
        addWrapper.setBackground(new Color(145, 17, 245));
        addWrapper.setForeground(Color.WHITE);
        addWrapper.setBorderPainted(false);
        addSocks = new JButton("update");
        addSocks.setBackground(new Color(145, 17, 245));
        addSocks.setForeground(Color.WHITE);
        addSocks.setBorderPainted(false);
        addHockey = new JButton("update");
        addHockey.setBackground(new Color(145, 17, 245));
        addHockey.setForeground(Color.WHITE);
        addHockey.setBorderPainted(false);
        addTshirt = new JButton("update");
        addTshirt.setBackground(new Color(145, 17, 245));
        addTshirt.setForeground(Color.WHITE);
        addTshirt.setBorderPainted(false);        
        fetchCurrentStockLevels();
        
        addShort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStockLevel("Games Shorts", shortsfield);
            }
        });
        add(item); add(currentLevel); add(addItem, "wrap");
        add(shorts); add(shortsvalue); add(shortsfield); add(addShort);
        add(bloomer); add(bloomervalue); add(bloomerfield); add(addBloomer);
        add(tracksuit); add(tracksuitvalue); add(tracksuitfield); add(addTracksuit);
        add(shoes); add(shoesvalue); add(shoesfield); add(addShoe);
        add(wrapper); add(wrappervalue); add(wrapperfield); add(addWrapper);
        add(socks); add(socksvalue); add(socksfield); add(addSocks);
        add(hockey); add(hockeyvalue); add(hockeyfield); add(addHockey); 
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

         
    }

    private void fetchCurrentStockLevels() {
        try {            
            String[] itemNames = {
                "Games Shorts", "Bloomer", "Track suit", "Sports shoes", "Wrapper", "Socks", "Hockey stick", "T-shirt"
            };
            JLabel[] valueLabels = {
                shortsvalue, bloomervalue, tracksuitvalue, shoesvalue, wrappervalue, socksvalue, hockeyvalue, tshirtvalue
            };
            for (int i = 0; i < itemNames.length; i++) {
                String itemName = itemNames[i];
                JLabel valueLabel = valueLabels[i];
                Connection connection = DBConnectionManager.getConnection();
                String query = "SELECT stock_level FROM items WHERE item_name = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, itemName);
                
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int StockLevel = resultSet.getInt(1);
                    valueLabel.setText(String.valueOf(StockLevel));
                }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    
    private void updateStockLevel(String itemName, JTextField textField) {
    try {
        // Get the current stock level from the database
        String query = "SELECT stock_level FROM items WHERE item_name = ?";
        PreparedStatement selectStatement = connection.prepareStatement(query);
        selectStatement.setString(1, itemName);
        ResultSet resultSet = selectStatement.executeQuery();
        
        if (resultSet.next()) {
            int currentStockLevel = resultSet.getInt("stock_level");
            int newStockLevel = currentStockLevel + Integer.parseInt(textField.getText());

            // Update the stock level in the database
            String updateQuery = "UPDATE items SET stock_level = ? WHERE item_name = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setInt(1, newStockLevel);
            updateStatement.setString(2, itemName);
            int updatedRows = updateStatement.executeUpdate();

            if (updatedRows > 0) {
                // Successfully updated the stock level in the database
                JOptionPane.showMessageDialog(null, "Stock level updated for " + itemName, "Success", JOptionPane.INFORMATION_MESSAGE);
                fetchCurrentStockLevels(); // Refresh the displayed stock levels
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update stock level for " + itemName, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println(e);
        JOptionPane.showMessageDialog(null, "Error occurred while updating stock level", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }


}
