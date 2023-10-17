import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;

public class updateStockWindow extends JFrame{
    private JPanel mainPanel;
    private JLabel item,currentLevel, addItem;
    private JLabel shorts, bloomer, tracksuit, shoes, wrapper, socks, hockey, tshirt;
    private JLabel shortsvalue, bloomervalue, tracksuitvalue, shoesvalue, wrappervalue, socksvalue, hockeyvalue, tshirtvalue;
    private JButton addShort, addBloomer, addTracksuit, addShoe, addWrapper,addSocks, addHockey,addTshirt;
    private JTextField shortsfield, bloomerfield, tracksuitfield, shoesfield, wrapperfield, socksfield, hockeyfield, tshirtfield;
    public updateStockWindow (){
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
        
        
        add(item); add(currentLevel); add(addItem, "wrap");
        add(shorts); add(shortsvalue); add(shortsfield); add(addShort);
        add(bloomer); add(bloomervalue); add(bloomerfield); add(addBloomer);
        add(tracksuit); add(tracksuitvalue); add(tracksuitfield); add(addTracksuit);
        add(shoes); add(shoesvalue); add(shoesfield); add(addShoe);
        add(wrapper); add(wrappervalue); add(wrapperfield); add(addWrapper);
        add(socks); add(socksvalue); add(socksfield); add(addSocks);
        add(hockey); add(hockeyvalue); add(hockeyfield); add(addHockey); 
        //add(); add(); add(); add(); add(); add(); add();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    
}
