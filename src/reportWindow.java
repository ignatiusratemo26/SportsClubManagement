import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class reportWindow extends JFrame{
    private JPanel reportPanel;
    private JLabel viewLabel,viewText, reportLabel, reportText;
    private JPanel resultPanel;
    private JFrame reportFrame, viewEqpFrame;
    private JTable lostAndDamagedTable; 
    private JScrollPane resultScrollPane;
    private JTextField eqptLossField, memberIdField;
    private JLabel eqptLossLabel, memberIdLabel, damageFeeLabel, damageFeeField;
    private JButton reportButton, calculateButton;
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
        damageFeeLabel = new JLabel("Damage Fee: ");
        damageFeeField = new JLabel("Ksh. -------");
        reportButton = new JButton("Report");
        //setting the color of the report button to light red using rgb code scheme
        reportButton.setBackground(new Color(255, 127, 127));
        
        reportPanel.add(eqptLossLabel); reportPanel.add(eqptLossField); reportPanel.add(memberIdLabel);
        reportPanel.add(memberIdField); reportPanel.add(calculateButton);reportPanel.add(damageFeeLabel); 
        reportPanel.add(damageFeeField); reportPanel.add(reportButton);
        add(reportPanel);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
}