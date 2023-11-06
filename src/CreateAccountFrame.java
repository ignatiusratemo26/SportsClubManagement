import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import java.sql.*;

public class CreateAccountFrame extends JFrame{
    private JLabel usernameLabel, passwordLabel, skipLabel;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JButton createAccountButton;
    Connection connection = DBConnectionManager.getConnection();
    public CreateAccountFrame(){
        setSize(400,200);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Login");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Passsword: ");
        usernameText = new JTextField(12);
        passwordText = new JPasswordField(12);
        createAccountButton = new JButton("Create account");
        createAccountButton.setBackground(new Color(145, 17, 245));
        createAccountButton.setForeground(Color.WHITE);
        
        skipLabel = new JLabel("Login");
        skipLabel.setForeground(Color.blue);
        
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gConstraint = new GridBagConstraints();
        setLayout(gridBag);
        gConstraint.weighty = 1.0;
        gConstraint.insets = new Insets(4,4,0,0); //slightly top left

        gConstraint.anchor = GridBagConstraints.EAST;        
        gConstraint.gridwidth = GridBagConstraints.RELATIVE;
        gridBag.setConstraints(usernameLabel, gConstraint);
        
        gConstraint.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(usernameText, gConstraint);
        
        gConstraint.gridwidth = GridBagConstraints.RELATIVE; 
        gridBag.setConstraints(passwordLabel, gConstraint);
        
        gConstraint.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(passwordText, gConstraint);
        
        gConstraint.gridwidth = GridBagConstraints.WEST; 
        gridBag.setConstraints(skipLabel, gConstraint);
        
        gConstraint.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(createAccountButton, gConstraint);
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameText.getText();
                char[] password = passwordText.getPassword();

                if (isValidInput(username, password)) {
                    if (createNewUser(username, new String(password))) {
                        JOptionPane.showMessageDialog(CreateAccountFrame.this, "Account Created Successfully.");
                        new LoginFrame();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(CreateAccountFrame.this, "Failed to create the account");
                    }
                } else {
                    JOptionPane.showMessageDialog(CreateAccountFrame.this, "Invalid username or password. \nUsername and password should not be null and must be at least 4 characters long.");
                }
            }
        });
        skipLabel.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginFrame();
                dispose();
               }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                skipLabel.setForeground(Color.red);}
            @Override
            public void mouseExited(MouseEvent e) {
                skipLabel.setForeground(Color.blue);}            
        });     
        
        
        add(usernameLabel);
        add(usernameText);
        add(passwordLabel);
        add(passwordText);
        add(skipLabel);
        add(createAccountButton);        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private boolean isValidInput(String username, char[] password) {
        return username != null && !username.trim().isEmpty() && password != null && password.length >= 4;
    }
    private boolean createNewUser(String username, String password) {
        Connection connection = DBConnectionManager.getConnection();
        String query = "INSERT INTO authentication (username, pass_word) VALUES (?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // User account created successfully
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Account creation failed
        return false;
    }

    
}
