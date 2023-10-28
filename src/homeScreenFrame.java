import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class homeScreenFrame extends JFrame{
    //instantiating the labels that will act as the application's menu(clickable labels)
    private JLabel memberTitle, shopStockTitle, viewReportTitle, facilitationTitle, registrationLabel, deregistrationLabel;
    private JLabel checkMembershipLabel, shopLabel, updateStockLabel, addItemsLabel, viewLabel, reportLabel;
    private JLabel discardLabel, facilitationLabel, groupMembershipLabel, sportsDetailsLabel;
    
    public homeScreenFrame(){

        getContentPane().setBackground(new Color(31,81,255));
        setSize(800, 480);
        setLayout(new GridLayout(4,3));
        setTitle("MARINGO SPORTS CLUB SYSTEM");
        memberTitle = new JLabel();
        memberTitle.setIcon(new ImageIcon(getClass().getResource("/imagesFolder/membershipTitleIcon.png")));
        shopStockTitle = new JLabel();
        shopStockTitle.setIcon(new ImageIcon(getClass().getResource("/imagesFolder/shopStockTitleIcon.png")));
        viewReportTitle = new JLabel();
        viewReportTitle.setIcon(new ImageIcon(getClass().getResource("/imagesFolder/viewReportTitleIcon.png")));
        facilitationTitle = new JLabel();
        facilitationTitle.setIcon(new ImageIcon(getClass().getResource("/imagesFolder/facilitationTitleIcon.png")));
        registrationLabel = new JLabel();
        registrationLabel.setIcon(new ImageIcon(getClass().getResource("/imagesFolder/registrationIcon.png")));
        deregistrationLabel = new JLabel();
        deregistrationLabel.setIcon(new ImageIcon(getClass().getResource("/imagesFolder/deregistrationIcon.png")));
        checkMembershipLabel = new JLabel();
        checkMembershipLabel.setIcon(new ImageIcon(getClass().getResource("/imagesFolder/memberStatusIcon.png")));
        shopLabel = new JLabel();
        shopLabel.setIcon(new ImageIcon(getClass().getResource("/imagesFolder/shopIcon.png")));
        updateStockLabel = new JLabel();
        updateStockLabel.setIcon(new ImageIcon(getClass().getResource("/imagesFolder/updateStockIcon.png")));
        addItemsLabel = new JLabel();
        addItemsLabel.setIcon(new ImageIcon(getClass().getResource("/imagesFolder/addItemsIcon.png")));
        viewLabel = new JLabel();
        viewLabel.setIcon(new ImageIcon(getClass().getResource("/imagesFolder/viewIcon.png")));
        reportLabel = new JLabel();
        reportLabel.setIcon(new ImageIcon(getClass().getResource("/imagesFolder/reportIcon.png")));
        discardLabel = new JLabel();
        discardLabel.setIcon(new ImageIcon(getClass().getResource("/imagesFolder/discardIcon.png")));
        facilitationLabel = new JLabel();
        facilitationLabel.setIcon(new ImageIcon(getClass().getResource("/imagesFolder/gameFacilitationIcon.png")));
        groupMembershipLabel = new JLabel();
        groupMembershipLabel.setIcon(new ImageIcon(getClass().getResource("/imagesFolder/groupMembershipIcon.png")));
        sportsDetailsLabel = new JLabel();
        sportsDetailsLabel.setIcon(new ImageIcon(getClass().getResource("/imagesFolder/sportsDetailsIcon.png")));

        registrationLabel.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                new registrationWindow();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}   });
        deregistrationLabel.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                new deregistrationWindow();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}   });
        checkMembershipLabel.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                new CheckStatusFrame();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}  });       
                
        viewLabel.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                new ViewDamageWindow();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}        });
        shopLabel.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                new purchaseWindow();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}        });
        
        reportLabel.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                new reportWindow();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}        });
        
        updateStockLabel.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                new updateStockWindow();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}        });
        addItemsLabel.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(addItemsLabel, "You cannot add any item currently.");
               }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}        });
        
        add(memberTitle); add(shopStockTitle); add(viewReportTitle); //add(facilitationTitle);
        add(registrationLabel);add(shopLabel); add(viewLabel); //add(facilitationLabel);
        add(deregistrationLabel); add(updateStockLabel); add(reportLabel); //add(groupMembershipLabel);
        add(checkMembershipLabel); add(addItemsLabel); add(discardLabel);// add(sportsDetailsLabel);
        
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
