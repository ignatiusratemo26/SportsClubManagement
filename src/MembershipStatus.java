import net.miginfocom.swing.MigLayout;
import javax.swing.*;

public class MembershipStatus extends JFrame {
    private JTextField institutionField, contactField, dobField, heightField, nameField;
    private JTextField nokField, weightField;
    private JComboBox gameField, subcountyField, genderField, facilitationField, regFeeField;
    private JLabel institutionLabel, contactLabel, dobLabel, gameLabel, genderLabel, heightLabel, nameLabel;
    private JLabel nokLabel, regFeeLabel, subcountyLabel, weightLabel;
    private JButton clearButton, submitButton;
    
    
    private JLabel nameL, ageL, genderL,nokL, dobL, subCountyL;
    private JTextField nameT, ageT, genderT,nokT, dobT, subCountyT;
    String[] genderOptions = {"Male", "Female", "Other"};
    private JComboBox genderCombo;
    private JPanel mainPanel;
    public MembershipStatus() {
        setSize(1100, 600);
        
        mainPanel = new JPanel(new MigLayout("wrap", "[grow, fill]", "5:push[]"));
        
        nameLabel = new JLabel("Name");
        nameLabel.setToolTipText("Enter your full name");
        institutionLabel = new JLabel("Institution");
        genderLabel = new JLabel("Gender");
        nokLabel = new JLabel("Next Of Kin");
        dobLabel = new JLabel("Date of Birth");
        contactLabel = new JLabel("Contact");
        subcountyLabel = new JLabel("Sub County");
        gameLabel = new JLabel("Sport of interest");
        nameField = new JTextField(12);
        institutionField = new JTextField(12);
        String gender[] = {"","Male", "Female"};
        genderField = new JComboBox(gender);
        nokField = new javax.swing.JTextField(12);
        dobField = new JTextField(12);
        String games [] = {"", "Badminton","Baseball","Basketball","Chess", "Darts","Draft",
            "Football", "Hockey", "Lawn tennis", "Netball" ,"Pool", "Swimming", "Table tennis", "Tennis",  "Volleyball",
               "Rugby"};
        gameField = new JComboBox(games);
        contactField = new JTextField(12);
        String subcounties [] = {"","Majirani","Kongoea", "Huckleberry","Watamu", "Nashville", "Dakota"};
        subcountyField = new JComboBox(subcounties);        
        weightLabel = new JLabel("weight(kg)");
        heightLabel = new JLabel("height(m)");
        regFeeLabel = new JLabel("registration");
        weightField = new JTextField(12);
        heightField = new JTextField(12);
        String [] choice = {"", "individual", "group"};
        regFeeField = new JComboBox(choice);
        clearButton = new JButton("Clear");
        submitButton = new JButton("Submit");

        mainPanel.add(nameLabel);
        mainPanel.add(nameField, "wrap");
        mainPanel.add(nokLabel);
        mainPanel.add(nokField, "wrap");
        mainPanel.add(genderLabel);
        mainPanel.add(genderField, "wrap");
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
    }
}

