import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class deregistrationWindow{
    private JFrame frame = new JFrame();
    private JLabel memberIdLabel, searchLabel, resultLabel;
    private JTextField memberIdField;
    private JButton deregisterButton, searchButton;
    private JPanel mainPanel;
    private JTable resultTable;
    private JScrollPane resultScrollPane;
    
    public deregistrationWindow(){
        frame.setBackground(Color.WHITE);
        frame.setSize(300,200);
        
        searchLabel = new JLabel("Search member using a member ID");
        memberIdLabel = new JLabel("Enter Member ID: ");
        memberIdField = new JTextField(15);
        searchButton = new JButton("Search");
        //the label below will display the name of member you want to deregister
        resultLabel = new JLabel("<<Member ID>> : <<Name>>");
        deregisterButton = new JButton("Deregister");
        mainPanel = new JPanel(new FlowLayout());

        searchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("<<Member ID>> : <<Name>>");
            }            
        });
        
        deregisterButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainPanel, "<<name>> deregistered successfully");
                frame.dispose();
            }            
        });
        mainPanel.add(searchLabel);
        mainPanel.add(memberIdLabel);
        mainPanel.add(memberIdField);
        mainPanel.add(searchButton);
        mainPanel.add(resultLabel);
        mainPanel.add(deregisterButton);

        frame.add(mainPanel);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
    }
}
