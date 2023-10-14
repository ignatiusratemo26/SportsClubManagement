import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class registrationWindow extends JFrame{
    private JPanel registerPanel = new JPanel();
    private JPanel regButtonPanel = new JPanel();
    //components in the memberRegistration panel
    private JTextField institutionField, contactField, dobField, heightField, nameField;
    private JTextField nokField, weightField;
    private JComboBox gameField, subcountyField, genderField, facilitationField, regFeeField;
    private JLabel institutionLabel, contactLabel, dobLabel, gameLabel, genderLabel, heightLabel, nameLabel;
    private JLabel nokLabel, regFeeLabel, subcountyLabel, weightLabel;
    private JButton clearButton, submitButton;
    
    //sql connectivity
    private final String db_url = "jdbc:mysql://localhost:3306/testdb";
    private final String db_driver = "com.mysql.jdbc.Driver";
    private final String db_username = "root";
    private final String db_password = "18145C3iggy?";
    
    public registrationWindow(){
        setSize(700, 500);
        registerPanel.setPreferredSize(new Dimension(700,500));
        //Components in the member panel
        nameLabel = new JLabel();
        institutionLabel = new JLabel();
        genderLabel = new JLabel();
        nokLabel = new JLabel();
        dobLabel = new JLabel();
        contactLabel = new JLabel();
        subcountyLabel = new JLabel();
        gameLabel = new JLabel();
        nameField = new JTextField(20);
        institutionField = new JTextField(20);
        String gender[] = {"","Male", "Female"};
        genderField = new JComboBox(gender);
        nokField = new javax.swing.JTextField(20);
        dobField = new JTextField(20);
        String games [] = {"", "Badminton","Baseball","Basketball","Chess", "Darts","Draft",
            "Football", "Hockey", "Lawn tennis", "Netball" ,"Pool", "Swimming", "Table tennis", "Tennis",  "Volleyball",
               "Rugby"};
        gameField = new JComboBox(games);
        contactField = new JTextField(20);
        String subcounties [] = {"","Majirani","Kongoea", "Huckleberry","Watamu", "Nashville", "Dakota"};
        subcountyField = new JComboBox(subcounties);        
        weightLabel = new JLabel();
        heightLabel = new JLabel();
        regFeeLabel = new JLabel();
        weightField = new JTextField(20);
        heightField = new JTextField(20);
        String [] choice = {"", "individual", "group"};
        regFeeField = new JComboBox(choice);
        clearButton = new JButton();
        submitButton = new JButton();
        nameLabel.setText("Name");
        nameLabel.setToolTipText("Enter your full name");
        institutionLabel.setText("Institution");
        genderLabel.setText("Gender");
        nokLabel.setText("Next of Kin");
        dobLabel.setText("DOB");
        contactLabel.setText("Contact");
        subcountyLabel.setText("Sub County");
        gameLabel.setText("Game of interest");
        weightLabel.setText("weight");
        heightLabel.setText("height");
        regFeeLabel.setText("registration");
        clearButton.setText("Clear");
        submitButton.setText("Submit");

        //I've created a panel that will have member registration details and the required buttons
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(regButtonPanel);
        regButtonPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(clearButton)
                .addGap(75, 75, 75)
                .addComponent(submitButton)
                .addGap(0, 336, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton)
                    .addComponent(submitButton))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout registrationPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanel.setLayout(registrationPanelLayout);
        registrationPanelLayout.setHorizontalGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(registrationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(registrationPanelLayout.createSequentialGroup()
                        .addComponent(subcountyLabel, GroupLayout.DEFAULT_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(subcountyField, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))

                    .addGroup(registrationPanelLayout.createSequentialGroup()
                        .addGroup(registrationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(registrationPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nokLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(registrationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(genderLabel, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                    .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(institutionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(dobLabel)
                            .addComponent(contactLabel))
                        .addGap(18, 18, 18)
                        .addGroup(registrationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(dobField, GroupLayout.PREFERRED_SIZE, 100,javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contactField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addGroup(registrationPanelLayout.createSequentialGroup()
                                .addGroup(registrationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(institutionField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genderField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nokField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                .addGap(76, 76, 76)
                                .addGroup(registrationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(gameLabel)
                                    .addComponent(weightLabel)
                                    .addComponent(heightLabel)
                                    .addComponent(regFeeLabel))
                                .addGap(37, 37, 37)
                                .addGroup(registrationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(regFeeField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(heightField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(weightField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gameField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(regButtonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registrationPanelLayout.setVerticalGroup(registrationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(registrationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(registrationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameLabel)
                    .addComponent(gameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(registrationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(institutionLabel)
                    .addComponent(institutionField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(weightLabel)
                    .addComponent(weightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(registrationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLabel)
                    .addComponent(genderField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(heightLabel)
                    .addComponent(heightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(registrationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nokLabel)
                    .addComponent(nokField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(regFeeLabel)
                    .addComponent(regFeeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(registrationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dobLabel)
                    .addComponent(dobField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(registrationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(contactLabel)
                    .addComponent(contactField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subcountyLabel)
                    .addComponent(subcountyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regButtonPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        add(registerPanel);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
        /*
        String name = nameField.getText();
        , , dobField, genderField, heightField, ;
    private JTextField nokField, regFeeField, weightField;
    private JComboBox gameField, subcountyField
*/
    }
    //thinkOfaMethod();
    
}
