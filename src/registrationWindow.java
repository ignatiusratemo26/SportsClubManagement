import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Properties;
import net.miginfocom.swing.MigLayout;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import org.jdatepicker.impl.*;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class registrationWindow extends JFrame {
    private JTextField institutionField, contactField, dobField, heightField, nameField;
    private JTextField nokField, weightField;
    private JComboBox gameField, subcountyField, genderField, facilitationField, regFeeField;
    private JLabel institutionLabel, contactLabel, dobLabel, gameLabel, genderLabel, heightLabel, nameLabel;
    private JLabel nokLabel, regFeeLabel, subcountyLabel, weightLabel;
    private JButton clearButton, submitButton;
    private JPanel mainPanel;
    
        //sql connectivity
    private final String db_url = "jdbc:mysql://localhost:3306/testdb";
    private final String db_driver = "com.mysql.jdbc.Driver";
    private final String db_username = "root";
    private final String db_password = "18145C3iggy?";
    
    
    public registrationWindow() {
        setSize(680,600);
        setTitle("Registration page");
        // in the miglayout, 1st parameter: general layout, 2nd parameter: columns & spacing, 3rd: rows & spacing
        mainPanel = new JPanel(new MigLayout("wrap, insets 20, fill", "[]2[]2[]", "10"));
        mainPanel.setBackground(Color.WHITE);
        nameLabel = new JLabel("Name");
        nameLabel.setToolTipText("Enter your full name");
        institutionLabel = new JLabel("Institution");
        genderLabel = new JLabel("Gender");
        nokLabel = new JLabel("Next Of Kin(contact)");
        dobLabel = new JLabel("Date of Birth");
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
        
        String gender[] = {"","Male", "Female"};
        genderField = new JComboBox(gender);
        nokField = new javax.swing.JTextField(8);
        dobField = new JTextField(8);
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel;
        datePanel = new JDatePanelImpl(model, p);
        //JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        //java.sql.Date dobField = (java.sql.Date) datePicker.getModel().getValue();
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
        //pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    
    public void thinkOfaMethod() throws Exception{
        String name = nameField.getText();
        String age = institutionField.getText();
        String gender = genderField.getSelectedItem().toString();
        String dob = dobField.getText();
        int contact = Integer.parseInt(contactField.getText());
        String subcounty = subcountyField.getSelectedItem().toString();
        int game_id = Integer.parseInt(gameField.getSelectedItem().toString());
        
        String weight = weightField.getText();
        String height = heightField.getText();
        String special_needs = regFeeField.getSelectedItem().toString();
        
        String query = "INSERT INTO Members("+ name +","+ age +","+ gender+ "," + dob + ","
                + ","+ contact +"," +subcounty+ "," + ","+game_id+"," +weight+ ","+ height+ ","+ special_needs+")";

        
        
        Class.forName(db_driver);
        Connection con = DriverManager.getConnection(db_url, db_username, db_password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

    }
    //thinkOfaMethod();
    
}
