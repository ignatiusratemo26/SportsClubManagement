import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.miginfocom.swing.MigLayout;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class registrationWindow extends JFrame {
    private JTextField institutionField, contactField, dobField, heightField, nameField;
    private JTextField nokField, weightField;
    private JComboBox gameField, subcountyField, genderField, facilitationField, regFeeField;
    private JLabel institutionLabel, contactLabel, dobLabel, gameLabel, genderLabel, heightLabel, nameLabel;
    private JLabel nokLabel, regFeeLabel, subcountyLabel, weightLabel;
    private JButton clearButton, submitButton;
    private JPanel mainPanel;
    private int game_id= 0;
    private String genderText= "";
        //sql connectivity
    Connection connection = DBConnectionManager.getConnection();
    
    public registrationWindow() {
        setSize(680,600);
        setTitle("Registration page");
        // in the miglayout, 1st parameter: general layout, 2nd parameter: columns & spacing, 3rd: rows & spacing
        mainPanel = new JPanel(new MigLayout("wrap, insets 20, fill", "[]2[]2[]", "10"));
        mainPanel.setBackground(Color.WHITE);
        nameLabel = new JLabel("Full Name");
        nameLabel.setToolTipText("Enter your full name");
        institutionLabel = new JLabel("Institution");
        genderLabel = new JLabel("Gender");
        nokLabel = new JLabel("Next Of Kin(contact)");
        dobLabel = new JLabel("Date of Birth (yyyy-mm-dd)");
        contactLabel = new JLabel("Contact");
        subcountyLabel = new JLabel("Sub County");
        gameLabel = new JLabel("Sport of interest");
        nameField = new JTextField(8);
        institutionField = new JTextField(8);
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female= new JRadioButton("Female");
        ButtonGroup gp = new ButtonGroup();
        gp.add(male);
        gp.add(female);
        
        String gender[] = {"Select gender","Male", "Female"};
        genderField = new JComboBox(gender);
        nokField = new javax.swing.JTextField(8);
        dobField = new JTextField(8);
        
        String games [] = {"", "Badminton","Baseball","Basketball","Chess", "Darts","Draft",
            "Football", "Hockey", "Lawn tennis", "Netball" ,"Pool", "Swimming", "Table tennis", "Tennis",  "Volleyball",
               "Rugby"};
                
        gameField = new JComboBox(games);
        contactField = new JTextField(8);
        String subcounties [] = {"","Majirani","Kongoea", "Huckleberry","Watamu", "Nashville", "Dakota"};
        subcountyField = new JComboBox(subcounties);        
        weightLabel = new JLabel("weight(kg)");
        heightLabel = new JLabel("height(m)");
        regFeeLabel = new JLabel("registration");
        weightField = new JTextField(8);
        heightField = new JTextField(8);
        String [] choice = {"", "individual", "group"};
        regFeeField = new JComboBox(choice);
        clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(200, 17, 17));
        clearButton.setForeground(Color.WHITE);
        clearButton.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        submitButton = new JButton("Submit");
        submitButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        submitButton.setBackground(new Color(145, 17, 245));
        submitButton.setForeground(Color.WHITE);           
        submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String nok = nokField.getText();
            if (male.isSelected()){
                genderText = "male";
            }
            else
                genderText = "female";
            String dob = dobField.getText();  
            // Validate date of birth (DOB)
                if (!dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    JOptionPane.showMessageDialog(null, "Invalid date of birth. Please use the format yyyy-mm-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            
            
            int contact = Integer.parseInt(contactField.getText());
            String subcounty = subcountyField.getSelectedItem().toString();
            String institution = institutionField.getText();  
            switch (gameField.getSelectedItem().toString()) {
            case "Badminton":
                game_id = 6;
                break;
            case "Baseball":
                game_id = 11;
                break;
            case "Basketball":
                game_id = 8;
                break;
            case "Chess":
                game_id = 14;
                break;
            case "Darts":
                game_id = 5;
                break;
            case "Draft":
                game_id = 15;
                break;
            case "Football":
                game_id = 10;
                break;
            case "Hockey":
                game_id = 2;
                break;
            case "Lawn tennis":
                game_id = 3;
                break;
            case "Netball":
                game_id = 9;
                break;
            case "Pool":
                game_id = 13;
                break;
            case "Swimming":
                game_id = 1;
                break;
            case "Table Tennis":
                game_id = 4;
                break;
            case "Lawn Tennis":
                game_id = 3;
                break;
            case "Volleyball":
                game_id = 7;
                break;
            case "Rugby":
                game_id = 12;
                break;
            } 
            String weight = weightField.getText();
            String height = heightField.getText();
            // Validate weight and height (optional, you can modify the regex as needed)
                if (!weight.matches("\\d+(\\.\\d+)?")) {
                    JOptionPane.showMessageDialog(null, "Invalid weight. Please enter a valid numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!height.matches("\\d+(\\.\\d+)?")) {
                    JOptionPane.showMessageDialog(null, "Invalid height. Please enter a valid numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
            String fee = regFeeField.getSelectedItem().toString();
            
            
            // Validate contact number
                try {
                    contact = Integer.parseInt(contactField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid contact number. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate date of birth (DOB)
                if (!dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    JOptionPane.showMessageDialog(null, "Invalid date of birth. Please use the format yyyy-mm-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int registration_fee;

                if (fee.equals("Individual")) {
                    registration_fee = 1000;
                } else
                    registration_fee = 500;

                if (!weight.matches("\\d+(\\.\\d+)?")) {
                    JOptionPane.showMessageDialog(null, "Invalid weight. Please enter a valid numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!height.matches("\\d+(\\.\\d+)?")) {
                    JOptionPane.showMessageDialog(null, "Invalid height. Please enter a valid numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }     

            String query = "INSERT INTO Members "
                    + "(member_name, next_of_kin, gender, dob, contact, subcounty, "
                    + "institution, sport_id, weight, height, registration_fee) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, name);
                ps.setString(2, nok);
                ps.setString(3, genderText);
                ps.setString(4, dob);
                ps.setInt(5, contact);
                ps.setString(6, subcounty);
                ps.setString(7, institution);
                ps.setInt(8, game_id);
                ps.setString(9, weight);
                ps.setString(10, height);
                ps.setInt(11, registration_fee);

                int x = ps.executeUpdate();
                   } catch (SQLException ex) {
                    System.out.println(ex);
                    }
            JOptionPane.showMessageDialog(null, "Registration complete");
            }                       
            });
        
        mainPanel.add(nameLabel);
        mainPanel.add(nameField, "wrap");
        mainPanel.add(nokLabel);
        mainPanel.add(nokField, "wrap");
        mainPanel.add(genderLabel);
        mainPanel.add(female);
        mainPanel.add(male, "wrap");        
        mainPanel.add(dobLabel);
        mainPanel.add(dobField, "wrap");
        mainPanel.add(contactLabel);
        mainPanel.add(contactField, "wrap");
        mainPanel.add(subcountyLabel);
        mainPanel.add(subcountyField, "wrap");
        mainPanel.add(institutionLabel);
        mainPanel.add(institutionField, "wrap");
        mainPanel.add(gameLabel);
        mainPanel.add(gameField, "wrap");
        mainPanel.add(weightLabel);
        mainPanel.add(weightField, "wrap");
        mainPanel.add(heightLabel);
        mainPanel.add(heightField, "wrap");
        mainPanel.add(regFeeLabel);
        mainPanel.add(regFeeField, "wrap");
        mainPanel.add(clearButton);
        mainPanel.add(submitButton, "wrap");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().add(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
    } 
}
