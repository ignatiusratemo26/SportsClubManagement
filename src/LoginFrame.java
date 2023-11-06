import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import java.sql.*;

public class LoginFrame extends JFrame{
    private JLabel usernameLabel, passwordLabel, skipLabel;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JButton loginButton;
    public LoginFrame(){
        setSize(400,200);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Login");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Passsword: ");
        usernameText = new JTextField(12);
        passwordText = new JPasswordField(12);
        loginButton = new JButton("login");
        loginButton.setBackground(new Color(145, 17, 245));
        loginButton.setForeground(Color.WHITE);
        skipLabel = new JLabel("Create Account");
        skipLabel.setForeground(Color.blue);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameText.getText();
                char[] password = passwordText.getPassword();

                if (isValidLogin(username, password)) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login successful!");
                    new homeScreenFrame();
                    dispose();
                } else {
                    // Failed login, show an error message
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password");
                }
            }
        });
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
        gridBag.setConstraints(loginButton, gConstraint);
        
        skipLabel.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                new CreateAccountFrame();
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
        add(loginButton);        
        setLocationRelativeTo(null);
        setVisible(true);
    }    
    private boolean isValidLogin(String username, char[] password) {
        Connection connection = DBConnectionManager.getConnection();
        String query = "SELECT * FROM authentication WHERE username = ? AND pass_word = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, new String(password));
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // User found in the database, login is successful
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        return false;
    }
}
